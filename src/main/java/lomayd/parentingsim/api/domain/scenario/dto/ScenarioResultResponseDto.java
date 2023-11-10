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
        private boolean correct;
        private String script;
        private String correct_script;


        public static ScenarioResultResponseDto.ChoiceResult of(ScenarioResult scenarioResult, String correct_script) {
            return ChoiceResult.builder()
                    .id(scenarioResult.getId())
                    .scenario(scenarioResult.getScenario().getId())
                    .correct(scenarioResult.isCorrect())
                    .script(scenarioResult.getScript())
                    .correct_script(correct_script)
                    .build();
        }
    }
}
