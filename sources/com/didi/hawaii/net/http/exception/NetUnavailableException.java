package com.didi.hawaii.net.http.exception;

import java.io.IOException;

public class NetUnavailableException extends IOException {
    private static final long serialVersionUID = 2783283891376573878L;

    public NetUnavailableException() {
    }

    public NetUnavailableException(String str) {
        super(str);
    }

    public NetUnavailableException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
