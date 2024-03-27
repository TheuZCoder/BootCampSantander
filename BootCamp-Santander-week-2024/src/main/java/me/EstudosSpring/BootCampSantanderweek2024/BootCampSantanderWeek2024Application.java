package me.EstudosSpring.BootCampSantanderweek2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.EstudosSpring.BootCampSantanderweek2024.application.AskChampionsUseCase;
import me.EstudosSpring.BootCampSantanderweek2024.application.ListChampionsUseCase;
import me.EstudosSpring.BootCampSantanderweek2024.domain.ports.ChampionsRepository;

@SpringBootApplication
public class BootCampSantanderWeek2024Application {

    public static void main(String[] args) {
        SpringApplication.run(BootCampSantanderWeek2024Application.class, args);
    }

    @Bean
    public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
        return new ListChampionsUseCase(repository);
    }

    @Bean
    public AskChampionsUseCase provideAskChampionsUseCase(ChampionsRepository repository){
        return new AskChampionsUseCase(repository);
    }
}
