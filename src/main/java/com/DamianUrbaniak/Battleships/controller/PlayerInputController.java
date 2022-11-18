package com.DamianUrbaniak.Battleships.controller;


import com.DamianUrbaniak.Battleships.model.PlayerInput;
import com.DamianUrbaniak.Battleships.model.PlayerMovement;
import com.DamianUrbaniak.Battleships.service.PlayerInputHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playerInput")
public class PlayerInputController {

    @Autowired
    private final PlayerInputHandler playerInputHandler;

    public PlayerInputController(PlayerInputHandler playerInputHandler) {
        this.playerInputHandler = playerInputHandler;
    }


    @PostMapping("/putShip/{gameStateID}/{playerNumber}")
    public void putShip(@RequestBody PlayerInput playerInput) {

        PlayerMovement playerMovement = playerInputHandler
                .convertingIntoPlayerMovement(playerInput.getPlayerInput());

        playerInputHandler.putShipOnPlayerGrid(playerMovement, id, playernumber);
    }

}
