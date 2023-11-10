package lomayd.parentingsim.api.domain.scenario.dto;

import lombok.*;

public class ScenarioRequestDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EpisodeStart {
        private String episode;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EpisodePlay {
        private int scenario;
        private String user;
    }
}
