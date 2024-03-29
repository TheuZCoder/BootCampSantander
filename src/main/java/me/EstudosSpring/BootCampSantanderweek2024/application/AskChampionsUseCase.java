package me.EstudosSpring.BootCampSantanderweek2024.application;

import me.EstudosSpring.BootCampSantanderweek2024.domain.exception.ChampionsNotFoundException;
import me.EstudosSpring.BootCampSantanderweek2024.domain.model.Champions;
import me.EstudosSpring.BootCampSantanderweek2024.domain.ports.ChampionsRepository;
import me.EstudosSpring.BootCampSantanderweek2024.domain.ports.GenerativeAiService;

public record AskChampionsUseCase(ChampionsRepository repository, GenerativeAiService genAiApi) {

    public String askChampion(Long championId, String question) {
        Champions champion = repository.findByID(championId)
                .orElseThrow(() -> new ChampionsNotFoundException(championId));


                String championContext = champion.generateContextByQuestion(question);

                String objective ="""
                        Atue como uma assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL)
                        Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                        segue a pergunta, Campeão e sua respectiva lore (História):

                        """;

                return genAiApi.generateContent(objective, championContext);
    }
}
