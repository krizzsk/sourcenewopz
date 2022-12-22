package com.didi.foundation.sdk.log;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public final class LogService {
    private LogService() {
    }

    public static Logger getLogger(Class<?> cls) {
        return LoggerFactory.getLogger(cls);
    }

    public static Logger getLogger(String str) {
        return LoggerFactory.getLogger(str);
    }

    public static Logger getLogger(Class<?> cls, String str) {
        return LoggerFactory.getLogger(cls, str);
    }

    public static Logger getLogger(String str, String str2) {
        return LoggerFactory.getLogger(str, str2);
    }
}
