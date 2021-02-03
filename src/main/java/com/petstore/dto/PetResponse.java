package com.petstore.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PetResponse {
    String name;
    String petType;

    public static PetResponse fromPetRequest(PetRequest petDto) {
        return null;
    }
}
