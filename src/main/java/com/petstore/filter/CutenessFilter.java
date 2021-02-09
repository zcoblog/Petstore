package com.petstore.filter;

import com.petstore.model.Pet;
import com.petstore.model.ValidationFailure;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.petstore.model.ValidationFailure.NOT_CUTE_ENOUGH;

@Service
public class CutenessFilter {

    public Optional<ValidationFailure> collectCutenessValidationFailures(Pet pet, Integer minCutenessExpectation){
        if(pet.getCuteness() < minCutenessExpectation){
            return Optional.of(NOT_CUTE_ENOUGH);
        }
        return Optional.empty();
    }
}
