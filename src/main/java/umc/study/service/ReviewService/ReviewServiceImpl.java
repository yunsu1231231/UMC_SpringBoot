package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.domain.Users;
import umc.study.domain.enums.Rating;
import umc.study.domain.mapping.User_Missions;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository;
import umc.study.repository.UserProfileRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserProfileRepository userProfileRepository; // 로그인 없이 임의 유저 조회



    // 가게에 리뷰 추가하기 API
    public Reviews addReview(ReviewRequestDTO.ReviewRequestDto reviewRequestDto /*String token*/) {
        // 토큰 인증 및 유효성 검증 로직 추가 필요

        System.out.println("1");

        // 1. 임의의 회원 정보 조회 (하드코딩 방식)
        Users user = userProfileRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("No user found in the database"));

        // 미션 ID 출력
        System.out.println("Mission ID: " + reviewRequestDto.getMissionId());

        // 데이터베이스에서 미션 찾기
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
