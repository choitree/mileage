package com.triple.mileage.repository;

import com.triple.mileage.domain.Place;
import com.triple.mileage.domain.Review;
import com.triple.mileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Optional<Review> findByUserAndPlace(User user, Place place);

    public List<Review> findAllByPlace(Place place);
}
