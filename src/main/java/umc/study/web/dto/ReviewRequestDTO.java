package umc.study.web.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
