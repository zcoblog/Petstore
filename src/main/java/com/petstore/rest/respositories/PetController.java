package com.petstore.rest.respositories;

import com.petstore.dto.PetDonationRequest;
import com.petstore.dto.PetDonationResponse;
import com.petstore.dto.PetRequest;
import com.petstore.dto.PetResponse;
import com.petstore.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @Operation(description = "Donating a new pet to the pet store")
    @PostMapping("/")
    public PetDonationResponse postPet(@Valid  PetDonationRequest petDonationRequest){
        return PetDonationResponse.fromPet(petService.processDonation(petDonationRequest));
    }

    @Operation(description = "Get a specific pet with a known pet ID")
    @GetMapping("/")
    public PetResponse getPet(String id){
        return petService.getThisPet(id);
    }

    @Operation(description = "Get all of the pets that fit the specified criteria and log all of the reasons the pets that don't aren't a good fit")
    @GetMapping("/potential/pets")
    public List<PetResponse> getPet(PetRequest petRequest){
        return petService.getAllPetsThatFulfilRequirements(petRequest);
    }

}
