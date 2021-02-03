package com.petstore.validators;

import com.petstore.exception.InvalidHealthRatingException;
import com.petstore.exception.NotHealthyEnoughException;
import com.petstore.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class HealthValidator {

    public void validateHealth(Pet pet, Integer minHealthRatingExpectation){
        if(pet.getHealthRating() < 0){
            throw new InvalidHealthRatingException(pet.getId(), pet.getHealthRating());
        }
        if(pet.getHealthRating() < minHealthRatingExpectation){
            throw new NotHealthyEnoughException(pet.getId(), pet.getHealthRating(), minHealthRatingExpectation);
        }
    }
}
