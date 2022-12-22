package com.didi.ifx.license;

import java.util.Map;

public interface IFXTrackCallback {
    void trackError(String str, Throwable th);

    void trackEvent(String str, Map<String, Object> map);
}
