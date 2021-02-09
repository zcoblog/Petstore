package com.petstore.filter;

import com.petstore.model.Pet;
import com.petstore.model.ValidationFailure;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.petstore.model.ValidationFailure.TOO_OLD;

@Service
public class AgeFilter {

    public Optional<ValidationFailure> collectAgeValidationFailures(Pet pet, Integer maxAgeExpectation){
        if(pet.getAgeInMonths() > maxAgeExpectation){
            return Optional.of(TOO_OLD);
        }
        return Optional.empty();
    }
}
