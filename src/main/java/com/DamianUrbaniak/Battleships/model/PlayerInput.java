package com.DamianUrbaniak.Battleships.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class PlayerInput {


    @Pattern(regexp = "\\[?\\d+,\\d+]?",
            message = "Coordinates should be ine the format [x, y], skip the brackets.")
    @Pattern(regexp = "^([0-6](,)[0-6])$",
            message = "Given coordinates are out of grid scope!")
    private final String playerInput;

}
