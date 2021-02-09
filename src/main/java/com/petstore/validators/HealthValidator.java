package com.petstore.validators;

import com.petstore.exception.InvalidHealthRatingException;
import com.petstore.exception.NotHealthyEnoughException;
import org.springframework.stereotype.Service;

@Service
public class HealthValidator {
    private final Integer minHealthRating = 1;

    public void validateHealth(Integer healthRating){
        if(healthRating < 0){
            throw new InvalidHealthRatingException(healthRating);
        }
        if(minHealthRating < healthRating){
            throw new NotHealthyEnoughException(minHealthRating);
        }
    }
}
