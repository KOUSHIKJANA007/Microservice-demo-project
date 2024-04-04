package com.koushik.HotelService.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not fount at given location !!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
