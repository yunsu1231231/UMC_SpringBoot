package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Reviews;
import umc.study.web.dto.ReviewResponseDTO;

@Component
public class ReviewConverter {
    // Reviews 엔티티를 ReviewResponseDTO 변환
    public ReviewResponseDTO toResponse(Reviews review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .description(review.getDescription())
                .photoUrl(review.getPhoto_url())
                .rating(review.getRating())
                .userId(review.getUsers().getId())
                .storeId(review.getStores().getId())
                .build();
    }
}

