package com.petstore.demo.testdatabuilders;

import com.petstore.dto.TailRequest;
import com.petstore.model.TailFluffiness;

public class TailRequestDataTemplate {
    public static TailRequestDataTemplateBuilder builder() {
        return new TailRequestDataTemplateBuilder();
    }

    public static class TailRequestDataTemplateBuilder {
        private Integer tailLength = 10;
        private TailFluffiness tailFluffiness = TailFluffiness.SUPER_FLUFFY;

        TailRequestDataTemplateBuilder() {
        }

        public TailRequestDataTemplateBuilder tailLength(Integer tailLength) {
            this.tailLength = tailLength;
            return this;
        }

        public TailRequestDataTemplateBuilder tailFluffiness(TailFluffiness tailFluffiness) {
            this.tailFluffiness = tailFluffiness;
            return this;
        }

        public TailRequest build() {
            return TailRequest
                .builder()
                .tailLength(tailLength)
                .tailFluffiness(tailFluffiness)
                .build();
        }
    }
}
