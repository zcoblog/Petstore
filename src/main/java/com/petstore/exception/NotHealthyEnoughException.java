package com.petstore.exception;

public class NotHealthyEnoughException extends RuntimeException {
    public NotHealthyEnoughException(String id, Integer healthRating, Integer minHealthRatingExpectation) {
        super(String.format("%s Not healthy enough, health rating of %s, where minimum health defined as %s", id, healthRating, minHealthRatingExpectation));
    }
}
