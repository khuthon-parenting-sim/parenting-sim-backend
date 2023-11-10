package lomayd.parentingsim.api.domain.scenario.dto;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lomayd.parentingsim.api.domain.user.User;
import lombok.*;

@RequiredArgsConstructor
public class ScenarioResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Script {

        private int id;
        private int episode;
        private int illustration;
        private String script;
        private int choice_1_id;
        private String choice_1_script;
        private double choice_1_rate;
        private int choice_2_id;
        private String choice_2_script;
        private double choice_2_rate;

        public static Script of(Scenario scenario, Scenario choice_1_scenario, Scenario choice_2_scenario, double choice_1_rate, double choice_2_rate) {

            return Script.builder()
                    .id(scenario.getId())
                    .episode(scenario.getEpisode())
                    .illustration(scenario.getIllustration())
                    .script(scenario.getScript())
                    .choice_1_id(choice_1_scenario.getId())
                    .choice_1_script(choice_1_scenario.getScript())
                    .choice_1_rate(choice_1_rate)
                    .choice_2_id(choice_2_scenario.getId())
                    .choice_2_script(choice_2_scenario.getScript())
                    .choice_2_rate(choice_2_rate)
                    .build();
        }
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {

        private String user;
        private double score_point;
        private double score_patient;
        private double score_manner;
        private double score_concentration;

        public static Result of(User user) {

            return Result.builder()
                    .user(user.getId())
                    .score_point(user.getScore_point())
                    .score_patient(user.getScore_patient())
                    .score_manner(user.getScore_manner())
                    .score_concentration(user.getScore_concentration())
                    .build();
        }
    }
}
