package com.petstore.exception;

public class TailLengthShorterThanRequestedException extends RuntimeException {
    public TailLengthShorterThanRequestedException(Integer tailLength, Integer tailLengthRequest) {
        super(String.format("Expected a tail length of %s, however the tail length was %S", tailLengthRequest, tailLength));
    }
}
