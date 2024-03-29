package me.EstudosSpring.BootCampSantanderweek2024.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.EstudosSpring.BootCampSantanderweek2024.application.AskChampionsUseCase;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do LOL.")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionsUseCase useCase) {

    public record AskChampionRequest(String question) { }
    public record AskChampionResponse(String answer) { }

    @CrossOrigin
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {
        String answer = useCase.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }
}
