package com.sandeep.springbootdemo.advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String,String> handleException(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }
    @ExceptionHandler(RuntimeException.class)
    Map<String,String> handleUserCreationException(RuntimeException ex){
        Map<String,String> errorMap = new HashMap<>();
            errorMap.put("error",ex.getMessage());
        return errorMap;
    }

}

