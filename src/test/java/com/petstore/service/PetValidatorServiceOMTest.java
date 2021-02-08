package com.petstore.service;

import com.petstore.exception.*;
import com.petstore.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.petstore.demo.objectmother.PetObjectMother.*;
import static com.petstore.demo.objectmother.PetRequestObjectMother.getFairlyDemandingPetRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PetValidatorServiceOMTest {
    private final AgeValidator ageValidator = new AgeValidator();
    private final ColorValidator colorValidator = new ColorValidator();
    private final CutenessValidator cutenessValidator = new CutenessValidator();
    private final HealthValidator healthValidator = new HealthValidator();
    private final TailValidator tailValidator = new TailValidator();

    private final PetValidatorService petValidatorService = new PetValidatorService(ageValidator, colorValidator, cutenessValidator, healthValidator, tailValidator);

    @Test
    @DisplayName("Should throw NotCuteEnoughException when pet isn't as cute as specified")
    void validationFailsWhenPetNotCuteEnough() {
        // looks cleaner, but it's still difficult to see what effects the test
        var pet = getNotSoCuteDog();

        var petRequest = getFairlyDemandingPetRequest();

        NotCuteEnoughException notCuteEnoughException = assertThrows(NotCuteEnoughException.class,
            () -> petValidatorService.validatePet(pet, petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("Not cute enough, cuteness rating of 2, where minimum cuteness defined as 8");
    }

    @Test
    @DisplayName("Should throw TooOldException when pet is too old")
    void validationFailsWhenPetIsTooOld() {
        var pet = getOldDoggo();

        var petRequest = getFairlyDemandingPetRequest();

        TooOldException notCuteEnoughException = assertThrows(TooOldException.class,
            () -> petValidatorService.validatePet(pet, petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("is 120 months old but max age of 12 months was requested");
    }

    @Test
    @DisplayName("Should throw WrongColorException when the pet is the wrong color")
    void validationFailsWhenPetIsWrongColor() {
        var healthyButNotSoCuteDog = getWhiteDoggo();

        var petRequestWithUnrealisticBeautyStandards = getFairlyDemandingPetRequest();

        WrongColorException wrongColorException = assertThrows(WrongColorException.class,
            () -> petValidatorService.validatePet(healthyButNotSoCuteDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(wrongColorException.getMessage()).contains("was of the color white, where the expected color was brown");
    }

    @Test
    @DisplayName("Should throw NotHealthyEnoughException when the pet is not healthy")
    void validationFailsWhenPetIsNotHealthyEnough() {
        var unhealthyDog = getUnhealthyDoggo();

        var petRequestWithUnrealisticBeautyStandards = getFairlyDemandingPetRequest();

        NotHealthyEnoughException wrongColorException = assertThrows(NotHealthyEnoughException.class,
            () -> petValidatorService.validatePet(unhealthyDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(wrongColorException.getMessage()).contains("Not healthy enough, health rating of 1, where minimum health defined as 8");
    }

    @Test
    @DisplayName("Should throw TailFluffinessNotAsRequestedException when the tail is not as long as requested")
    void validationFailsWhenTailIsNotLongEnough() {
        var unhealthyDog = getDefaultDoggoWithShortTail();

        var petRequestWithUnrealisticBeautyStandards = getFairlyDemandingPetRequest();

        TailLengthShorterThanRequestedException tailLengthShorterThanRequestedException = assertThrows(TailLengthShorterThanRequestedException.class,
            () -> petValidatorService.validatePet(unhealthyDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(tailLengthShorterThanRequestedException.getMessage()).contains("Expected a tail length of 10, however the tail length was 0");
    }

}
