package com.petstore.demo.youngobjectmother;

import com.petstore.dto.TailRequest;
import com.petstore.model.TailFluffiness;

public class TailRequestProvider {
    public static TailRequest getDefaultTailRequest(){
        return TailRequest
            .builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(0)
            .build();
    }

    public static TailRequest getInvalidTailRequest(){
        return TailRequest
            .builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(-1)
            .build();
    }
}
