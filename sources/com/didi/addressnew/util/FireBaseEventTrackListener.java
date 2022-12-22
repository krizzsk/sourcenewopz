package com.didi.addressnew.util;

import java.util.Map;

public interface FireBaseEventTrackListener {
    void trackEvent(String str, Map<String, Object> map);
}
