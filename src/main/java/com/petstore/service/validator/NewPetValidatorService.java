package com.petstore.service.validator;

import com.petstore.dto.PetDonationRequest;
import com.petstore.validators.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewPetValidatorService {

    private final AgeValidator ageValidator;
    private final CutenessValidator cutenessValidator;
    private final HealthValidator healthValidator;

    public void validatePet(PetDonationRequest petRequest) {
        cutenessValidator.validateCuteness(petRequest.getCuteness());
        ageValidator.validateAge(petRequest.getAge());
        healthValidator.validateHealth(petRequest.getHealth());
    }
}
