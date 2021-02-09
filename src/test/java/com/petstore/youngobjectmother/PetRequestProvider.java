package com.petstore.youngobjectmother;

import com.petstore.dto.PetRequest;
import com.petstore.model.PetType;

public class PetRequestProvider {
    public static PetRequest getDemandingPetRequest(){
        return PetRequest
            .builder()
            .petType(PetType.DOG)
            .maxAgeInMonthsExpectation(12)
            .colorExpectation("brown")
            .cutenessExpectation(10)
            .healthExpectation(10)
            .tailRequest(TailRequestProvider.getDefaultTailRequest())
            .build();
    }
}
