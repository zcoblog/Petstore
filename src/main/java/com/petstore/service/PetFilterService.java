package com.petstore.service;

import com.petstore.dto.PetRequest;
import com.petstore.service.filter.*;
import com.petstore.model.Pet;
import com.petstore.model.ValidationFailure;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetFilterService {

    private final AgeFilter ageFilter;
    private final ColorFilter colorFilter;
    private final CutenessFilter cutenessFilter;
    private final HealthFilter healthFilter;
    private final TailFilter tailFilter;

    private final List<ValidationFailure> validationFailures;

    public boolean filterPetAgainstPetRequest(Pet pet, PetRequest petRequest) {
        ageFilter.collectAgeValidationFailures(pet, petRequest.getMaxAgeInMonthsExpectation()).ifPresent(validationFailures::add);
        colorFilter.collectColorValidationFailures(pet, petRequest.getColorExpectation()).ifPresent(validationFailures::add);
        cutenessFilter.collectCutenessValidationFailures(pet, petRequest.getCutenessExpectation()).ifPresent(validationFailures::add);
        healthFilter.collectHealthValidationFailures(pet, petRequest.getHealthExpectation()).ifPresent(validationFailures::add);
        tailFilter.collectTailValidationFailures(pet.getTail(), petRequest.getTailRequest()).ifPresent(validationFailures::add);

        if(!validationFailures.isEmpty()) {
            log.info("pet not suitable for request, failed with {} validation errors", validationFailures.stream().map(Enum::name).collect(Collectors.joining(", ")));
            return false;
        }

        return true;
    }
}
