package com.shad.SpringStarter.SpringApp.advices;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ApiResponse<T> {
    private LocalDateTime timeStamp;
    private T data;
    private ApiError apiError;

    public ApiResponse(){
        timeStamp=LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();
        this.data=data;
    }
    public ApiResponse(ApiError apiError){
        this();
        this.apiError=apiError;
    }


}
