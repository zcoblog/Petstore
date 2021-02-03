package com.petstore.testdatabuilders;

import com.petstore.model.Tail;
import com.petstore.model.TailFluffiness;

public class TailTestDataTemplate {
    public static TailTestDataTemplateBuilder builder() {
        return new TailTestDataTemplateBuilder();
    }

    public static class TailTestDataTemplateBuilder {
        private Integer tailLength = 10;
        private TailFluffiness tailFluffiness = TailFluffiness.SUPER_FLUFFY;

        TailTestDataTemplateBuilder() {
        }

        public TailTestDataTemplateBuilder tailLength(Integer tailLength) {
            this.tailLength = tailLength;
            return this;
        }

        public TailTestDataTemplateBuilder tailFluffiness(TailFluffiness tailFluffiness) {
            this.tailFluffiness = tailFluffiness;
            return this;
        }

        public TailTestDataTemplateBuilder invalidTailLength() {
            this.tailLength = -1;
            return this;
        }

        public Tail build() {
            return Tail.builder()
                .tailLength(tailLength)
                .tailFluffiness(tailFluffiness)
                .build();
        }
    }
}
