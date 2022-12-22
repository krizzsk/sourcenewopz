package com.cardinalcommerce.shared.models.exceptions;

public class InvalidInputException extends RuntimeException {
    private final Throwable getInstance;
    private final String init;

    public String getMessage() {
        return this.init;
    }

    public Throwable getCause() {
        return this.getInstance;
    }

    public InvalidInputException(String str, Throwable th) {
        this.init = str;
        this.getInstance = th;
    }

    public InvalidInputException(RuntimeException runtimeException) {
        this.init = runtimeException.getMessage();
        this.getInstance = runtimeException.getCause();
    }
}
