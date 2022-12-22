package com.didichuxing.mas.sdk.quality.report.transport;

import java.io.IOException;

public class FileTooLargeException extends IOException {
    public FileTooLargeException() {
    }

    public FileTooLargeException(String str) {
        super(str);
    }
}
