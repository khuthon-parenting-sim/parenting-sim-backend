package lomayd.parentingsim.api.domain.user.dto;

import lomayd.parentingsim.api.domain.user.User;
import lombok.*;

public class UserResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {

        private String user;
        private double score_total;
        private double score_society;
        private double score_control;
        private double score_recognition;
        private double score_concentration;

        public static Result of(User user) {

            return Result.builder()
                    .user(user.getId())
                    .score_total(user.getScore_total())
                    .score_society(user.getScore_society())
                    .score_control(user.getScore_control())
                    .score_recognition(user.getScore_recognition())
                    .score_concentration(user.getScore_concentration())
                    .build();
        }
    }
}
