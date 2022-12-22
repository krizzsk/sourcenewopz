package com.didi.safetoolkit.util;

public class SfParseException extends RuntimeException {
    private String mLocalCause;

    public SfParseException() {
    }

    public SfParseException(String str) {
        super(str);
    }

    public SfParseException(Throwable th) {
        super(th);
    }

    public SfParseException(Throwable th, String str) {
        super(th);
        this.mLocalCause = str;
    }

    public String getLocalCause() {
        return this.mLocalCause;
    }

    public SfParseException(String str, Throwable th) {
        super(str, th);
    }
}
