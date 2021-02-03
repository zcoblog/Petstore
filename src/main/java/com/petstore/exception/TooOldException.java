package com.petstore.exception;

public class TooOldException extends RuntimeException {
    public TooOldException(String animalId, Integer animalAge, Integer animalAgeExpectation) {
        super(String.format("Animal %s is %s months old but max age of %s months was requested", animalId, animalAge, animalAgeExpectation));
    }
}
