package com.didi.dimina.container.service;

import com.didi.dimina.container.DMMina;
import java.util.Map;

public interface TraceService {
    void trackEvent(DMMina dMMina, String str, Map<String, Object> map);
}
