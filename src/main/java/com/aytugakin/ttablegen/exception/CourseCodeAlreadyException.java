package com.aytugakin.ttablegen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class CourseCodeAlreadyException extends RuntimeException{
    private String message;
    public CourseCodeAlreadyException(String message){
        super(message);
    }
}
