package com.didi.remotereslibrary.exception;

import java.io.IOException;

public class RemoteResourceNotFoundException extends IOException {
    public static final int ERROR_NO_NOT_FILE = 1;
    public static final int ERROR_NO_SWITCHOFF = 2;
    public String errorMsg;
    public int errorNo;

    public RemoteResourceNotFoundException(String str, int i) {
        super(str);
        this.errorMsg = str;
        this.errorNo = i;
    }
}
