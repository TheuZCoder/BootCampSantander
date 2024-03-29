package me.EstudosSpring.BootCampSantanderweek2024.domain.ports;

import java.util.List;
import java.util.Optional;

import me.EstudosSpring.BootCampSantanderweek2024.domain.model.Champions;

public interface ChampionsRepository {

    List<Champions> findAll();
    
    Optional<Champions> findByID(Long id);

}
