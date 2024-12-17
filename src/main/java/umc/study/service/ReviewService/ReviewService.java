package umc.study.service.ReviewService;

import umc.study.domain.Reviews;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewService {
    Reviews addReview(ReviewRequestDTO.ReviewRequestDto reviewRequestDto);
}
