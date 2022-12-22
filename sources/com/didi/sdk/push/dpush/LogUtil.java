package com.didi.sdk.push.dpush;

import com.didi.sdk.tpush.ILogCallbackListener;

public class LogUtil {
    public static ILogCallbackListener logCallbackListener;

    /* renamed from: d */
    public static void m26294d(String str, String str2) {
    }

    /* renamed from: d */
    public static void m26293d(int i, String str) {
        ILogCallbackListener iLogCallbackListener = logCallbackListener;
        if (iLogCallbackListener != null) {
            iLogCallbackListener.onLog(i, str);
        }
    }

    public static void setLogCallbackListener(ILogCallbackListener iLogCallbackListener) {
        logCallbackListener = iLogCallbackListener;
    }
}
