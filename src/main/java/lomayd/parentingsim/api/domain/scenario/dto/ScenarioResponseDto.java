package lomayd.parentingsim.api.domain.scenario.dto;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lombok.*;

@RequiredArgsConstructor
public class ScenarioResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScenarioScript {

        private int id;
        private int episode;
        private String illustration;
        private String script;
        private int choice_1_id;
        private String choice_1_script;
        private int choice_2_id;
        private String choice_2_script;
        private int choice_3_id;
        private String choice_3_script;
        private int choice_4_id;
        private String choice_4_script;
        private boolean end;

        public static ScenarioResponseDto.ScenarioScript of(Scenario scenario) {

            return ScenarioScript.builder()
                    .id(scenario.getId())
                    .episode(scenario.getEpisode())
                    .illustration(scenario.getIllustration())
                    .script(scenario.getScript())
                    .choice_1_id(scenario.getChoice_1())
                    .choice_1_script(scenario.getChoice_1_script())
                    .choice_2_id(scenario.getChoice_2())
                    .choice_2_script(scenario.getChoice_2_script())
                    .choice_3_id(scenario.getChoice_3())
                    .choice_3_script(scenario.getChoice_3_script())
                    .choice_4_id(scenario.getChoice_3())
                    .choice_4_script(scenario.getChoice_3_script())
                    .end(scenario.isEnd())
                    .build();
        }
    }
}
