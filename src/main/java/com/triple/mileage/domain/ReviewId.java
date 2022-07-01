package com.triple.mileage.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
 

public class ReviewId implements Serializable {

    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "review_id")
    private String reviewId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewId reviewId1 = (ReviewId) o;
        return eventType == reviewId1.eventType && Objects.equals(reviewId, reviewId1.reviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, reviewId);
    }
}
