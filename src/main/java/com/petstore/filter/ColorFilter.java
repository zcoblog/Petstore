package com.petstore.filter;

import com.petstore.model.Pet;
import com.petstore.model.ValidationFailure;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.petstore.model.ValidationFailure.WRONG_COLOR;

@Service
public class ColorFilter {
    public Optional<ValidationFailure> collectColorValidationFailures(Pet pet, String color){
        if(!pet.getColor().equals(color)){
            return Optional.of(WRONG_COLOR);
        }
        return Optional.empty();
    }
}
