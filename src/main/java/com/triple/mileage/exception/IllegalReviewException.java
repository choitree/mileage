package com.triple.mileage.exception;

public class IllegalReviewException extends RuntimeException {

    public IllegalReviewException() {
        super();
    }

    public IllegalReviewException(String message) {
        super(message);
    }
}
