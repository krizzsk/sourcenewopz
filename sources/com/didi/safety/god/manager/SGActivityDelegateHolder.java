package com.didi.safety.god.manager;

public class SGActivityDelegateHolder {

    /* renamed from: a */
    private static volatile SafetyGodActivityDelegate f34599a;

    public static void setActivityDelegate(SafetyGodActivityDelegate safetyGodActivityDelegate) {
        f34599a = safetyGodActivityDelegate;
    }

    public static SafetyGodActivityDelegate getActivityDelegate() {
        return f34599a;
    }
}
