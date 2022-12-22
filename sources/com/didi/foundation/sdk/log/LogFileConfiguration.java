package com.didi.foundation.sdk.log;

public abstract class LogFileConfiguration {
    public long getTotalFileSize() {
        return 0;
    }

    public abstract boolean isDebug();

    public boolean isFileLogEnabled() {
        return !isDebug();
    }
}
