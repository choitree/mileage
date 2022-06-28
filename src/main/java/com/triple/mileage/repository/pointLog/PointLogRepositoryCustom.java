package com.triple.mileage.repository.pointLog;

import com.triple.mileage.domain.Review;

public interface PointLogRepositoryCustom {

    int pointSumByReview(Review review);

    void updatePointLogReviewToNull(Review review);
}
