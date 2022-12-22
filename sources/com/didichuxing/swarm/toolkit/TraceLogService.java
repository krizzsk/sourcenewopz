package com.didichuxing.swarm.toolkit;

import java.util.Map;

public interface TraceLogService {
    void trackEvent(String str);

    void trackEvent(String str, String str2);

    void trackEvent(String str, String str2, Map<String, Object> map);
}
