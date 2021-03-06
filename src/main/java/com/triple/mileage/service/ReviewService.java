package com.triple.mileage.service;

import com.triple.mileage.domain.*;
import com.triple.mileage.dto.ReviewRequestDTO;
import com.triple.mileage.dto.ReviewUpdateRequestDTO;
import com.triple.mileage.exception.IllegalReviewException;
import com.triple.mileage.exception.ReviewNotFoundException;
import com.triple.mileage.exception.WrongActionException;
import com.triple.mileage.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final PlaceService placeService;
    private final PhotoService photoService;
    private final PointLogService pointLogService;

    @Transactional
    public void createReview(ReviewRequestDTO reviewRequestDTO) {
        if (!reviewRequestDTO.getAction().equals(Action.ADD.name())) {
            throw new WrongActionException("리뷰 등록의 경우, ADD action입니다.");
        }
        User user = userService.findByUserId(reviewRequestDTO.getUserId());
        Place place = placeService.findByPlaceId(reviewRequestDTO.getPlaceId());

        int samePlaceReviewCount = reviewRepository.findAllByPlace(place).size();
        Review review = Review.createReview(reviewRequestDTO, user, place);
        if (reviewRequestDTO.getPhotoIds().size() == 0 && reviewRequestDTO.getContent().isBlank()) {
            throw new IllegalReviewException("내용과 사진 모두 없는 상태로 리뷰를 작성할 수 없습니다.");
        }

        photoService.convertAndSaveAllPhotosByReview(reviewRequestDTO.getPhotoIds(), review);
        pointLogService.saveCreateReviewPointLog(user, review, reviewRequestDTO.getPhotoIds().size(), samePlaceReviewCount, "리뷰생성");
        reviewRepository.save(review);
    }

    public void updateReview(ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        if (!reviewUpdateRequestDTO.getAction().equals(Action.MOD.name())) {
            throw new WrongActionException("리뷰 수정의 경우, MOD action입니다.");
        }
        Review review = reviewRepository.findByReviewId(reviewUpdateRequestDTO.getReviewId())
                .orElseThrow(() -> new ReviewNotFoundException("수정하려는 리뷰가 존재하지 않습니다."));
        User user = userService.findByUserId(review.getUser().getUserId());

        int originPhotoCount = review.getPhotos().size();
        boolean isOriginContentExist = !review.getContent().isBlank();

        if (reviewUpdateRequestDTO.getPhotoIds().size() == 0 && reviewUpdateRequestDTO.getContent().isBlank()) {
            throw new IllegalReviewException("내용과 사진 모두 없는 상태로 리뷰를 수정할 수 없습니다.");
        }
        review.updateReview(reviewUpdateRequestDTO);

        reviewRepository.save(review);
        photoService.deleteAllPhotoByReview(review);
        photoService.convertAndSaveAllPhotosByReview(reviewUpdateRequestDTO.getPhotoIds(), review);
        pointLogService.saveUpdateReviewPointLog(user, review, isOriginContentExist, originPhotoCount, reviewUpdateRequestDTO.getPhotoIds().size(), "리뷰수정");
    }

    public void deleteReview(String reviewId, String action) {
        if (!action.equals(Action.DELETE.name())) {
            throw new WrongActionException("리뷰 삭제의 경우, DELETE action입니다.");
        }
        Review review = reviewRepository.findByReviewId(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("삭제하려는 리뷰가 존재하지 않습니다."));
        User user = userService.findByUserId(review.getUser().getUserId());

        photoService.deleteAllPhotoByReview(review);
        reviewRepository.delete(review);
        pointLogService.softDeletePointLog(review, user);
    }
}
