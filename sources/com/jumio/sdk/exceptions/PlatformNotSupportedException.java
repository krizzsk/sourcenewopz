package com.jumio.sdk.exceptions;

public class PlatformNotSupportedException extends Exception {
    public PlatformNotSupportedException() {
    }

    public PlatformNotSupportedException(String str) {
        super(str);
    }

    public PlatformNotSupportedException(Throwable th) {
        super(th);
    }

    public PlatformNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
