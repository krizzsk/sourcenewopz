package com.didiglobal.dittoview.impl;

import android.os.SystemClock;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.mvvm.DittoData;
import java.util.Map;

public class DittoEventListenerImpl implements DittoEventListener {
    private static String TAG = "CommonEventListener";
    protected DittoData data;
    private long lastClickTime;
    private long shakeThreshold = 500;

    public DittoEventListenerImpl(DittoData dittoData) {
        this.data = dittoData;
    }

    public boolean handleEvent(String str, String str2, Map<String, Object> map) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastClickTime < this.shakeThreshold) {
            return false;
        }
        this.lastClickTime = uptimeMillis;
        String str3 = TAG;
        SystemUtils.log(3, str3, "handleEvent:" + str + ",data:" + map, (Throwable) null, "com.didiglobal.dittoview.impl.DittoEventListenerImpl", 32);
        if (str2 != null) {
            DRouter.build(str2).start();
        }
        return false;
    }
}
