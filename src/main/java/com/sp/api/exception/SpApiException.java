package com.sp.api.exception;

import com.sp.api.entity.Message;

/**
 * Author Pershin Andrew
 */
public class SpApiException extends Exception {
    private String description;

    public SpApiException(Throwable e){
        super(e);
    }
    public SpApiException(String description){
        super(description);
    }
    public SpApiException(String description, Throwable throwable){
        super(description, throwable);
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
