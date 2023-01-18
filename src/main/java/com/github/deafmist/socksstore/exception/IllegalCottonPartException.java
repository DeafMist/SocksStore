package com.github.deafmist.socksstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalCottonPartException extends RuntimeException {
    public IllegalCottonPartException() {
    }

    public IllegalCottonPartException(String message) {
        super(message);
    }
}
