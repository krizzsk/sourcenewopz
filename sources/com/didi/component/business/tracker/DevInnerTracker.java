package com.didi.component.business.tracker;

import com.didi.reactive.tracker.InnerTracker;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;

public class DevInnerTracker implements InnerTracker {

    /* renamed from: a */
    private static String f11367a = "DevTracker";

    public void track(String str, Map map) {
        String str2 = f11367a;
        SystemUtils.log(4, str2, String.format("%s:\u001b[33m %-30s \u001b[0m attrs: %s", new Object[]{getName(), str, "" + map}), (Throwable) null, "com.didi.component.business.tracker.DevInnerTracker", 13);
    }

    public String getName() {
        return f11367a;
    }
}
