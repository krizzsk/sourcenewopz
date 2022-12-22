package com.didi.trace.annotations;

import java.util.Map;

public interface Traceable {
    Map<String, Object> getTraceableAttributes();
}
