package com.petstore.service;

import com.petstore.exception.*;
import com.petstore.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.petstore.demo.youngobjectmother.PetProvider.getDefaultDog;
import static com.petstore.demo.youngobjectmother.PetRequestProvider.getDemandingPetRequest;
import static com.petstore.demo.youngobjectmother.TailProvider.getInvalidTail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PetValidatorYOMTest {
    private final AgeValidator ageValidator = new AgeValidator();
    private final ColorValidator colorValidator = new ColorValidator();
    private final CutenessValidator cutenessValidator = new CutenessValidator();
    private final HealthValidator healthValidator = new HealthValidator();
    private final TailValidator tailValidator = new TailValidator();

    private final PetValidatorService petValidatorService = new PetValidatorService(ageValidator, colorValidator, cutenessValidator, healthValidator, tailValidator);

    @Test
    void validationFailsWhenPetNotCuteEnough() {
        var pet = getDefaultDog().toBuilder().cuteness(1).build();

        var petRequest = getDemandingPetRequest();

        NotCuteEnoughException notCuteEnoughException = assertThrows(NotCuteEnoughException.class,
            () -> petValidatorService.validatePet(pet, petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("Not cute enough");
    }

    @Test
    void validationFailsWhenPetIsTooOld() {
        var pet = getDefaultDog().toBuilder().ageInMonths(120).build();

        var petRequest = getDemandingPetRequest();

        TooOldException notCuteEnoughException = assertThrows(TooOldException.class,
            () -> petValidatorService.validatePet(pet, petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("is 120 months old but max age of 12 months was requested");
    }

    @Test
    @DisplayName("Should throw WrongColorException when the pet is the wrong color")
    void validationFailsWhenPetIsWrongColor() {
        // it is immediately obvious which part of the object is causing the exception and is still clean
        var whiteDoggo = getDefaultDog().toBuilder().color("white").build();

        var brownDoggoRequest = getDemandingPetRequest();

        WrongColorException wrongColorException = assertThrows(WrongColorException.class,
            () -> petValidatorService.validatePet(whiteDoggo, brownDoggoRequest));

        assertThat(wrongColorException.getMessage()).contains("was of the color white, where the expected color was brown");
    }

    @Test
    @DisplayName("Should throw NotHealthyEnoughException when the pet is not healthy")
    void validationFailsWhenPetIsNotHealthyEnough() {
        // it is immediately obvious which part of the object is causing the exception and is still clean
        var unhealthyDog = getDefaultDog().toBuilder().healthRating(1).build();

        var healthyDogRequest = getDemandingPetRequest();

        NotHealthyEnoughException wrongColorException = assertThrows(NotHealthyEnoughException.class,
            () -> petValidatorService.validatePet(unhealthyDog, healthyDogRequest));

        assertThat(wrongColorException.getMessage()).contains("Not healthy enough, health rating of 1, where minimum health defined as 10");
    }

    @Test
    @DisplayName("Should throw InvalidTailLengthException when the tail length is below 0")
    void validationFailsTailNotFluffyEnough() {
        // it is immediately obvious which part of the object is causing the exception and is still clean
        var unhealthyDog = getDefaultDog()
            .toBuilder()
            .tail(getInvalidTail())
            .build();

        var healthyDogRequest = getDemandingPetRequest();

        InvalidTailLengthException invalidTailLengthException = assertThrows(InvalidTailLengthException.class,
            () -> petValidatorService.validatePet(unhealthyDog, healthyDogRequest));

        assertThat(invalidTailLengthException.getMessage()).contains("Invalid tail length -1");
    }
}
