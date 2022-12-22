package com.didiglobal.xpanelnew.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class XpUtils {

    /* renamed from: a */
    private static long f51629a;

    /* renamed from: b */
    private static SimpleDateFormat f51630b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: a */
    private static int m36936a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Activity activity) {
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Rect rect = new Rect();
        try {
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return rect.bottom;
    }

    public static boolean isNavigationBarExist(Activity activity) {
        Rect rect = new Rect();
        try {
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            int i = rect.top;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            if (height == displayMetrics.heightPixels - i) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getNavigationBarHeight(android.content.Context r3) {
        /*
            boolean r0 = hasNavBar(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.util.XpUtils.getNavigationBarHeight(android.content.Context):int");
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String a = m36937a();
        if ("1".equals(a)) {
            return false;
        }
        if ("0".equals(a)) {
            return true;
        }
        return z;
    }

    /* renamed from: a */
    private static String m36937a() {
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

    public static String formatDate(Date date) {
        return f51630b.format(date);
    }

    public static int getVisibility(String str) {
        return TextUtils.isEmpty(str) ? 8 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        return obj2 == null;
    }

    public static boolean isDebug(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null || (applicationInfo = context.getApplicationContext().getApplicationInfo()) == null || (applicationInfo.flags & 2) == 0) {
            return false;
        }
        return true;
    }
}
