package com.DamianUrbaniak.Battleships.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class PlayerInput {


    @Pattern(regexp = "\\[?\\d+,\\d+]?",
            message = "Coordinates should be ine the format [x, y], skip the brackets.")
    @Pattern(regexp = "^([0-6](,)[0-6])$",
            message = "Given coordinates are out of grid scope!")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final String playerInput;

}
