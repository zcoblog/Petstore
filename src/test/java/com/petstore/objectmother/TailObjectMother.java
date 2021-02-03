package com.petstore.objectmother;

import com.petstore.model.Tail;
import com.petstore.model.TailFluffiness;

public class TailObjectMother {
    public static Tail getLongAndFluffyTail(){
        return Tail.builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(10)
            .build();
    }

    public static Tail getShortAndFluffyTail(){
        return Tail.builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(0)
            .build();
    }
}
