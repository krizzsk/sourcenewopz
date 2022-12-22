package com.didi.dimina.container.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public class ViewUtil {

    /* renamed from: a */
    private static long f17973a;

    public static boolean isFastDoubleInvoke(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = f17973a;
        long j3 = currentTimeMillis - j2;
        if (j2 > 0 && j3 < j) {
            return true;
        }
        f17973a = currentTimeMillis;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getNavigationBarHeight(android.content.Context r3) {
        /*
            boolean r0 = m13439a(r3)
            if (r0 == 0) goto L_0x001b
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r0 = "navigation_bar_height"
            java.lang.String r1 = "dimen"
            java.lang.String r2 = "android"
            int r0 = r3.getIdentifier(r0, r1, r2)
            if (r0 <= 0) goto L_0x001b
            int r3 = r3.getDimensionPixelSize(r0)
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.ViewUtil.getNavigationBarHeight(android.content.Context):int");
    }

    /* renamed from: a */
    private static boolean m13439a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String a = m13438a();
        if ("1".equals(a)) {
            return false;
        }
        if ("0".equals(a)) {
            return true;
        }
        return z;
    }

    /* renamed from: a */
    private static String m13438a() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Throwable unused) {
            return null;
        }
    }
}
