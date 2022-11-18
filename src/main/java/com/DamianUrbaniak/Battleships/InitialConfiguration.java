package com.DamianUrbaniak.Battleships;


import com.DamianUrbaniak.Battleships.model.GameState;
import com.DamianUrbaniak.Battleships.repository.GameStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitialConfiguration {

    @Bean
    public CommandLineRunner startGame(GameStateRepository gameStateRepository) {
        return args -> {

            gameStateRepository.save(new GameState());


        };
    }
}
