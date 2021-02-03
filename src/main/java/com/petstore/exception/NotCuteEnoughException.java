package com.petstore.exception;

public class NotCuteEnoughException extends RuntimeException {
    public NotCuteEnoughException(String id, Integer cuteness, Integer minCutenessExpectation) {
        super(String.format("%s Not cute enough, cuteness rating of %s, where minimum cuteness defined as %s", id, cuteness, minCutenessExpectation));
    }
}
