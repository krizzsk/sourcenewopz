package com.didi.drouter.utils;

import android.util.Log;
import android.widget.Toast;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.apm.SystemUtils;

public class RouterLogger {
    public static final String NAME = "DRouterCore";

    /* renamed from: a */
    private static IRouterLogger f19272a = new InnerLogger();

    /* renamed from: b */
    private static final RouterLogger f19273b = new RouterLogger(NAME);

    /* renamed from: c */
    private static final RouterLogger f19274c = new RouterLogger("DRouterApp");

    /* renamed from: d */
    private final String f19275d;

    private RouterLogger(String str) {
        this.f19275d = str;
    }

    public static void setLogger(IRouterLogger iRouterLogger) {
        f19272a = iRouterLogger;
    }

    public static RouterLogger getAppLogger() {
        return f19274c;
    }

    public static RouterLogger getCoreLogger() {
        return f19273b;
    }

    /* renamed from: d */
    public void mo59000d(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (str != null && (iRouterLogger = f19272a) != null) {
            iRouterLogger.mo58994d(this.f19275d, m14406b(str, objArr));
        }
    }

    /* renamed from: w */
    public void mo59002w(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (str != null && (iRouterLogger = f19272a) != null) {
            iRouterLogger.mo58996w(this.f19275d, m14406b(str, objArr));
        }
    }

    /* renamed from: e */
    public void mo59001e(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (str != null && (iRouterLogger = f19272a) != null) {
            iRouterLogger.mo58995e(this.f19275d, m14406b(str, objArr));
        }
    }

    public void crash(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (!(str == null || (iRouterLogger = f19272a) == null)) {
            String str2 = this.f19275d;
            iRouterLogger.mo58995e(str2, m14406b(str, objArr) + "\n Exception:" + Log.getStackTraceString(new Throwable()));
        }
        throw new RuntimeException(str);
    }

    public static void toast(final String str, final Object... objArr) {
        RouterExecutor.main(new Runnable() {
            public void run() {
                SystemUtils.showToast(Toast.makeText(DRouter.getContext(), RouterLogger.m14406b(str, objArr), 0));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m14406b(String str, Object... objArr) {
        if (objArr == null) {
            return str;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] instanceof Throwable) {
                objArr[i] = Log.getStackTraceString(objArr[i]);
            }
        }
        return String.format(str, objArr);
    }

    private static class InnerLogger implements IRouterLogger {
        private InnerLogger() {
        }

        /* renamed from: d */
        public void mo58994d(String str, String str2) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.drouter.utils.RouterLogger$InnerLogger", 85);
        }

        /* renamed from: w */
        public void mo58996w(String str, String str2) {
            SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.drouter.utils.RouterLogger$InnerLogger", 90);
        }

        /* renamed from: e */
        public void mo58995e(String str, String str2) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.drouter.utils.RouterLogger$InnerLogger", 95);
        }
    }
}
