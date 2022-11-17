package com.DamianUrbaniak.Battleships.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Player {

    //        private final String name;

    private int playerNumber;

    public int getPlayerNumber() {
        return playerNumber;
    }

    private char gameGrid[][];

    private char givenShots[][];


    public Player(int playerNumber, char[][] gameGrid, char[][] givenShots) {
        this.playerNumber = playerNumber;
        this.gameGrid = gameGrid;
        this.givenShots = givenShots;
    }

    public char[][] getGameGrid() {
        return gameGrid;
    }

    public char[][] getGivenShots() {
        return givenShots;
    }
}
