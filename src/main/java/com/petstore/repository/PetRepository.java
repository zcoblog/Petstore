package com.petstore.repository;

import com.petstore.model.Pet;

import java.util.List;

public interface PetRepository {
    Pet postNewPet(Pet pet);

    Pet get(String id);

    List<Pet> getAllPets();
}
