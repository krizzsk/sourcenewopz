package com.didi.payment.base.tracker;

import java.util.Map;

public interface IPayTracker {
    ErrorEvent createErrorEvent(String str, String str2, String str3);

    Event createEvent(String str);

    void putGlobal(String str, Object obj);

    void putWalletGlobal(String str, Object obj);

    void removeGlobal(String str);

    void removeWalletGlobal(String str);

    void trackEvent(String str);

    void trackEvent(String str, Map<String, Object> map);

    void trackEventWithWalletGlobal(String str, Map<String, Object> map);
}
