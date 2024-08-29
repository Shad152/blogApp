package com.shad.SpringStarter.SpringApp.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
         super(message);
    }
}
