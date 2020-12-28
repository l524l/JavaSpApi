package com.sp.api.exception;

/**
 * Author Pershin Andrew
 */
public class PlayerNotFoundException extends SpApiException {
    public PlayerNotFoundException() {
        super("Player not found by name or UUID");
    }
}
