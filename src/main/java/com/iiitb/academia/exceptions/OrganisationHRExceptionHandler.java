package com.iiitb.academia.exceptions;

import com.iiitb.academia.exceptions.model.DuplicateEmailException;
import com.iiitb.academia.exceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrganisationHRExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(DuplicateEmailException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.CONFLICT.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
