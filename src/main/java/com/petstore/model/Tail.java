package com.petstore.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Tail {
    Integer tailLength;
    TailFluffiness tailFluffiness;
}
