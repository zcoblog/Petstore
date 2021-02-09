package com.petstore.repository;

import com.petstore.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepositoryImpl implements PetRepository {

    public Pet postNewPet(Pet pet) {
        return Pet.builder().build();
    }

    public Pet get(String id) {
        return Pet.builder().build();
    }

    @Override
    public List<Pet> getAllPets() {
        return List.of(Pet.builder().build());
    }

}
