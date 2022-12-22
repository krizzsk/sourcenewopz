package com.didi.sdk.logging.model;

import com.didi.sdk.logging.AbstractLogger;
import com.didi.sdk.logging.Level;

public abstract class AbstractLog {
    protected Level logLevel;
    protected AbstractLogger logger;

    public abstract String getContent();

    public abstract byte[] getData();

    public abstract String getMsg();

    public abstract String getTag();

    public Level getLogLevel() {
        return this.logLevel;
    }
}
