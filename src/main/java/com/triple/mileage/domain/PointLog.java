package com.triple.mileage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "point_log")
public class PointLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private String info;
    private int point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "review_id", referencedColumnName = "review_id"),
            @JoinColumn(name = "event_type", referencedColumnName = "event_type")
    })
    private Review review;

    public PointLog(LocalDateTime createdAt, String info, int point, User user, Review review) {
        this.createdAt = createdAt;
        this.info = info;
        this.point = point;
        this.user = user;
        this.review = review;
    }
}
