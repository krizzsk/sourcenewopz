package com.didi.addressold.util;

import java.util.Map;

public interface FireBaseEventTrackListener {
    void trackEvent(String str, Map<String, Object> map);
}
