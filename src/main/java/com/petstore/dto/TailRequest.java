package com.petstore.dto;

import com.petstore.model.Tail;
import com.petstore.model.TailFluffiness;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class TailRequest {
    Integer tailLength;
    TailFluffiness tailFluffiness;

    public Tail toTail(){
        return Tail.builder()
            .tailLength(this.tailLength)
            .tailFluffiness(this.tailFluffiness)
            .build();
    }
}
