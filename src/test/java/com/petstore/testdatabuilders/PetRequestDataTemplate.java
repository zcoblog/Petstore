package com.petstore.testdatabuilders;

import com.petstore.dto.PetRequest;
import com.petstore.dto.TailRequest;
import com.petstore.model.PetType;

public class PetRequestDataTemplate {
    public static PetRequestDataTemplateBuilder builder() {
        return new PetRequestDataTemplateBuilder();
    }

    public static class PetRequestDataTemplateBuilder {
        private Integer maxAgeInMonthsExpectation = 10;
        private Integer cutenessExpectation = 10;
        private Integer healthExpectation = 10;
        private String colorExpectation = "brown";
        private PetType petType = PetType.DOG;
        private TailRequest tailRequest = TailRequestDataTemplate.builder().build();

        PetRequestDataTemplateBuilder() {
        }

        public PetRequestDataTemplateBuilder maxAgeInMonthsExpectation(Integer maxAgeInMonthsExpectation) {
            this.maxAgeInMonthsExpectation = maxAgeInMonthsExpectation;
            return this;
        }

        public PetRequestDataTemplateBuilder cutenessExpectation(Integer cutenessExpectation) {
            this.cutenessExpectation = cutenessExpectation;
            return this;
        }

        public PetRequestDataTemplateBuilder healthExpectation(Integer healthExpectation) {
            this.healthExpectation = healthExpectation;
            return this;
        }

        public PetRequestDataTemplateBuilder colorExpectation(String colorExpectation) {
            this.colorExpectation = colorExpectation;
            return this;
        }

        public PetRequestDataTemplateBuilder petType(PetType petType) {
            this.petType = petType;
            return this;
        }

        public PetRequestDataTemplateBuilder tailRequest(TailRequest tailRequest) {
            this.tailRequest = tailRequest;
            return this;
        }

        public PetRequest build() {
            return PetRequest.builder()
                    .maxAgeInMonthsExpectation(maxAgeInMonthsExpectation)
                    .cutenessExpectation(cutenessExpectation)
                    .healthExpectation(healthExpectation)
                    .colorExpectation(colorExpectation)
                    .petType(petType)
                    .tailRequest(tailRequest)
                .build();
        }
    }
}
