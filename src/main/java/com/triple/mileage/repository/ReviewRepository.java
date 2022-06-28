package com.triple.mileage.repository;

import com.triple.mileage.domain.Place;
import com.triple.mileage.domain.Review;
import com.triple.mileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUserAndPlace(User user, Place place);

    List<Review> findAllByPlace(Place place);

    Optional<Review> findByReviewId(UUID reviewId);
}
