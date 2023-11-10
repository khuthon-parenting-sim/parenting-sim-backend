package lomayd.parentingsim.api.domain.scenario.dto;

import lombok.*;

public class ScenarioRequestDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Episode {
        private String episode;
    }
}
