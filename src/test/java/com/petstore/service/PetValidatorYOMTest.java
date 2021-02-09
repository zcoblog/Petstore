package com.petstore.service;

import com.petstore.exception.*;
import com.petstore.service.validator.NewPetValidatorService;
import com.petstore.validators.AgeValidator;
import com.petstore.validators.CutenessValidator;
import com.petstore.validators.HealthValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.petstore.youngobjectmother.PetDonationRequestProvider.getPetDonationRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PetValidatorYOMTest {
    private final AgeValidator ageValidator = new AgeValidator();
    private final CutenessValidator cutenessValidator = new CutenessValidator();
    private final HealthValidator healthValidator = new HealthValidator();

    private final NewPetValidatorService newPetValidatorService = new NewPetValidatorService(ageValidator, cutenessValidator, healthValidator);

    @Test
    void validationFailsWhenPetNotCuteEnough() {
        var petRequest = getPetDonationRequest().toBuilder().cuteness(0).build();

        NotCuteEnoughException notCuteEnoughException = assertThrows(NotCuteEnoughException.class,
            () -> newPetValidatorService.validatePet(petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("Not cute enough");
    }

    @Test
    void validationFailsWhenPetIsTooOld() {
        var petRequest = getPetDonationRequest().toBuilder().age(3000).build();

        TooOldException notCuteEnoughException = assertThrows(TooOldException.class,
            () -> newPetValidatorService.validatePet(petRequest));

        assertThat(notCuteEnoughException.getMessage()).contains("Animal is 120 months old but max age of 3000 months was requested");
    }

    @Test
    @DisplayName("Should throw NotHealthyEnoughException when the pet is not healthy")
    void validationFailsWhenPetIsNotHealthyEnough() {
    var healthyDogRequest = getPetDonationRequest();

        NotHealthyEnoughException wrongColorException = assertThrows(NotHealthyEnoughException.class,
            () -> newPetValidatorService.validatePet(healthyDogRequest));

        assertThat(wrongColorException.getMessage()).contains("Not healthy enough, where minimum health defined as 1");
    }
}
