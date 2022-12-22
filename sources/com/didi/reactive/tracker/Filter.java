package com.didi.reactive.tracker;

import java.util.Map;

public interface Filter {
    boolean needTrack(EventTracker eventTracker, String str, Map map);
}
