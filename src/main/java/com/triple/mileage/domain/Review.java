package com.triple.mileage.domain;


import com.triple.mileage.dto.ReviewRequestDTO;
import com.triple.mileage.dto.ReviewUpdateRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review",
        uniqueConstraints =
                {@UniqueConstraint(
                        name = "uniqueUserAndPlace",
                        columnNames = {"user_id", "place_id"})
                }
)
public class Review {

    @Id
    @Column(columnDefinition = "VARCHAR(36)", name = "review_id")
    @Type(type = "uuid-char")
    private UUID reviewId;

    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "place_id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<PointLog> pointLogs = new ArrayList<>();

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Photo> photos = new ArrayList<>();

    public static Review createReview(ReviewRequestDTO reviewRequestDTO,
                                      User user, Place place, Event event) {
        return Review.builder()
                .reviewId(reviewRequestDTO.getReviewId())
                .content(reviewRequestDTO.getContent())
                .user(user)
                .place(place)
                .event(event)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
    }

    public void updateReview(ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        this.content = reviewUpdateRequestDTO.getContent();
        this.modifiedAt = LocalDateTime.now();
    }

}
