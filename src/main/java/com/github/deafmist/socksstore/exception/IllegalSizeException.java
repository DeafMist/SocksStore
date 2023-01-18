package com.github.deafmist.socksstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalSizeException extends RuntimeException {
    public IllegalSizeException() {
    }

    public IllegalSizeException(String message) {
        super(message);
    }
}
