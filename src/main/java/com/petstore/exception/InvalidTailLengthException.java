package com.petstore.exception;

public class InvalidTailLengthException extends RuntimeException {
    public InvalidTailLengthException(Integer tailLength) {
        super(String.format("Invalid tail length %s", tailLength));
    }
}
