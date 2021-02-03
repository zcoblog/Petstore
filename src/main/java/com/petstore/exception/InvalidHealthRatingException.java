package com.petstore.exception;

public class InvalidHealthRatingException extends RuntimeException {
    public InvalidHealthRatingException(String id, Integer healthRating) {
        super(String.format("%s failed health validation, a health rating of %s was provided, which is invalid", id, healthRating));
    }
}
