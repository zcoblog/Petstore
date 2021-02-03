package com.petstore.objectmother;

import com.petstore.dto.PetRequest;
import com.petstore.model.PetType;

import static com.petstore.objectmother.TailRequestObjectMother.getTailRequest;

public class PetRequestObjectMother {
    public static PetRequest getFairlyDemandingPetRequest(){
        return PetRequest
            .builder()
            .petType(PetType.DOG)
            .maxAgeInMonthsExpectation(12)
            .colorExpectation("brown")
            .cutenessExpectation(8)
            .healthExpectation(8)
            .tailRequest(getTailRequest())
            .build();
    }
}
