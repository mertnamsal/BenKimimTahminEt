package com.mert.exception;

import lombok.Getter;

@Getter
public class BenKimimException extends RuntimeException {

    private final ErrorType errorType;
    public BenKimimException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;

    }
    public BenKimimException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
