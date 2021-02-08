package com.petstore.demo.youngobjectmother;

import com.petstore.model.Tail;
import com.petstore.model.TailFluffiness;

public class TailProvider {
    public static Tail getDefaultTail(){
        return Tail
            .builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(10)
            .build();
    }

    public static Tail getInvalidTail(){
        return Tail
            .builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(-1)
            .build();
    }
}
