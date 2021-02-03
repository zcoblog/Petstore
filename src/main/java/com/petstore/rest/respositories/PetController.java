package com.petstore.rest.respositories;

import com.petstore.dto.PetRequest;
import com.petstore.dto.PetResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/v1/pets")
public class PetController {

    @PostMapping()
    public PetResponse postPet(PetRequest petDto){
        return PetResponse.fromPetRequest(petDto);
    }

}
