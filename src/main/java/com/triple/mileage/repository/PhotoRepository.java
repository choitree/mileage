package com.triple.mileage.repository;

import com.triple.mileage.domain.Photo;
import com.triple.mileage.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    void deleteAllByReview(Review review);
}
