package com.petstore.service.filter;

import com.petstore.dto.TailRequest;
import com.petstore.exception.InvalidTailLengthException;
import com.petstore.model.Tail;
import com.petstore.model.ValidationFailure;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TailFilter {
    public Optional<ValidationFailure> collectTailValidationFailures(Tail tail, TailRequest tailRequest){
        if(!tail.getTailFluffiness().equals(tailRequest.getTailFluffiness())){
            return Optional.of(ValidationFailure.TAIL_NOT_FLUFFY_ENOUGH);
        }

        if(tail.getTailLength() < 0){
            throw new InvalidTailLengthException(tail.getTailLength());
        }
        if(tail.getTailLength() < tailRequest.getTailLength()){
            return Optional.of(ValidationFailure.TAIL_WRONG_LENGTH);
        }
        return Optional.empty();
    }
}
