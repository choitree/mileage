package com.triple.mileage.repository;

import com.triple.mileage.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Long, Place> {
}
