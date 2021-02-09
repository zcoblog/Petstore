package com.petstore.exception;

public class TooOldException extends RuntimeException {
    public TooOldException(Integer animalAge, Integer animalAgeExpectation) {
        super(String.format("Animal is %s months old but max age of %s months was requested", animalAge, animalAgeExpectation));
    }
}
