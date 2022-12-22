package com.didi.aoe.library.logging;

import com.didi.aoe.library.logging.impl.AoeLoggerImpl;

public final class LoggerFactory {

    /* renamed from: a */
    private static LoggerBinder f8209a;

    private LoggerFactory() {
    }

    public static Logger getLogger(String str) {
        LoggerBinder loggerBinder = f8209a;
        Logger logger = loggerBinder != null ? loggerBinder.getLogger(str) : null;
        if (logger != null) {
            return logger;
        }
        return m5327a(str);
    }

    /* renamed from: a */
    private static Logger m5327a(String str) {
        C36111 r0 = new LoggerBinder() {
            public Logger getLogger(String str) {
                return new AoeLoggerImpl(str);
            }
        };
        f8209a = r0;
        return r0.getLogger(str);
    }

    public static void setLoggerBinder(LoggerBinder loggerBinder) {
        f8209a = loggerBinder;
    }
}
