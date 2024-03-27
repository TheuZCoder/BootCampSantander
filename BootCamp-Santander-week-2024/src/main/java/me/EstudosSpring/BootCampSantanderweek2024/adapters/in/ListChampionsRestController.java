package me.EstudosSpring.BootCampSantanderweek2024.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.EstudosSpring.BootCampSantanderweek2024.application.ListChampionsUseCase;
import me.EstudosSpring.BootCampSantanderweek2024.domain.model.Champions;

@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {
    
    @GetMapping
    public List<Champions> findAllChampions(){
        return useCase.findAll();
    }
}
