package com.github.deafmist.socksstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalQuantityException extends RuntimeException {
    public IllegalQuantityException() {
    }

    public IllegalQuantityException(String message) {
        super(message);
    }
}
