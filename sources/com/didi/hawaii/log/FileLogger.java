package com.didi.hawaii.log;

public interface FileLogger {
    void close();

    void log(String str);

    void reset();

    void setDebug(boolean z);

    void setPackageName(String str);

    void setPackageRelatedRules(String str);

    void setPath(String str);

    void setPhoneNumber(String str);

    void setRule(String str);
}
