package me.EstudosSpring.BootCampSantanderweek2024.adapters.in;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.EstudosSpring.BootCampSantanderweek2024.application.AskChampionsUseCase;

@Tag(name = "Campeõs", description = "Endpoints do domínio de Campeões do Lol")
@RestController
@RequestMapping("/champions")
public record AskChampioRestController(AskChampionsUseCase useCase) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampions(@PathVariable Long championId,@RequestBody AskChampionRequest request) {
        
        String answer = useCase.askChampion(championId, request.question());
        
        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question) { }

    public record AskChampionResponse(String answer) { }
}
