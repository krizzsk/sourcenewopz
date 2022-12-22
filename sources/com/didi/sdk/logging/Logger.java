package com.didi.sdk.logging;

import java.util.Map;

public interface Logger {
    void debug(String str, Throwable th);

    void debug(String str, Map<?, ?> map);

    void debug(String str, Object... objArr);

    void debugEvent(String str, Map<?, ?> map);

    void debugEvent(String str, Object... objArr);

    void error(String str, Throwable th);

    void error(String str, Map<?, ?> map);

    void error(String str, Object... objArr);

    void errorEvent(String str, Map<?, ?> map);

    void errorEvent(String str, Object... objArr);

    String getName();

    void info(String str, Throwable th);

    void info(String str, Map<?, ?> map);

    void info(String str, Object... objArr);

    void infoEvent(String str, Map<?, ?> map);

    void infoEvent(String str, Object... objArr);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void log(int i, String str, Throwable th, String str2, int i2);

    void println(String str);

    void setName(String str);

    void trace(String str, Throwable th);

    void trace(String str, Map<?, ?> map);

    void trace(String str, Object... objArr);

    void traceEvent(String str, Map<?, ?> map);

    void traceEvent(String str, Object... objArr);

    void warn(String str, Throwable th);

    void warn(String str, Map<?, ?> map);

    void warn(String str, Object... objArr);

    void warnEvent(String str, Map<?, ?> map);

    void warnEvent(String str, Object... objArr);

    void write(byte[] bArr);
}
