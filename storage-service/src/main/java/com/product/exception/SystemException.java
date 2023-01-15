package com.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends Exception{
    public SystemException() {
        super();
    }
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
    public SystemException(String message) {
        super(message);
    }
    public SystemException(Throwable cause) {
        super(cause);
    }

}
