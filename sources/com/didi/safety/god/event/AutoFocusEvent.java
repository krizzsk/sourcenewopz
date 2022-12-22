package com.didi.safety.god.event;

import java.util.Map;

public class AutoFocusEvent {
    public final Map<String, Object> traceParams;

    public AutoFocusEvent(Map<String, Object> map) {
        this.traceParams = map;
    }
}
