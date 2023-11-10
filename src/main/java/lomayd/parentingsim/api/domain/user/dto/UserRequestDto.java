package lomayd.parentingsim.api.domain.user.dto;

import lombok.*;

public class UserRequestDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserJoin {
        private String id;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Episode {
        private String episode;
    }
}
