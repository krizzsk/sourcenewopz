package com.didi.aoe.library.logging;

public interface Logger {
    void debug(String str, Object... objArr);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    void info(String str, Object... objArr);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);
}
