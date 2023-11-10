package lomayd.parentingsim.api.domain.parenting.dto;

import lomayd.parentingsim.api.domain.parenting.ParentingSituation;
import lombok.*;

import java.util.List;

public class ParentingSituationResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardInfo {

        private List<ParentingSituationResponseDto.BoardPostInfo> post;

        public static ParentingSituationResponseDto.BoardInfo of(List<ParentingSituationResponseDto.BoardPostInfo> boardPostInfos) {
            return ParentingSituationResponseDto.BoardInfo.builder()
                    .post(boardPostInfos)
                    .build();
        }
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardPostInfo {

        private int id;
        private String title;
        private String subTitle;

        public static ParentingSituationResponseDto.BoardPostInfo of(ParentingSituation parentingSituation) {

            return ParentingSituationResponseDto.BoardPostInfo.builder()
                    .id(parentingSituation.getId())
                    .title(parentingSituation.getTitle())
                    .subTitle(parentingSituation.getSubTitle())
                    .build();
        }
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostInfo {

        private int id;
        private String title;
        private String subTitle;
        private String detail;
        private String good_example_detail;
        private String good_example_video_link;
        private String bad_example_detail;
        private String bad_example_video_link;
        public static ParentingSituationResponseDto.PostInfo of(ParentingSituation parentingSituation) {

            return PostInfo.builder()
                    .id(parentingSituation.getId())
                    .title(parentingSituation.getTitle())
                    .subTitle(parentingSituation.getSubTitle())
                    .detail(parentingSituation.getDetail())
                    .good_example_detail(parentingSituation.getGood_example_detail())
                    .good_example_video_link(parentingSituation.getGood_example_video_link())
                    .bad_example_detail(parentingSituation.getBad_example_detail())
                    .bad_example_video_link(parentingSituation.getBad_example_video_link())
                    .build();
        }
    }
}
