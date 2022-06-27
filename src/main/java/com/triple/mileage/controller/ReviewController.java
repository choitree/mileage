package com.triple.mileage.controller;

import com.triple.mileage.dto.ResponseDTO;
import com.triple.mileage.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("event")
    public ResponseEntity<ResponseDTO> createReview() {
        reviewService.createReview();
        return ResponseEntity.ok(new ResponseDTO("OK"));
    }
}
