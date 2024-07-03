package com.backend.pizzaria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException {
    private static final long serialVersionUID = 1l;
    public InvalidJwtAuthenticationException(String ex){
        super(ex);
    }

    public InvalidJwtAuthenticationException(String ex, Throwable cause){
        super(ex, cause);
    }

}
