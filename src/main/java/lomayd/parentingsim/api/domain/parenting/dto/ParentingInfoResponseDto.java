package lomayd.parentingsim.api.domain.parenting.dto;

import lomayd.parentingsim.api.domain.parenting.ParentingInfo;
import lombok.*;

import java.util.List;

public class ParentingInfoResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardInfo {

        private List<BoardPostInfo> post;

        public static ParentingInfoResponseDto.BoardInfo of(List<BoardPostInfo> boardPostInfos) {
            return BoardInfo.builder()
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
        private List<String> tag;

        public static ParentingInfoResponseDto.BoardPostInfo of(ParentingInfo parentingInfo) {
            List<String> tagList = List.of(parentingInfo.getTag().split(","));

            return BoardPostInfo.builder()
                    .id(parentingInfo.getId())
                    .title(parentingInfo.getTitle())
                    .tag(tagList)
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
        private String detail;
        private List<String> tag;
        private String video_link;
        public static ParentingInfoResponseDto.PostInfo of(ParentingInfo parentingInfo) {
            List<String> tagList = List.of(parentingInfo.getTag().split(","));

            return PostInfo.builder()
                    .id(parentingInfo.getId())
                    .title(parentingInfo.getTitle())
                    .detail(parentingInfo.getDetail())
                    .tag(tagList)
                    .video_link(parentingInfo.getVideo_link())
                    .build();
        }
    }
}
