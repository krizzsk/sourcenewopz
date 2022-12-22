package com.didichuxing.swarm.toolkit;

public interface LogService {
    void debug(String str, String str2);

    void debug(String str, String str2, Throwable th);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    void info(String str, String str2);

    void info(String str, String str2, Throwable th);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isVerboseEnabled();

    boolean isWarnEnabled();

    void verbose(String str, String str2);

    void verbose(String str, String str2, Throwable th);

    void warn(String str, String str2);

    void warn(String str, String str2, Throwable th);
}
