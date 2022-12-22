package com.jumio.sdk.exceptions;

public class SDKNotConfiguredException extends Exception {
    public SDKNotConfiguredException() {
    }

    public SDKNotConfiguredException(String str) {
        super(str);
    }

    public SDKNotConfiguredException(Throwable th) {
        super(th);
    }

    public SDKNotConfiguredException(String str, Throwable th) {
        super(str, th);
    }
}
