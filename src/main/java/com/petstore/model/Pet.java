package com.petstore.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Pet {
    String id = UUID.randomUUID().toString();
    String name;
    Integer ageInMonths;
    Integer cuteness;
    Integer healthRating;
    String color;
    Tail tail;
    PetType petType;
}
