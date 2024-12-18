package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.annotation.PageValidator;
import umc.study.domain.Reviews;
import umc.study.service.ReviewService.ReviewService;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 가게에 리뷰 추가하기 API
    @PostMapping("/add")
    public ResponseEntity<Reviews> addReview(@RequestBody ReviewRequestDTO.ReviewRequestDto reviewRequestDto
                                             /*@RequestHeader("Authorization") String token*/)
    {
        System.out.println("확인");
        System.out.println(reviewRequestDto);
        Reviews addedReview = reviewService.addReview(reviewRequestDto/*token*/);
        return ResponseEntity.ok(addedReview);
    }

    // 내가 작성한 리뷰 조회
    @GetMapping("/my")
    public ResponseEntity<Page<ReviewResponseDTO>> getMyReviews(
            @PageValidator @RequestParam("page") int page,
            @RequestParam("size") int size) {
        Long userId = 1L; // 임시 사용자 ID
        Page<ReviewResponseDTO> response = reviewService.getMyReviews(userId, page, size);
        return ResponseEntity.ok(response);
    }

    // 특정 가게의 미션 목록 조회
    @GetMapping("/missions/{storeId}")
    public ResponseEntity<Page<MissionResponseDTO>> getMissionsByStore(
            @PathVariable Long storeId,
            @PageValidator @RequestParam("page") int page,
            @RequestParam("size") int size) {
        Page<MissionResponseDTO> response = reviewService.getMissionsByStore(storeId, page, size);
        return ResponseEntity.ok(response);
    }

    // 미션 상태를 완료로 변경
    @PutMapping("/missions/{missionId}/complete")
    public ResponseEntity<Void> completeMission(@PathVariable Long missionId) {
        reviewService.completeMission(missionId);
        return ResponseEntity.noContent().build();
    }

}