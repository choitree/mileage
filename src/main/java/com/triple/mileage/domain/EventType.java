package com.triple.mileage.domain;

import lombok.Getter;

@Getter
public enum EventType  {
    REVIEW(1, "리뷰");

    private final int code;
    private final String type;


    EventType(int code, String type) {
        this.code = code;
        this.type = type;
    }


}

