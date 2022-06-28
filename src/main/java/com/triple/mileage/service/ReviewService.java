package com.triple.mileage.service;

import com.triple.mileage.domain.*;
import com.triple.mileage.dto.ReviewRequestDTO;
import com.triple.mileage.exception.*;
import com.triple.mileage.repository.EventRepository;
import com.triple.mileage.repository.PlaceRepository;
import com.triple.mileage.repository.ReviewRepository;
import com.triple.mileage.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final PhotoService photoService;
    private final PlaceRepository placeRepository;
    private final PointLogService pointLogService;
    private final EventRepository eventRepository;

    public ReviewService(UserRepository userRepository, ReviewRepository reviewRepository,
                         PhotoService photoService, PlaceRepository placeRepository,
                         PointLogService pointLogService, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.photoService = photoService;
        this.placeRepository = placeRepository;
        this.pointLogService = pointLogService;
        this.eventRepository = eventRepository;
    }

    @Transactional
    public void createReview(ReviewRequestDTO reviewRequestDTO) {
        if(!reviewRequestDTO.getAction().equals(Action.ADD.name())) {
            throw new WrongActionException("리뷰 등록의 경우, ADD action이여야 합니다.");
        }
        User user = userRepository.findByUserId(reviewRequestDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("리뷰를 등록하려는 유저가 존재하지 않습니다."));
        Place place = placeRepository.findByPlaceId(reviewRequestDTO.getPlaceId())
                .orElseThrow(() -> new PlaceNotFoundException("리뷰를 등록하려는 장소가 존재하지 않습니다."));
        Event event = eventRepository.findByEventType(EventType.REVIEW.getType())
                .orElseThrow(() -> new EventNotFoundException("리뷰라는 이벤트가 존재하지 않습니다."));

        int samePlaceReviewCount = reviewRepository.findAllByPlace(place).size();
        Review review = Review.createReview(reviewRequestDTO, user, place, event);
        photoService.convertAndSaveAllPhotos(reviewRequestDTO.getPhotoIds(), review);
        reviewRepository.save(review);
        pointLogService.saveCreateReviewPointLog(user, review, reviewRequestDTO.getPhotoIds().size(), samePlaceReviewCount, "리뷰생성");
    }

}
