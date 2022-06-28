package com.triple.mileage.service;

import com.triple.mileage.domain.PointLog;
import com.triple.mileage.domain.Review;
import com.triple.mileage.domain.User;
import com.triple.mileage.repository.PointLogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class PointLogService {

    private final PointLogRepository pointLogRepository;

    public PointLogService(PointLogRepository pointLogRepository) {
        this.pointLogRepository = pointLogRepository;
    }

    @Transactional
    public void saveCreateReviewPointLog(User user, Review review, int photoSize, int samePlaceReviewCount, String info) {
        int point = 0;
        if(photoSize > 0) point++;
        if(review.getContent() != null && !review.getContent().equals(" ")) point++;
        if(samePlaceReviewCount == 0) point++;
        PointLog pointLog = new PointLog(LocalDateTime.now(), info, point, user, review);
        pointLogRepository.save(pointLog);
    }
}
