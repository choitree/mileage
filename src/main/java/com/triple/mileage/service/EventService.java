package com.triple.mileage.service;

import com.triple.mileage.domain.Event;
import com.triple.mileage.exception.EventNotFoundException;
import com.triple.mileage.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findByEventType(String eventType) {
        return eventRepository.findByEventType(eventType)
                .orElseThrow(() -> new EventNotFoundException("리뷰라는 이벤트가 존재하지 않습니다."));
    }
}
