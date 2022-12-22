package com.didi.reactive.tracker;

import java.util.Map;

public interface InnerTracker {
    String getName();

    void track(String str, Map map);
}
