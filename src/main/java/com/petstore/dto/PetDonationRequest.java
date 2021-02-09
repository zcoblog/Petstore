package com.petstore.dto;

import com.petstore.model.Pet;
import com.petstore.model.PetType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PetDonationRequest {
    Integer age;
    Integer cuteness;
    Integer health;
    String color;
    PetType petType;
    TailRequest tailRequest;

    public Pet toPetEntity() {
        return Pet.builder()
            .ageInMonths(this.age)
            .cuteness(this.cuteness)
            .healthRating(this.health)
            .color(this.color)
            .petType(this.petType)
            .tail(this.tailRequest.toTail())
            .build();
    }
}
