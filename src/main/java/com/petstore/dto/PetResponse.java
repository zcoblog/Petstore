package com.petstore.dto;

import com.petstore.model.Pet;
import com.petstore.model.PetType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PetResponse {
    PetType petType;
    Integer age;
    Integer cuteness;
    Integer health;
    String color;
    TailResponse tail;

    public static PetResponse fromPet(Pet pet) {
        return PetResponse
            .builder()
            .petType(pet.getPetType())
            .age(pet.getAgeInMonths())
            .cuteness(pet.getCuteness())
            .health(pet.getHealthRating())
            .tail(TailResponse.fromTail(pet.getTail()))
            .build();
    }
}
