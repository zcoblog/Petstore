package com.petstore.objectmother;

import com.petstore.model.Pet;
import com.petstore.model.PetType;

import static com.petstore.objectmother.TailObjectMother.getLongAndFluffyTail;
import static com.petstore.objectmother.TailObjectMother.getShortAndFluffyTail;

public class PetObjectMother {

    public static Pet getNotSoCuteDog() {
        return Pet.builder()
            .petType(PetType.DOG)
            .ageInMonths(12)
            .color("brown")
            .cuteness(2)
            .healthRating(10)
            .tail(getLongAndFluffyTail())
            .build();
    }

    public static Pet getOldDoggo() {
        return Pet.builder()
            .petType(PetType.DOG)
            .ageInMonths(120)
            .color("brown")
            .cuteness(8)
            .healthRating(10)
            .tail(getLongAndFluffyTail())
            .build();
    }

    public static Pet getWhiteDoggo() {
        return Pet.builder()
            .petType(PetType.DOG)
            .ageInMonths(12)
            .color("white")
            .cuteness(8)
            .healthRating(10)
            .tail(getLongAndFluffyTail())
            .build();
    }

    public static Pet getUnhealthyDoggo() {
        return Pet.builder()
            .petType(PetType.DOG)
            .ageInMonths(12)
            .color("brown")
            .cuteness(8)
            .healthRating(1)
            .tail(getLongAndFluffyTail())
            .build();
    }

    public static Pet getDefaultDoggoWithShortTail() {
        return Pet.builder()
            .petType(PetType.DOG)
            .ageInMonths(12)
            .color("brown")
            .cuteness(8)
            .healthRating(10)
            .tail(getShortAndFluffyTail())
            .build();
    }
}
