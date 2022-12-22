package com.adyen.threeds2.exception;

public final class SDKRuntimeException extends RuntimeException {

    /* renamed from: a */
    private final String f994a;

    public SDKRuntimeException(String str, String str2, Throwable th) {
        super(str, th);
        this.f994a = str2;
    }

    public String getErrorCode() {
        return this.f994a;
    }
}
