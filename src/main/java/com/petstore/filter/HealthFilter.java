package com.petstore.filter;

import com.petstore.exception.InvalidHealthRatingException;
import com.petstore.model.Pet;
import com.petstore.model.ValidationFailure;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.petstore.model.ValidationFailure.NOT_HEALTHY_ENOUGH;

@Service
public class HealthFilter {

    public Optional<ValidationFailure> collectHealthValidationFailures(Pet pet, Integer minHealthRatingExpectation){
        if(pet.getHealthRating() < 0){
            throw new InvalidHealthRatingException(pet.getHealthRating());
        }
        if(pet.getHealthRating() < minHealthRatingExpectation){
            return Optional.of(NOT_HEALTHY_ENOUGH);
        }
        return Optional.empty();
    }
}
