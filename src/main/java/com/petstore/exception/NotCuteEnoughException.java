package com.petstore.exception;

public class NotCuteEnoughException extends RuntimeException {
    public NotCuteEnoughException(Integer cuteness) {
        super(String.format("Not cute enough, minimum cuteness defined as %s", cuteness));
    }
}
