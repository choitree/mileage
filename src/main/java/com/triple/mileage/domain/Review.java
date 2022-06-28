package com.triple.mileage.domain;


import com.triple.mileage.dto.ReviewRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review", uniqueConstraints = {@UniqueConstraint(name = "uniqueUserAndPlace", columnNames = {"user_id", "place_id"})})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
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

}
