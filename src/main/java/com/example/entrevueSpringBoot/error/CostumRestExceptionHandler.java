package com.example.entrevueSpringBoot.error;

import com.example.entrevueSpringBoot.resource.ApiErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class CostumRestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String CLIENT_ERROR_CODE = "desj.entrevue.client.error.message";
    @ExceptionHandler({NoSuchElementException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleNotFound(Exception ex){
        ApiErrorResource apiErrorResource = new ApiErrorResource(CLIENT_ERROR_CODE,ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiErrorResource, apiErrorResource.getStatus());
    }
}
