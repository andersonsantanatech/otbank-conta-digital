package br.zup.com.otbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableContaException extends RuntimeException {
    public UnprocessableContaException(String message) {
        super(message);
    }
}
