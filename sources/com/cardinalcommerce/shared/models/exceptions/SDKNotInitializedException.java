package com.cardinalcommerce.shared.models.exceptions;

public class SDKNotInitializedException extends RuntimeException {
    private final String Cardinal;
    private final Throwable configure;

    public String getMessage() {
        return this.Cardinal;
    }

    public Throwable getCause() {
        return this.configure;
    }

    public SDKNotInitializedException(String str, Throwable th) {
        this.Cardinal = str;
        this.configure = th;
    }

    public SDKNotInitializedException(RuntimeException runtimeException) {
        this.Cardinal = runtimeException.getMessage();
        this.configure = runtimeException.getCause();
    }
}
