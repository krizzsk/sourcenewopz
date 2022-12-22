package com.didi.travel.psnger;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

public class TravelSDK {
    public static final String ESTIMATE_SERVICE = "estimate";
    public static final String MATCH_INFO_SERVICE = "match_info";
    public static final String ORDER_SERVICE = "order";

    /* renamed from: a */
    private static boolean f44024a;

    /* renamed from: b */
    private static WeakReference<Context> f44025b;

    /* renamed from: c */
    private static ITravelParam f44026c;

    public static void init(Application application, ITravelParam iTravelParam) {
        if (application != null) {
            f44025b = new WeakReference<>(application.getApplicationContext());
            f44026c = iTravelParam;
            AppLifecycleManager.getInstance().mo109675a(application);
            return;
        }
        throw new IllegalArgumentException("context is null!");
    }

    public static Context appContext() {
        WeakReference<Context> weakReference = f44025b;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    public static Object getService(String str) {
        return ServiceRegistry.m31349a(str);
    }

    public static Object getService(String str, String str2) {
        return ServiceRegistry.m31350a(str, str2);
    }

    public static void setDebug(boolean z) {
        f44024a = z;
    }

    public static boolean isDebug() {
        return f44024a;
    }

    public static ITravelParam travelParam() {
        return f44026c;
    }
}
