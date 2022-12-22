package com.didi.global.globalgenerickit;

import android.os.SystemClock;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;

public class CommonEventListener implements EventListener {
    private static String TAG = "CommonEventListener";
    protected GGKData data;
    private long lastClickTime;
    private long shakeThreshold = 500;

    public CommonEventListener(GGKData gGKData) {
        this.data = gGKData;
    }

    public boolean handleEvent(String str, String str2, Map<String, Object> map) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastClickTime < this.shakeThreshold) {
            return false;
        }
        this.lastClickTime = uptimeMillis;
        String str3 = TAG;
        SystemUtils.log(3, str3, "handleEvent:" + str + ",data:" + map, (Throwable) null, "com.didi.global.globalgenerickit.CommonEventListener", 30);
        if (str2 != null) {
            DRouter.build(str2).start();
        }
        return false;
    }
}
