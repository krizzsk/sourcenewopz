package com.didi.component.common.util;

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
import com.didi.sdk.apm.SystemUtils;
import java.util.Arrays;

public class UIUtils {

    /* renamed from: a */
    private static Integer f11804a;

    /* renamed from: b */
    private static Integer f11805b;

    /* renamed from: c */
    private static Float f11806c;

    /* renamed from: d */
    private static Integer f11807d;

    public static int getScreenWidth(Context context) {
        Integer num = f11804a;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f11804a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        f11805b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return f11804a.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = f11805b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f11804a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f11805b = valueOf;
        return valueOf.intValue();
    }

    /* renamed from: a */
    private static float m7998a(Context context) {
        if (f11806c == null) {
            f11806c = Float.valueOf(context.getResources().getDisplayMetrics().density);
        }
        return f11806c.floatValue();
    }

    public static float dip2px(Context context, float f) {
        return f * m7998a(context);
    }

    public static int dip2pxInt(Context context, float f) {
        return (int) (((double) (f * m7998a(context))) + 0.5d);
    }

    public static int getStatusbarHeight(Context context) {
        Integer num = f11807d;
        if (num != null) {
            return num.intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            Integer valueOf = Integer.valueOf(dip2pxInt(context, 25.0f));
            f11807d = valueOf;
            return valueOf.intValue();
        }
        try {
            Integer valueOf2 = Integer.valueOf(resources.getDimensionPixelSize(identifier));
            f11807d = valueOf2;
            return valueOf2.intValue();
        } catch (Resources.NotFoundException unused) {
            Integer valueOf3 = Integer.valueOf(dip2pxInt(context, 25.0f));
            f11807d = valueOf3;
            return valueOf3.intValue();
        }
    }

    public static void dumpViewHierarchy(String str, View view) {
        if (view != null && !TextUtils.isEmpty(str)) {
            SystemUtils.log(4, str, "invoke stack trace", new Throwable(), "com.didi.component.common.util.UIUtils", 129);
            m7999a(str, view, new StringBuilder(), new int[2]);
        }
    }

    /* renamed from: a */
    private static void m7999a(String str, View view, StringBuilder sb, int[] iArr) {
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
        SystemUtils.log(4, str, sb.toString(), (Throwable) null, "com.didi.component.common.util.UIUtils", 161);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m7999a(str, viewGroup.getChildAt(i), sb, iArr);
            }
        }
    }

    public static void setEditTextHint(EditText editText, String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }
}
