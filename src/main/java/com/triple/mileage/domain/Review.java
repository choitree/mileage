package com.triple.mileage.domain;

import com.triple.mileage.dto.ReviewRequestDTO;
import com.triple.mileage.dto.ReviewUpdateRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
@AttributeOverride(name = "eventType", column = @Column(name = "event_type"))
@IdClass(ReviewId.class)
public class Review extends Event {

    @Id
    @Column(name = "review_id", columnDefinition = "char(36)")
    private String reviewId;

    @NotNull
    private String content;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "fk_review_user_user_id"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "place_id",
            foreignKey = @ForeignKey(name = "fk_review_place_place_id"))
    private Place place;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<PointLog> pointLogs = new ArrayList<>();

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Photo> photos = new ArrayList<>();

    public static Review createReview(ReviewRequestDTO reviewRequestDTO,
                                      User user, Place place) {
        return Review.builder()
                .reviewId(reviewRequestDTO.getReviewId())
                .content(reviewRequestDTO.getContent())
                .user(user)
                .place(place)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .eventType(EventType.valueOf(reviewRequestDTO.getType()))
                .build();
    }

    public void updateReview(ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        this.content = reviewUpdateRequestDTO.getContent();
        this.modifiedAt = LocalDateTime.now();
    }
}
