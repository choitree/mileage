package com.triple.mileage.repository;

import com.triple.mileage.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    public Optional<Place> findByPlaceId(String placeId);
}
