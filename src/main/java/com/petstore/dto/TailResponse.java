package com.petstore.dto;

import com.petstore.model.Tail;
import com.petstore.model.TailFluffiness;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TailResponse {
    Integer tailLength;
    TailFluffiness tailFluffiness;

    public static TailResponse fromTail(Tail tail) {
        return TailResponse.builder()
            .tailLength(tail.getTailLength())
            .tailFluffiness(tail.getTailFluffiness())
            .build();
    }
}
