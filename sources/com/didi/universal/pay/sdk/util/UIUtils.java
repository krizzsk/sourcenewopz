package com.didi.universal.pay.sdk.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import java.util.Arrays;

public class UIUtils {
    private static Float sDensity;
    private static Integer sScreenHeight;
    private static Integer sScreenWidth;
    private static Integer sStatusBarHeight;

    public static int getScreenWidth(Context context) {
        Integer num = sScreenWidth;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        sScreenWidth = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        sScreenHeight = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return sScreenWidth.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = sScreenHeight;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        sScreenWidth = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        sScreenHeight = valueOf;
        return valueOf.intValue();
    }

    private static float getDensity(Context context) {
        if (sDensity == null) {
            sDensity = Float.valueOf(context.getResources().getDisplayMetrics().density);
        }
        return sDensity.floatValue();
    }

    public static float dip2px(Context context, float f) {
        return f * getDensity(context);
    }

    public static int dip2pxInt(Context context, float f) {
        return (int) (((double) (f * getDensity(context))) + 0.5d);
    }

    public static int getStatusbarHeight(Context context) {
        Integer num = sStatusBarHeight;
        if (num != null) {
            return num.intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            Integer valueOf = Integer.valueOf(dip2pxInt(context, 25.0f));
            sStatusBarHeight = valueOf;
            return valueOf.intValue();
        }
        try {
            Integer valueOf2 = Integer.valueOf(resources.getDimensionPixelSize(identifier));
            sStatusBarHeight = valueOf2;
            return valueOf2.intValue();
        } catch (Resources.NotFoundException unused) {
            Integer valueOf3 = Integer.valueOf(dip2pxInt(context, 25.0f));
            sStatusBarHeight = valueOf3;
            return valueOf3.intValue();
        }
    }

    public static void dumpViewHierarchy(String str, View view) {
        if (view != null && !TextUtils.isEmpty(str)) {
            dumpViewHierarchyImpl(str, view, new StringBuilder(), new int[2]);
        }
    }

    private static void dumpViewHierarchyImpl(String str, View view, StringBuilder sb, int[] iArr) {
        sb.setLength(0);
        sb.append("view: ");
        sb.append(view);
        sb.append("\n");
        view.getLocationOnScreen(iArr);
        sb.append(", location on screen");
        sb.append(Arrays.toString(iArr));
        view.getLocationInWindow(iArr);
        sb.append(", location in window ");
        sb.append(Arrays.toString(iArr));
        sb.append(", visible: ");
        sb.append(view.getVisibility() == 0);
        sb.append(", visibility");
        sb.append(view.getVisibility());
        sb.append(", alpha: ");
        sb.append(view.getAlpha());
        sb.append(", translationX");
        sb.append(view.getTranslationX());
        sb.append(", translationY");
        sb.append(view.getTranslationY());
        sb.append(", scaleX");
        sb.append(view.getScaleX());
        sb.append(", scaleY");
        sb.append(view.getScaleY());
        sb.append(", width");
        sb.append(view.getWidth());
        sb.append(", height");
        sb.append(view.getHeight());
        sb.append("\n");
        LogUtil.m32408d(str, sb.toString());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                dumpViewHierarchyImpl(str, viewGroup.getChildAt(i), sb, iArr);
            }
        }
    }

    public static void setEditTextHint(EditText editText, String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }
}
