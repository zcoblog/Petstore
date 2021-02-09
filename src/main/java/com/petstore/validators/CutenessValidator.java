package com.petstore.validators;

import com.petstore.exception.NotCuteEnoughException;
import org.springframework.stereotype.Service;

@Service
public class CutenessValidator {
    private final Integer minimumCutenessRequirements = 1;

    public void validateCuteness(Integer cuteness){
        if(minimumCutenessRequirements > cuteness){
            throw new NotCuteEnoughException(cuteness);
        }
    }
}
