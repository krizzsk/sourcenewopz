package com.cardinalcommerce.shared.models.exceptions;

public class SDKRuntimeException extends RuntimeException {
    private final String Cardinal;
    private final Throwable cca_continue;

    public String getMessage() {
        return this.Cardinal;
    }

    public Throwable getCause() {
        return this.cca_continue;
    }

    public SDKRuntimeException(String str, Throwable th) {
        this.Cardinal = str;
        this.cca_continue = th;
    }

    public SDKRuntimeException(RuntimeException runtimeException) {
        this.Cardinal = runtimeException.getMessage();
        this.cca_continue = runtimeException.getCause();
    }
}
