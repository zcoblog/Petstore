package com.petstore.service;

import com.petstore.exception.*;
import com.petstore.demo.testdatabuilders.PetRequestDataTemplate;
import com.petstore.demo.testdatabuilders.PetTestDataTemplate;
import com.petstore.demo.testdatabuilders.TailTestDataTemplate;
import com.petstore.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PetValidatorServiceTDTTest {
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
        var pet = PetTestDataTemplate.builder().cuteness(1).build();

        var petRequest = PetRequestDataTemplate.builder().build();

        NotCuteEnoughException notCuteEnoughException = assertThrows(NotCuteEnoughException.class,
            () -> petValidatorService.validatePet(pet, petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("Not cute enough, cuteness rating of 1, where minimum cuteness defined as 10");
    }

    @Test
    @DisplayName("Should throw TooOldException when pet is too old")
    void validationFailsWhenPetIsTooOld() {
        var pet = PetTestDataTemplate.builder().ageInMonths(120).build();

        var petRequest = PetRequestDataTemplate.builder().build();

        TooOldException notCuteEnoughException = assertThrows(TooOldException.class,
            () -> petValidatorService.validatePet(pet, petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("is 120 months old but max age of 10 months was requested");
    }

    @Test
    @DisplayName("Should throw WrongColorException when the pet is the wrong color")
    void validationFailsWhenPetIsWrongColor() {
        var healthyButNotSoCuteDog = PetTestDataTemplate.builder().color("white").build();

        var petRequestWithUnrealisticBeautyStandards = PetRequestDataTemplate.builder().build();

        WrongColorException wrongColorException = assertThrows(WrongColorException.class,
            () -> petValidatorService.validatePet(healthyButNotSoCuteDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(wrongColorException.getMessage()).contains("was of the color white, where the expected color was brown");
    }

    @Test
    @DisplayName("Should throw NotHealthyEnoughException when the pet is not healthy")
    void validationFailsWhenPetIsNotHealthyEnough() {
        var unhealthyDog = PetTestDataTemplate.builder().healthRating(1).build();

        var petRequestWithUnrealisticBeautyStandards = PetRequestDataTemplate.builder().build();

        NotHealthyEnoughException wrongColorException = assertThrows(NotHealthyEnoughException.class,
            () -> petValidatorService.validatePet(unhealthyDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(wrongColorException.getMessage()).contains("Not healthy enough, health rating of 1, where minimum health defined as 10");
    }

    @Test
    @DisplayName("Should throw Invalid Health Value Exception health rating is below 0")
    void validationFailsWhenPetHealthRatingIsBelow0() {
        var unhealthyDog = PetTestDataTemplate.builder().invalidHealthRating().build();

        var petRequestWithUnrealisticBeautyStandards = PetRequestDataTemplate.builder().build();

        InvalidHealthRatingException wrongColorException = assertThrows(InvalidHealthRatingException.class,
            () -> petValidatorService.validatePet(unhealthyDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(wrongColorException.getMessage()).contains("failed health validation, a health rating of -1 was provided, which is invalid");
    }

    @Test
    @DisplayName("Should throw Invalid Health Value Exception health rating is below 0")
    void validationFailsWhenTailLengthIsInvalidRatingIsBelow0() {
        var shortTailDog = PetTestDataTemplate
            .builder()
            .tail(
                TailTestDataTemplate
                    .builder()
                    .invalidTailLength()
                    .build()
            ).build();

        var petRequestWithUnrealisticBeautyStandards = PetRequestDataTemplate.builder().build();

        InvalidTailLengthException invalidTailLengthException = assertThrows(InvalidTailLengthException.class,
            () -> petValidatorService.validatePet(shortTailDog, petRequestWithUnrealisticBeautyStandards));

        assertThat(invalidTailLengthException.getMessage()).contains("Invalid tail length -1");
    }

}
