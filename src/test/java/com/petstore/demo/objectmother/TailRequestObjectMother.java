package com.petstore.demo.objectmother;

import com.petstore.dto.TailRequest;
import com.petstore.model.TailFluffiness;

public class TailRequestObjectMother {
    public static TailRequest getTailRequest() {
        return TailRequest
            .builder()
            .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
            .tailLength(10)
            .build();
    }
}
