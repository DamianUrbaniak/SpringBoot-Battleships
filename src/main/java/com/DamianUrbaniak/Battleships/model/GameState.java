package com.DamianUrbaniak.Battleships.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class GameState {

    public static final int DEFAULT_GRID_SIZE = 7;

    private Player currentPlayer = getPlayerByNumber(1);

    private Player winner = null;

    List<Player> players = List.of(new Player(1, new char[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE],
                    new char[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE]),
            new Player(2, new char[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE],
                    new char[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE]));


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayerByNumber(int playerNumber) {
        return players.get(playerNumber - 1);
    }

    public void setCurrentPlayer(int playerNumber) {
        this.currentPlayer = getPlayerByNumber(playerNumber);
    }

    public void setWinner(Player player) {
        winner = player;
    }

    public boolean hasWinner() {
        for (int i = 1; i < 3; i++) {
            int shipsleft = 5;
            char[][] grid = getPlayerByNumber(i).getGivenShots();
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid.length; k++) {
                    if (grid[j][k] == 'X') {
                        shipsleft--;
                    }
                }
                if (shipsleft == 0) {
                    setWinner(getPlayerByNumber(i));
                    System.out.println("Player number " + winner.getPlayerNumber() + " is the winner!");
                    return true;
                }
            }
        }
        return false;
    }
}
