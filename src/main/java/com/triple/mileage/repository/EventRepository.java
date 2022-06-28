package com.triple.mileage.repository;

import com.triple.mileage.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    public Optional<Event> findByEventType(String eventType);
}
