package com.petstore.service;

import com.petstore.dto.PetDonationRequest;
import com.petstore.dto.PetRequest;
import com.petstore.dto.PetResponse;
import com.petstore.model.Pet;
import com.petstore.repository.PetRepository;
import com.petstore.service.validator.NewPetValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetFilterService petFilterService;
    private final NewPetValidatorService newPetValidatorService;
    private final PetRepository petRepository;

    public Pet processDonation(PetDonationRequest petDonationRequest) {
        newPetValidatorService.validatePet(petDonationRequest);

        return petRepository.postNewPet(petDonationRequest.toPetEntity());
    }

    public PetResponse getThisPet(String id) {
        Pet pet = petRepository.get(id);
        return PetResponse.fromPet(pet);
    }

    public List<PetResponse> getAllPetsThatFulfilRequirements(PetRequest petRequest) {
        List<Pet> allPets = petRepository.getAllPets();

        return allPets
            .stream()
            .filter(pet -> petFilterService.filterPetAgainstPetRequest(pet, petRequest))
            .map(PetResponse::fromPet)
            .collect(Collectors.toList());
    }
}
