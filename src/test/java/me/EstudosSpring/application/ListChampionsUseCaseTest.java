package me.EstudosSpring.application;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.EstudosSpring.BootCampSantanderweek2024.domain.model.Champions;
import me.EstudosSpring.BootCampSantanderweek2024.BootCampSantanderWeek2024Application;
import me.EstudosSpring.BootCampSantanderweek2024.application.ListChampionsUseCase;

@SpringBootTest(classes = BootCampSantanderWeek2024Application.class) // Especifique a classe principal do Spring Boot
public class ListChampionsUseCaseTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions(){
        List<Champions> champions = listChampionsUseCase.findAll();
        Assertions.assertEquals(12, champions.size());
    }
}
