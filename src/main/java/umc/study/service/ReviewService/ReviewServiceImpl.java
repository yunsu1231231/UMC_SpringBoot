package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.domain.enums.Rating;
import umc.study.domain.mapping.User_Missions;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final UserMissionRepository userMissionRepository;


    // 가게에 리뷰 추가하기 API
    public Reviews addReview(ReviewRequestDTO.ReviewRequestDto reviewRequestDto, String token) {
        // 토큰 인증 및 유효성 검증 로직 추가 필요

        // User_Missions 객체 조회
        User_Missions userMission = userMissionRepository.findById(reviewRequestDto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        // Store 객체 조회
        Stores store = storeRepository.findById(reviewRequestDto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        // Review 객체 생성
        Reviews review = Reviews.builder()
                .missions(userMission)
                .stores(store)
                .description(reviewRequestDto.getContent())
                .rating(Rating.values()[reviewRequestDto.getRating() - 1])
                .build();

        // Review 저장
        return reviewRepository.save(review);
    }

}
