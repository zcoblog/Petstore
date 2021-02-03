package com.petstore.validators;

import com.petstore.exception.WrongColorException;
import com.petstore.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class ColorValidator {

    public void validateColor(Pet pet, String color){
        if(!pet.getColor().equals(color)){
            throw new WrongColorException(pet.getId(), pet.getColor(), color);
        }
    }
}
