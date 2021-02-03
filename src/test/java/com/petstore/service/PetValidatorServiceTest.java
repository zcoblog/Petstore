package com.petstore.service;

import com.petstore.dto.PetRequest;
import com.petstore.dto.TailRequest;
import com.petstore.exception.NotHealthyEnoughException;
import com.petstore.exception.TooOldException;
import com.petstore.exception.NotCuteEnoughException;
import com.petstore.exception.WrongColorException;
import com.petstore.model.Pet;
import com.petstore.model.PetType;
import com.petstore.model.Tail;
import com.petstore.model.TailFluffiness;
import com.petstore.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PetValidatorServiceTest {
    private final AgeValidator ageValidator = new AgeValidator();
    private final ColorValidator colorValidator = new ColorValidator();
    private final CutenessValidator cutenessValidator = new CutenessValidator();
    private final HealthValidator healthValidator = new HealthValidator();
    private final TailValidator tailValidator = new TailValidator();

    private final PetValidatorService petValidatorService = new PetValidatorService(ageValidator, colorValidator, cutenessValidator, healthValidator, tailValidator);

    @Test
    @DisplayName("Should throw NotCuteEnoughException when pet isn't as cute as specified")
    void validationFailsWhenPetNotCuteEnough() {
        // difficult to spot straight away which field has an effect on the test
        var notSoCuteDoggo =
            Pet.builder()
                .petType(PetType.DOG)
                .ageInMonths(12)
                .color("brown")
                .cuteness(2)
                .healthRating(10)
                .tail(Tail
                    .builder()
                    .tailLength(10)
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .build())
                .build();

        var petRequestWithUnrealisticBeautyStandards = PetRequest
            .builder()
            .petType(PetType.DOG)
            .maxAgeInMonthsExpectation(120)
            .colorExpectation("brown")
            .cutenessExpectation(8)
            .healthExpectation(8)
            .tailRequest(
                TailRequest
                    .builder()
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .tailLength(10)
                    .build())
            .build();

        NotCuteEnoughException notCuteEnoughException = assertThrows(NotCuteEnoughException.class,
            () -> petValidatorService.validatePet(notSoCuteDoggo, petRequestWithUnrealisticBeautyStandards));

        assertThat(notCuteEnoughException.getMessage()).contains("Not cute enough, cuteness rating of 2, where minimum cuteness defined as 8");
    }

    @Test
    @DisplayName("Should throw TooOldException when pet is too old")
    void validationFailsWhenPetIsTooOld() {
        var oldDoggo =
            Pet.builder()
                .petType(PetType.DOG)
                .ageInMonths(120)
                .color("brown")
                .cuteness(8)
                .healthRating(10)
                .tail(Tail
                    .builder()
                    .tailLength(10)
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .build())
                .build();

        var puppyRequest = PetRequest
            .builder()
            .petType(PetType.DOG)
            .maxAgeInMonthsExpectation(12)
            .colorExpectation("brown")
            .cutenessExpectation(2)
            .healthExpectation(8)
            .tailRequest(
                TailRequest
                    .builder()
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .tailLength(10)
                    .build())
            .build();

        TooOldException notCuteEnoughException = assertThrows(TooOldException.class,
            () -> petValidatorService.validatePet(oldDoggo, puppyRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("is 120 months old but max age of 12 months was requested");
    }

    @Test
    @DisplayName("Should throw WrongColorException when the pet is the wrong color")
    void validationFailsWhenPetIsWrongColor() {
        var whiteDoggo =
            Pet.builder()
                .petType(PetType.DOG)
                .ageInMonths(12)
                .color("white")
                .cuteness(8)
                .healthRating(10)
                .tail(Tail
                    .builder()
                    .tailLength(10)
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .build())
                .build();

        var brownDoggoRequest = PetRequest
            .builder()
            .petType(PetType.DOG)
            .maxAgeInMonthsExpectation(12)
            .colorExpectation("brown")
            .cutenessExpectation(8)
            .healthExpectation(8)
            .tailRequest(
                TailRequest
                    .builder()
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .tailLength(10)
                    .build())
            .build();

        WrongColorException wrongColorException = assertThrows(WrongColorException.class,
            () -> petValidatorService.validatePet(whiteDoggo, brownDoggoRequest));

        assertThat(wrongColorException.getMessage()).contains("was of the color white, where the expected color was brown");
    }

    @Test
    @DisplayName("Should throw NotHealthyEnoughException when the pet is not healthy")
    void validationFailsWhenPetIsNotHealthyEnough() {
        var unhealthyDog =
            Pet.builder()
                .petType(PetType.DOG)
                .ageInMonths(12)
                .color("brown")
                .cuteness(8)
                .healthRating(1)
                .tail(Tail
                    .builder()
                    .tailLength(10)
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .build())
                .build();

        var healthyDogRequest = PetRequest
            .builder()
            .petType(PetType.DOG)
            .maxAgeInMonthsExpectation(12)
            .colorExpectation("brown")
            .cutenessExpectation(8)
            .healthExpectation(8)
            .tailRequest(
                TailRequest
                    .builder()
                    .tailFluffiness(TailFluffiness.SUPER_FLUFFY)
                    .tailLength(10)
                    .build())
            .build();

        NotHealthyEnoughException wrongColorException = assertThrows(NotHealthyEnoughException.class,
            () -> petValidatorService.validatePet(unhealthyDog, healthyDogRequest));

        assertThat(wrongColorException.getMessage()).contains("Not healthy enough, health rating of 1, where minimum health defined as 8");
    }

}
