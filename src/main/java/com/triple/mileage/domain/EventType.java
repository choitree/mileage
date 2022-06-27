package com.triple.mileage.domain;

import lombok.Getter;

@Getter
public enum EventType  {
    REVIEW( "리뷰");

    private final String type;


    EventType(String type) {
        this.type = type;
    }


}

