package lomayd.parentingsim.api.domain.scenario.dto;

import lomayd.parentingsim.api.domain.scenario.ScenarioResult;
import lombok.*;

public class ScenarioResultResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChoiceResult {

        private int id;
        private int scenario;
        private boolean is_correct;
        private String script;


        public static ScenarioResultResponseDto.ChoiceResult of(ScenarioResult scenarioResult) {
            return ChoiceResult.builder()
                    .id(scenarioResult.getId())
                    .scenario(scenarioResult.getScenario().getId())
                    .is_correct(scenarioResult.is_correct())
                    .script(scenarioResult.getScript())
                    .build();
        }
    }
}
