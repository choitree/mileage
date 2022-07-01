package com.triple.mileage.repository.pointLog;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.triple.mileage.domain.QPointLog;
import com.triple.mileage.domain.Review;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointLogRepositoryImpl implements PointLogRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public int pointSumByReview(Review review) {
        return queryFactory.select(QPointLog.pointLog.point)
                .from(QPointLog.pointLog)
                .where(QPointLog.pointLog.review.eq(review))
                .stream()
                .mapToInt(i -> i)
                .sum();
    }

    public void updatePointLogReviewToNull(Review review) {
        queryFactory.update(QPointLog.pointLog)
                .setNull(QPointLog.pointLog.review.reviewId)
                .where(QPointLog.pointLog.review.eq(review))
                .execute();
    }
}
