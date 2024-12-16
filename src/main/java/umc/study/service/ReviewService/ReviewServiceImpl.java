package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Missions;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.domain.enums.Rating;
import umc.study.domain.mapping.User_Missions;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final UserMissionRepository userMissionRepository;

    private final MissionRepository missionRepository; // 미션 관련 데이터
    private final MissionConverter missionConverter; // 미션 변환
    private final ReviewConverter reviewConverter; // 리뷰 변환


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

    // 내가 작성한 리뷰 목록 조회
    public Page<ReviewResponseDTO> getMyReviews(Long userId, int page, int size) {
        Page<Reviews> reviews = reviewRepository.findByUsersId(userId, PageRequest.of(page, size));
        return reviews.map(reviewConverter::toResponse);
    }

    // 특정 가게의 미션 목록 조회
    public Page<MissionResponseDTO> getMissionsByStore(Long storeId, int page, int size) {
        Page<Missions> missions = missionRepository.findByStoresId(storeId, PageRequest.of(page, size));
        return missions.map(missionConverter::toResponse);
    }

    // 진행 중인 미션 목록 조회
    public Page<MissionResponseDTO> getOngoingMissionsByStore(Long storeId, int page, int size) {
        Page<Missions> missions = missionRepository.findOngoingMissionsByStore(storeId, PageRequest.of(page, size));
        return missions.map(missionConverter::toResponse);
    }

    // 미션 상태를 완료로 변경
    public void completeMission(Long missionId) {
        Missions mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));
        mission.setCompleted(true); // 완료 상태로 변경
        missionRepository.save(mission);
    }

}
