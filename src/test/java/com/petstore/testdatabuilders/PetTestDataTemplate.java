package com.petstore.testdatabuilders;

import com.petstore.model.Pet;
import com.petstore.model.PetType;
import com.petstore.model.Tail;

public class PetTestDataTemplate {
    public static PetTestDataTemplateBuilder builder() {
        return new PetTestDataTemplateBuilder();
    }

    public static class PetTestDataTemplateBuilder {
        private String name = "woofy";
        private Integer ageInMonths = 0;
        private Integer cuteness = 10;
        private Integer healthRating = 10;
        private String color = "brown";
        private PetType petType = PetType.DOG;
        private Tail tail = TailTestDataTemplate.builder().build();

        PetTestDataTemplateBuilder() {
        }

        public PetTestDataTemplateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetTestDataTemplateBuilder ageInMonths(Integer ageInMonths) {
            this.ageInMonths = ageInMonths;
            return this;
        }

        public PetTestDataTemplateBuilder cuteness(Integer cuteness) {
            this.cuteness = cuteness;
            return this;
        }

        public PetTestDataTemplateBuilder invalidHealthRating(){
            this.healthRating = -1;
            return this;
        }

        public PetTestDataTemplateBuilder healthRating(Integer healthRating) {
            this.healthRating = healthRating;
            return this;
        }

        public PetTestDataTemplateBuilder color(String color) {
            this.color = color;
            return this;
        }

        public PetTestDataTemplateBuilder tail(Tail tail) {
            this.tail = tail;
            return this;
        }

        public PetTestDataTemplateBuilder petType(PetType petType) {
            this.petType = petType;
            return this;
        }

        public Pet build() {
            return Pet.builder()
                .name(name)
                .ageInMonths(ageInMonths)
                .cuteness(cuteness)
                .healthRating(healthRating)
                .color(color)
                .petType(petType)
                .tail(tail)
                .build();
        }
    }
}
