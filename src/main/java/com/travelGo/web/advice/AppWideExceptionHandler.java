package com.travelGo.web.advice;

import com.travelGo.web.util.exception.AwsS3ImageUpOrDownException;
import com.travelGo.web.util.exception.EntryNotFoundException;
import com.travelGo.web.util.response.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFound(EntryNotFoundException exception){
        return new ResponseEntity(
                new StandardResponse(
                        404,
                        exception.getMessage(),
                        "Not Found"
                ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AwsS3ImageUpOrDownException.class)
    public ResponseEntity<StandardResponse> handleImageException(AwsS3ImageUpOrDownException exception){
        return new ResponseEntity(
                new StandardResponse(
                        404,
                        exception.getMessage(),
                        "Something went wrong. check internet connection and AWS Credentials"
                ), HttpStatus.BAD_REQUEST
        );
    }
}
