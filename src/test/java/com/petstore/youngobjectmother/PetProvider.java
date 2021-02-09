package com.petstore.youngobjectmother;

import com.petstore.model.Pet;
import com.petstore.model.PetType;

import static com.petstore.youngobjectmother.TailProvider.getDefaultTail;

public class PetProvider {
    // this default object is set up to pass all the validation necessary
    // only one object is required as we rely on the toBuilder method in order change the relevant part of the Pet
    // changing the model is still only required in one place
    public static Pet getDefaultDog(){
        return Pet.builder()
            .petType(PetType.DOG)
            .ageInMonths(1)
            .color("brown")
            .cuteness(10)
            .healthRating(10)
            .tail(getDefaultTail())
            .build();
    }
}
