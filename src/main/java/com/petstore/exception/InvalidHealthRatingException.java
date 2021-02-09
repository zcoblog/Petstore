package com.petstore.exception;

public class InvalidHealthRatingException extends RuntimeException {
    public InvalidHealthRatingException(Integer healthRating) {
        super(String.format("Failed health validation, a health rating of %s was provided, which is invalid", healthRating));
    }
}
