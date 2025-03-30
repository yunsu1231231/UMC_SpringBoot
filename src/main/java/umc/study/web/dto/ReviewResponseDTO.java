package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.enums.Rating;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long id;
    private String description;
    private String photoUrl;
    private Rating rating;
    private Long userId;
    private Long storeId;
}
