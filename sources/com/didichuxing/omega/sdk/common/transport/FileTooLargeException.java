package com.didichuxing.omega.sdk.common.transport;

import java.io.IOException;

public class FileTooLargeException extends IOException {
    public FileTooLargeException() {
    }

    public FileTooLargeException(String str) {
        super(str);
    }
}
