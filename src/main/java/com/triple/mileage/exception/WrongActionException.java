package com.triple.mileage.exception;

public class WrongActionException extends RuntimeException {

    public WrongActionException() {
        super();
    }

    public WrongActionException(String message) {
        super(message);
    }
}

