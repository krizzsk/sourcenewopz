package com.didi.raven.utils;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceUtils {
    public static final String IMEI = "imei_";

    /* renamed from: a */
    private static final AtomicBoolean f33115a = new AtomicBoolean(false);

    /* renamed from: b */
    private static Context f33116b;

    /* renamed from: c */
    private static String f33117c;

    /* renamed from: d */
    private static CustomIdSupplier f33118d;

    public interface CustomIdSupplier {
        String getCustomId();
    }

    public static void init(Context context) {
        init(context, true);
    }

    public static void init(Context context, boolean z) {
        if (!f33115a.getAndSet(true)) {
            m23328a(context);
            Context applicationContext = context.getApplicationContext();
            f33116b = applicationContext;
            if (applicationContext != null) {
                context = applicationContext;
            }
            f33116b = context;
        }
    }

    public static synchronized void setCustomIdSupplier(CustomIdSupplier customIdSupplier) {
        synchronized (DeviceUtils.class) {
            f33118d = customIdSupplier;
        }
    }

    public static synchronized String getDeviceId() {
        synchronized (DeviceUtils.class) {
            if (!f33115a.get()) {
                return "";
            }
            return "";
        }
    }

    /* renamed from: a */
    private static <T> T m23328a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
