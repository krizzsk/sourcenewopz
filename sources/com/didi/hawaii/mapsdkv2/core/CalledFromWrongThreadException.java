package com.didi.hawaii.mapsdkv2.core;

import android.util.AndroidRuntimeException;

public final class CalledFromWrongThreadException extends AndroidRuntimeException {
    public CalledFromWrongThreadException(String str) {
        super(str);
    }
}
