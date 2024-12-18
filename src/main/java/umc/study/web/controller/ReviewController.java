package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Reviews;
import umc.study.service.ReviewService.ReviewService;
import umc.study.web.dto.ReviewRequestDTO;

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
}