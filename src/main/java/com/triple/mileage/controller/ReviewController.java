package com.triple.mileage.controller;

import com.triple.mileage.dto.ResponseDTO;
import com.triple.mileage.dto.ReviewRequestDTO;
import com.triple.mileage.dto.ReviewUpdateRequestDTO;
import com.triple.mileage.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/events")
    public ResponseEntity<ResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        reviewService.createReview(reviewRequestDTO);
        return ResponseEntity.ok(new ResponseDTO("OK"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateReview(@RequestBody ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        reviewService.updateReview(reviewUpdateRequestDTO);
        return ResponseEntity.ok(new ResponseDTO("OK"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteReview(@RequestParam String reviewId, String action) {
        reviewService.deleteReview(reviewId, action);

        return ResponseEntity.ok(new ResponseDTO("OK"));
    }
}
