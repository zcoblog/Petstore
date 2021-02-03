package com.petstore.dto;

import com.petstore.model.PetType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class PetRequest {
    Integer maxAgeInMonthsExpectation;
    Integer cutenessExpectation;
    Integer healthExpectation;
    String colorExpectation;
    PetType petType;
    TailRequest tailRequest;
}

