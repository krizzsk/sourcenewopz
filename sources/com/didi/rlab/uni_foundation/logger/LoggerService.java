package com.didi.rlab.uni_foundation.logger;

public interface LoggerService {
    void debug(String str, String str2, String str3);

    void error(String str, String str2, String str3);

    void info(String str, String str2, String str3);

    void warn(String str, String str2, String str3);
}
