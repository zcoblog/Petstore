package com.petstore.validators;

import com.petstore.exception.NotCuteEnoughException;
import com.petstore.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class CutenessValidator {

    public void validateCuteness(Pet pet, Integer minCutenessExpectation){
        if(pet.getCuteness() < minCutenessExpectation){
            throw new NotCuteEnoughException(pet.getId(), pet.getCuteness(), minCutenessExpectation);
        }
    }
}
