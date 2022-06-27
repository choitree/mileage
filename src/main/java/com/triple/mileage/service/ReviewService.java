package com.triple.mileage.service;

import com.triple.mileage.domain.PointLog;
import com.triple.mileage.repository.*;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final PhotoRepository photoRepository;
    private final PlaceRepository placeRepository;
    private final PointLogRepository pointLogRepository;

    public ReviewService(UserRepository userRepository, ReviewRepository reviewRepository, PhotoRepository photoRepository, PlaceRepository placeRepository, PointLogRepository pointLogRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.photoRepository = photoRepository;
        this.placeRepository = placeRepository;
        this.pointLogRepository = pointLogRepository;
    }

    public void createReview() {

    }

}
