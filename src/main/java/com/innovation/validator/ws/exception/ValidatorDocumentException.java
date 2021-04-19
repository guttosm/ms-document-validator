package com.innovation.validator.ws.exception;

public class ValidatorDocumentException extends RuntimeException {

    public ValidatorDocumentException(String message) {
        super(message);
    }

    public ValidatorDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorDocumentException(Throwable cause) {
        super(cause);
    }

    public ValidatorDocumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidatorDocumentException(String message, String reason) {
        super(message);
    }
}