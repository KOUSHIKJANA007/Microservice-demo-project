package com.koushik.HotelService.Exception;

import com.koushik.HotelService.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloabalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiresponse = ApiResponse.builder().message(message).success(true).build();
        return new ResponseEntity<>(apiresponse, HttpStatus.NOT_FOUND);

    }
}
