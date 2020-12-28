package com.sp.api.exception;

/**
 * Author Pershin Andrew
 */
public class SpApiServerException extends SpApiException {
    public SpApiServerException(String description, Throwable throwable) {
        super("Server exception: " + description, throwable);
    }
    public SpApiServerException(String description){
        super("Server exception: " + description);
    }
}
