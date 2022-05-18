package com.felipe.backend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessExceptionBadRequest extends RuntimeException{
    public BusinessExceptionBadRequest(String message){
        super(message);
    }
}
