package com.iproov.sdk.core.exception;

import android.content.Context;

public class IProovException extends Exception {
    private final String reason;

    public IProovException(String str, String str2) {
        super(str2);
        this.reason = str;
    }

    public static IProovException getExceptionForACode(Context context, String str, String str2) {
        if ("invalid_device".equals(str)) {
            return new UnsupportedDeviceException(context, str2);
        }
        return new NetworkException(context, str2);
    }

    public String getReason() {
        return this.reason;
    }

    public IProovException(String str, Exception exc) {
        super(exc);
        this.reason = str;
    }
}
