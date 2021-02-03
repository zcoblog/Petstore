package com.petstore.exception;

import com.petstore.model.TailFluffiness;

public class TailFluffinessNotAsRequestedException extends RuntimeException {
    public TailFluffinessNotAsRequestedException(TailFluffiness tailFluffiness, TailFluffiness tailFluffinessRequest) {
        super(String.format("Expected a tail fluffiness of %s, however the tail fluffiness was %s", tailFluffinessRequest, tailFluffiness));
    }
}
