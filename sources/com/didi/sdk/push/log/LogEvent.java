package com.didi.sdk.push.log;

import java.util.Map;

public abstract class LogEvent {

    public interface Builder<T extends LogEvent> {
        T build();
    }

    public abstract Map<String, Object> toMap();
}
