package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Reviews;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public interface ReviewService {
    Reviews addReview(ReviewRequestDTO.ReviewRequestDto reviewRequestDto, String token);
    Page<ReviewResponseDTO> getMyReviews(Long userId, int page, int size);
    Page<MissionResponseDTO> getMissionsByStore(Long storeId, int page, int size);
    Page<MissionResponseDTO> getOngoingMissionsByStore(Long storeId, int page, int size);
    void completeMission(Long missionId);
}
