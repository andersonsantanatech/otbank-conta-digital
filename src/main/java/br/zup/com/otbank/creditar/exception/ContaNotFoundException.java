package br.zup.com.otbank.creditar.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContaNotFoundException extends RuntimeException{

    public ContaNotFoundException(String message) {
        super(message);
    }
}
