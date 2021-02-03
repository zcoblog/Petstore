package com.petstore.exception;

public class WrongColorException extends RuntimeException {
    public WrongColorException(String id, String color, String expectedColor) {
        super(String.format("Animal %s, was of the color %s, where the expected color was %s", id, color, expectedColor));
    }
}
