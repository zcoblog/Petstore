package com.petstore.validators;

import com.petstore.exception.TooOldException;
import org.springframework.stereotype.Service;

@Service
public class AgeValidator {
    private final Integer maxAgeAllowedInMonths = 120;

    public void validateAge(Integer maxAgeExpectation){
        if(maxAgeAllowedInMonths < maxAgeExpectation){
            throw new TooOldException(maxAgeAllowedInMonths, maxAgeExpectation);
        }
    }
}
