package com.DamianUrbaniak.Battleships.repository;

import com.DamianUrbaniak.Battleships.model.GameState;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameStateRepository extends CrudRepository<GameState, Long> {

    @Query("SELECT g FROM GameState g WHERE g.id = ?1")
    Optional<GameState> findStudentByEmail(String email);
}
