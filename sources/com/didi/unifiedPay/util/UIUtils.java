package com.didi.unifiedPay.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import java.util.Arrays;

public class UIUtils {

    /* renamed from: a */
    private static Integer f44606a;

    /* renamed from: b */
    private static Integer f44607b;

    /* renamed from: c */
    private static Integer f44608c;

    public static int getScreenWidth(Context context) {
        Integer num = f44606a;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f44606a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        f44607b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return f44606a.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = f44607b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f44606a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f44607b = valueOf;
        return valueOf.intValue();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dip2pxInt(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        Integer num = f44608c;
        if (num != null) {
            return num.intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            Integer valueOf = Integer.valueOf(dip2pxInt(context, 25.0f));
            f44608c = valueOf;
            return valueOf.intValue();
        }
        try {
            Integer valueOf2 = Integer.valueOf(resources.getDimensionPixelSize(identifier));
            f44608c = valueOf2;
            return valueOf2.intValue();
        } catch (Resources.NotFoundException unused) {
            Integer valueOf3 = Integer.valueOf(px2dip(context, 25.0f));
            f44608c = valueOf3;
            return valueOf3.intValue();
        }
    }

    public static void dumpViewHierarchy(String str, View view) {
        if (view != null && !TextUtils.isEmpty(str)) {
            m31699a(str, view, new StringBuilder(), new int[2]);
        }
    }

    /* renamed from: a */
    private static void m31699a(String str, View view, StringBuilder sb, int[] iArr) {
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
        LogUtil.m31684d(str, sb.toString());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m31699a(str, viewGroup.getChildAt(i), sb, iArr);
            }
        }
    }

    public static void setEditTextHint(EditText editText, String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        return android.graphics.Color.parseColor(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return android.graphics.Color.parseColor("#ffffff");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getColor(java.lang.String r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "#"
            boolean r1 = r2.startsWith(r0)     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x0009
            goto L_0x0018
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001d }
            r1.<init>()     // Catch:{ Exception -> 0x001d }
            r1.append(r0)     // Catch:{ Exception -> 0x001d }
            r1.append(r2)     // Catch:{ Exception -> 0x001d }
            java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x001d }
        L_0x0018:
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ Exception -> 0x001d }
            return r2
        L_0x001d:
            int r2 = android.graphics.Color.parseColor(r3)     // Catch:{ Exception -> 0x0022 }
            return r2
        L_0x0022:
            java.lang.String r2 = "#ffffff"
            int r2 = android.graphics.Color.parseColor(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.util.UIUtils.getColor(java.lang.String, java.lang.String):int");
    }

    public static int getColor(String str) {
        return getColor(str, "#ffffff");
    }

    public static void setTouchDelegate(final View view, final int i) {
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                View.this.getHitRect(rect);
                rect.top -= i;
                rect.bottom += i;
                rect.left -= i;
                rect.right += i;
                view2.setTouchDelegate(new TouchDelegate(rect, View.this));
            }
        });
    }
}
