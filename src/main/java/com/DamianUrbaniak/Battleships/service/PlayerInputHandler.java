package com.DamianUrbaniak.Battleships.service;



import com.DamianUrbaniak.Battleships.model.PlayerMovement;
import com.DamianUrbaniak.Battleships.model.GameState;
import com.DamianUrbaniak.Battleships.repository.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class PlayerInputHandler {

    private final GameStateRepository gameStateRepository;

    @Autowired
    public PlayerInputHandler(GameStateRepository gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    public PlayerMovement convertingIntoPlayerMovement(String playerInput) {
        String[] coordinates = playerInput.split(",");

        return new PlayerMovement(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    public void putShipOnPlayerGrid(PlayerMovement playerMovement, Long id, int playerNumber) {

        GameState gm = gameStateRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                "Unexpected error"
        ));
        char[][] playerGrid = gm.getPlayerByNumber(1).getGameGrid();
        int x = playerMovement.getX();
        int y = playerMovement.getY();

        if (playerGrid[y][x] == '█') {
            throw new IllegalArgumentException(
                    "Move with that coordinates was already made"
            );
        }

        if (playerGrid[y][x] != '█') {
            playerGrid[y][x] = '█';
        }
    }

    public void fire(PlayerMovement playerMovement, Long id, int playerNumber) {
        GameState gm = gameStateRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                "Unexpected error"
        ));

        int attacker = 0;
        int defender = 0;
        if (playerNumber == 1) {
            attacker = 1;
            defender = 2;
        } else {
            attacker = 2;
            defender = 1;
        }

        char[][] gridUnderTheFire = gm.getPlayerByNumber(defender).getGameGrid();
        char[][] attackerMarkingGrid = gm.getPlayerByNumber(attacker).getGivenShots();
        int x = playerMovement.getX();
        int y = playerMovement.getY();

        if (attackerMarkingGrid[y][x] == 'X' ||
                attackerMarkingGrid[y][x] == '-') {
            throw new IllegalArgumentException(
                    "Shoot with that coordinates was already given"
            );
        }

        if (gridUnderTheFire[y][x] == '█') {
            attackerMarkingGrid[y][x] = 'X';
            gridUnderTheFire[y][x] = 'X';
//            ui.println("BOOOM!!! You have hit the target! ");
        } else {
            attackerMarkingGrid[y][x] = '-';
//            ui.println("You have missed.");
        }



    }
}
