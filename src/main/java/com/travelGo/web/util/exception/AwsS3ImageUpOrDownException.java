package com.travelGo.web.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AwsS3ImageUpOrDownException extends RuntimeException {
    public AwsS3ImageUpOrDownException(String message){
        super(message);
    }
}
