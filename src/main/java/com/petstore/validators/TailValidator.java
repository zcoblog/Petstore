package com.petstore.validators;

import com.petstore.dto.TailRequest;
import com.petstore.exception.InvalidTailLengthException;
import com.petstore.exception.TailFluffinessNotAsRequestedException;
import com.petstore.exception.TailLengthShorterThanRequestedException;
import com.petstore.model.Tail;
import org.springframework.stereotype.Service;

@Service
public class TailValidator {
    public void validateTail(Tail tail, TailRequest tailRequest){
        if(!tail.getTailFluffiness().equals(tailRequest.getTailFluffiness())){
            throw new TailFluffinessNotAsRequestedException(tail.getTailFluffiness(), tailRequest.getTailFluffiness());
        }
        if(tail.getTailLength() < 0){
            throw new InvalidTailLengthException(tail.getTailLength());
        }
        if(tail.getTailLength() < tailRequest.getTailLength()){
            throw new TailLengthShorterThanRequestedException(tail.getTailLength(), tailRequest.getTailLength());
        }
    }
}
