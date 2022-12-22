package com.didi.hawaii.net.http.exception;

import java.io.IOException;

public class NetUnInitializedException extends IOException {
    private static final long serialVersionUID = 8017383535797143136L;

    public NetUnInitializedException() {
    }

    public NetUnInitializedException(String str) {
        super(str);
    }

    public NetUnInitializedException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
