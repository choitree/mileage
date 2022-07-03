package com.triple.mileage.dto;

import com.triple.mileage.domain.PointLog;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.format.DateTimeFormatter;

@Getter
@RequiredArgsConstructor
@SuperBuilder
public class PointLogResponseDTO {

    private final String userId;
    private final String reviewId;
    private final String eventType;
    private final int point;
    private final String info;
    private String createdAt;

    public static PointLogResponseDTO from(PointLog pointLog) {
        return PointLogResponseDTO.builder()
                .userId(pointLog.getUser().getUserId())
                .reviewId(pointLog.getReview().getReviewId())
                .eventType(pointLog.getReview().getEventType().toString())
                .point(pointLog.getPoint())
                .info(pointLog.getInfo())
                .createdAt(pointLog.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}
