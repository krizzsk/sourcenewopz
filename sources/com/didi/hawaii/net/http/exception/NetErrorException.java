package com.didi.hawaii.net.http.exception;

import java.io.IOException;

public class NetErrorException extends IOException {
    private static final long serialVersionUID = 8531903196657910187L;

    public NetErrorException() {
    }

    public NetErrorException(String str) {
        super(str);
    }

    public NetErrorException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
