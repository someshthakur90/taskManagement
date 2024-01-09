package com.ResoTech.taskManagementApp.Advice;

import exception.NullValueNotAccepted;
import exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> err = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.put(error.getField(),error.getDefaultMessage());
        });
        return err;
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleBuissnessException(TaskNotFoundException ex) {
        Map<String,String> err = new HashMap<>();
        err.put("errorMessage",ex.getMessage());
        return err;
    }
    @ExceptionHandler(NullValueNotAccepted.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleException(NullValueNotAccepted ex) {
        Map<String,String> er = new HashMap<>();
        er.put("errorMessage", ex.getMessage());
        return er;
    }
}
