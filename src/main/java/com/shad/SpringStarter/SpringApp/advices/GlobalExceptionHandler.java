package com.shad.SpringStarter.SpringApp.advices;

import com.shad.SpringStarter.SpringApp.exceptions.ResourceNotFoundException;
import com.sun.net.httpserver.HttpsConfigurator;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception){
        ApiError error= ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return buildApiResponseError(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception){
        List<String> validationErrors=exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(validationError-> validationError.getDefaultMessage())
                .collect(Collectors.toList());
       ApiError error= ApiError.builder().status(HttpStatus.BAD_REQUEST).message("Validation Failed!").subErrors(validationErrors).build();
       return buildApiResponseError(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception){
        ApiError error= ApiError.builder().status(HttpStatus.BAD_REQUEST).message(exception.getMessage()).build();
        return buildApiResponseError(error);
    }
    private ResponseEntity<ApiResponse<?>> buildApiResponseError(ApiError apiError){
         return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }
}
