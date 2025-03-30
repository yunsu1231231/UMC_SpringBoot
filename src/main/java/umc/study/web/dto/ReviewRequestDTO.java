package umc.study.web.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class ReviewRequestDto {
        private String content;
        private Integer rating;
        private Long missionId;
        private Long storeId;
        private Long userId;
    }

    //  가게의 리뷰 목록 조회
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
