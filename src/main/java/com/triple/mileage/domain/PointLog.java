package com.triple.mileage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "point_log",
        indexes = @Index(name = "idx_point_log", columnList = "user_id"))
public class PointLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private String info;
    @NotNull
    private int point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "fk_point_log_user_user_id"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(foreignKey = @ForeignKey(name = "fk_point_log_review"),
            value = {@JoinColumn(name = "review_id", referencedColumnName = "review_id"),
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
