package com.triple.mileage.exception;

public class PlaceNotFoundException extends RuntimeException {

    public PlaceNotFoundException() {
        super();
    }

    public PlaceNotFoundException(String message) {
        super(message);
    }
}