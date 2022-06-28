package com.triple.mileage.service;

import com.triple.mileage.domain.PointLog;
import com.triple.mileage.domain.Review;
import com.triple.mileage.domain.User;
import com.triple.mileage.repository.UserRepository;
import com.triple.mileage.repository.pointLog.PointLogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class PointLogService {

    private final PointLogRepository pointLogRepository;
    private final UserRepository userRepository;

    public PointLogService(PointLogRepository pointLogRepository, UserRepository userRepository) {
        this.pointLogRepository = pointLogRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveCreateReviewPointLog(User user, Review review, int photoSize, int samePlaceReviewCount, String info) {
        int point = 0;
        if (samePlaceReviewCount == 0) {
            point++;
            info += " 장소최초리뷰1점";
        }
        if (photoSize > 0) {
            point++;
            info += " 사진1점";
        }
        if (!review.getContent().isBlank()) {
            point++;
            info += " 내용1점";
        }
        PointLog pointLog = new PointLog(LocalDateTime.now(), info, point, user, review);
        user.updateUserPoint(user.getPoint() + point);
        pointLogRepository.save(pointLog);
        userRepository.save(user);
    }

    @Transactional
    public void saveUpdateReviewPointLog(User user, Review review, Boolean isOriginContentExist, int originPhotoCount, int updatePhotoSize, String info) {
        int point = 0;
        if (isOriginContentExist && review.getContent().isBlank()) {
            point--;
            info += " 내용삭제차감1점";
        }
        if (!isOriginContentExist) {
            if (!review.getContent().isBlank()) {
                point++;
                info += " 내용추가1점";
            }
        }

        if (originPhotoCount > 0 && updatePhotoSize == 0) {
            point--;
            info += " 사진삭제차감1점";
        }
        if (originPhotoCount == 0 && updatePhotoSize > 0) {
            point++;
            info += " 사진추가1점";
        }
        PointLog pointLog = new PointLog(LocalDateTime.now(), info, point, user, review);
        user.updateUserPoint(user.getPoint() + point);
        pointLogRepository.save(pointLog);
        userRepository.save(user);
    }

    @Transactional
    public void softDeletePointLog(Review review, User user) {
        int pointsSum = pointLogRepository.pointSumByReview(review);
        pointLogRepository.updatePointLogReviewToNull(review);
        PointLog pointLog = new PointLog(LocalDateTime.now(), "리뷰삭제", -pointsSum, user, null);
        user.updateUserPoint(user.getPoint() - pointsSum);
        pointLogRepository.save(pointLog);
        userRepository.save(user);
    }
}
