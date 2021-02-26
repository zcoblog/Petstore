package com.petstore.dto;

import com.petstore.model.Pet;
import com.petstore.model.PetType;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@Builder(toBuilder = true)
public class PetDonationRequest {
    @NotNull
    @Max(120)
    Integer age;
    @NotNull
    @Max(10)
    Integer cuteness;
    @NotNull
    @Max(10)
    Integer health;
    @NotEmpty
    String color;
    @NotNull
    PetType petType;

    public Pet toPetEntity() {
        return Pet.builder()
            .ageInMonths(this.age)
            .cuteness(this.cuteness)
            .healthRating(this.health)
            .color(this.color)
            .petType(this.petType)
            .build();
    }
}
