package com.aytugakin.ttablegen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentNoAlreadyException extends RuntimeException{
    public String message;
    public StudentNoAlreadyException(String message) {
        super(message);
    }
}
