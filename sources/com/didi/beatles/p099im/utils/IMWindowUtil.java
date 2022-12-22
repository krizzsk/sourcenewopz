package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.utils.IMWindowUtil */
public class IMWindowUtil {

    /* renamed from: a */
    private static final int f9798a = 24;

    /* renamed from: b */
    private static int f9799b = 0;

    /* renamed from: c */
    private static int f9800c = 0;

    /* renamed from: d */
    private static float f9801d = 1.0f;

    /* renamed from: e */
    private static int f9802e = 0;

    /* renamed from: f */
    private static boolean f9803f = false;

    /* renamed from: a */
    private static void m6650a() {
        WindowManager windowManager;
        if (!f9803f && IMContextInfoHelper.getContext() != null) {
            f9803f = true;
            if (Build.VERSION.SDK_INT < 17 || (windowManager = (WindowManager) IMContextInfoHelper.getContext().getSystemService("window")) == null) {
                DisplayMetrics displayMetrics = IMContextInfoHelper.getContext().getResources().getDisplayMetrics();
                f9799b = displayMetrics.widthPixels;
                f9800c = displayMetrics.heightPixels;
                f9801d = displayMetrics.density;
                return;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics2);
            f9799b = displayMetrics2.widthPixels;
            f9800c = displayMetrics2.heightPixels;
            f9801d = displayMetrics2.density;
        }
    }

    public static int px2dip(float f) {
        m6650a();
        return (int) ((f / f9801d) + 0.5f);
    }

    public static int dip2px(float f) {
        m6650a();
        return (int) ((f * f9801d) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / IMContextInfoHelper.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * IMContextInfoHelper.getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int getScreenWidth() {
        m6650a();
        return f9799b;
    }

    public static int getScreenHeight() {
        m6650a();
        return f9800c;
    }

    public static float getScale() {
        m6650a();
        return f9801d;
    }

    public static int getStatusBarHeight() {
        int i = f9802e;
        if (i != 0) {
            return i;
        }
        Context context = IMCommonContextInfoHelper.getContext();
        boolean z = false;
        if (context == null) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            f9802e = context.getResources().getDimensionPixelSize(IMParseUtil.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            z = true;
        }
        if (z || f9802e <= 0) {
            f9802e = IMViewUtil.dp2px(context, 24.0f);
        }
        return f9802e;
    }
}
