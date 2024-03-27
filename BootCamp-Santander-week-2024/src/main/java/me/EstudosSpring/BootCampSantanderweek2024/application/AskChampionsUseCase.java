package me.EstudosSpring.BootCampSantanderweek2024.application;

import me.EstudosSpring.BootCampSantanderweek2024.domain.exception.ChampionsNotFoundException;
import me.EstudosSpring.BootCampSantanderweek2024.domain.model.Champions;
import me.EstudosSpring.BootCampSantanderweek2024.domain.ports.ChampionsRepository;

public record AskChampionsUseCase(ChampionsRepository repository) {

    public String askChampion(Long Championid, String question) {
        Champions champion = repository.findByID(Championid)
                .orElseThrow(() -> new ChampionsNotFoundException(Championid));


                String championContext = champion.generateContextByQuestion(question);
        // TODO: Evoluir a lofica de negocio para considerar a integração com IAS
        // generativas

        return championContext;
    }
}
