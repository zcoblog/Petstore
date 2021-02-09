package com.petstore.exception;

public class NotHealthyEnoughException extends RuntimeException {
    public NotHealthyEnoughException(Integer minHealthRatingExpectation) {
        super(String.format("Not healthy enough, where minimum health defined as %s", minHealthRatingExpectation));
    }
}
