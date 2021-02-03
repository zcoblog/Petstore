package com.petstore.validators;

import com.petstore.exception.TooOldException;
import com.petstore.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class AgeValidator {

    public void validateAge(Pet pet, Integer maxAgeExpectation){
        if(pet.getAgeInMonths() > maxAgeExpectation){
            throw new TooOldException(pet.getId(), pet.getAgeInMonths(), maxAgeExpectation);
        }
    }
}
