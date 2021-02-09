package com.petstore.youngobjectmother;

import com.petstore.dto.PetDonationRequest;
import com.petstore.model.PetType;

public class PetDonationRequestProvider {
    public static PetDonationRequest getPetDonationRequest(){
        return PetDonationRequest
            .builder()
            .petType(PetType.DOG)
            .age(12)
            .color("brown")
            .cuteness(10)
            .health(10)
            .tailRequest(TailRequestProvider.getDefaultTailRequest())
            .build();
    }
}
