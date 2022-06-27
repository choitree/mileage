package com.triple.mileage.repository;

import com.triple.mileage.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Long, Review> {
}