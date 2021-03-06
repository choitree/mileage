package com.triple.mileage.service;

import com.triple.mileage.domain.Place;
import com.triple.mileage.exception.PlaceNotFoundException;
import com.triple.mileage.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public Place findByPlaceId(String placeId) {
        return placeRepository.findByPlaceId(placeId)
                .orElseThrow(() -> new PlaceNotFoundException("리뷰를 등록하려는 장소가 존재하지 않습니다."));
    }
}
