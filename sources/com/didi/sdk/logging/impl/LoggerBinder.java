package com.didi.sdk.logging.impl;

import com.didi.sdk.logging.Level;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class LoggerBinder {
    public static LoggerBinder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Level getDefaultLevel() {
        return Level.INFO;
    }

    public Logger getLogger(String str) {
        return LoggerFactory.getLogger(str);
    }

    public Logger getLogger(String str, String str2) {
        return LoggerFactory.getLogger(str, str2);
    }

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final LoggerBinder INSTANCE = new LoggerBinder();

        private SingletonHolder() {
        }
    }
}
