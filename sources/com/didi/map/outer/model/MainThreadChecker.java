package com.didi.map.outer.model;

import com.didi.map.MapOmegaUtil;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.utils.SystemUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class MainThreadChecker {
    public static final String MAP_SDK = "map_sdk";
    public static final String NAV_SDK = "nav_sdk";

    /* renamed from: a */
    private static final String f27940a = "hawaii_operation_no_in_ui_thread";

    /* renamed from: b */
    private static boolean f27941b = ApolloHawaii.isReportUIThreadCheck();

    /* renamed from: c */
    private static NotMainThreadHandler f27942c = null;

    /* renamed from: d */
    private static final NotMainThreadHandler f27943d;

    public interface NotMainThreadHandler {
        void onNotInMainThread(String str, StackTraceElement[] stackTraceElementArr);
    }

    static {
        C99171 r0 = new NotMainThreadHandler() {
            public void onNotInMainThread(String str, StackTraceElement[] stackTraceElementArr) {
                HashMap hashMap = new HashMap();
                hashMap.put("sdk", str);
                hashMap.put("stackTrace", Arrays.toString(stackTraceElementArr));
                MapOmegaUtil.trackEvent(MainThreadChecker.f27940a, (Map<String, Object>) hashMap);
            }
        };
        f27943d = r0;
        setNotMainThreadHandler(r0);
    }

    private MainThreadChecker() {
    }

    public static void checkMainThread(String str) {
        NotMainThreadHandler notMainThreadHandler;
        if (f27941b && !SystemUtil.isUIThread() && (notMainThreadHandler = f27942c) != null) {
            notMainThreadHandler.onNotInMainThread(str, Thread.currentThread().getStackTrace());
        }
    }

    public static void setNotMainThreadHandler(NotMainThreadHandler notMainThreadHandler) {
        f27942c = notMainThreadHandler;
    }
}
