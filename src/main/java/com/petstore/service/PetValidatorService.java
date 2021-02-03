package com.petstore.service;

import com.petstore.dto.PetRequest;
import com.petstore.model.Pet;
import com.petstore.validators.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetValidatorService {

    private final AgeValidator ageValidator;
    private final ColorValidator colorValidator;
    private final CutenessValidator cutenessValidator;
    private final HealthValidator healthValidator;
    private final TailValidator tailValidator;

    public void validatePet(Pet pet, PetRequest petRequest) {
        ageValidator.validateAge(pet, petRequest.getMaxAgeInMonthsExpectation());
        colorValidator.validateColor(pet, petRequest.getColorExpectation());
        cutenessValidator.validateCuteness(pet, petRequest.getCutenessExpectation());
        healthValidator.validateHealth(pet, petRequest.getHealthExpectation());
        tailValidator.validateTail(pet.getTail(), petRequest.getTailRequest());
    }
}
