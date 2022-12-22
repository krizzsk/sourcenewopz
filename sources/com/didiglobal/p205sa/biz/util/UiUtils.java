package com.didiglobal.p205sa.biz.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0016J.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\"J\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010$\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\"J\u000e\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\"J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\"J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-J\u0018\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u00100\u001a\u00020\tJ\u001a\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\u0018\u00101\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u000b¨\u00063"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/util/UiUtils;", "", "()V", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "checkDeviceHasNavigationBar1", "dip2px", "", "dpValue", "", "getAppUsableScreenSize", "Landroid/graphics/Point;", "getBackgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "color_start", "", "color_end", "getLocationOnScreen", "", "parent", "Landroid/view/View;", "view", "getNavigationBarHeight", "getNavigationBarSize", "getNotchHeight", "decorView", "getRadiusBgDrawable", "Landroid/graphics/drawable/Drawable;", "defaultColor", "radius", "getRealScreenSize", "getScreenHeight", "Landroid/app/Activity;", "getScreenWidth", "getStatusBarHeight", "getViewLocation", "getWindowHeight", "window", "getWindowWidth", "isNavigationBarShow", "activity", "isOverFlowTextView", "textView", "Landroid/widget/TextView;", "parseColor", "color", "defaultColorInt", "px2dip", "pxValue", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.util.UiUtils */
/* compiled from: UiUtils.kt */
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();

    private UiUtils() {
    }

    public final int getWindowWidth(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int getWindowHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int getScreenHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Object systemService = activity.getSystemService("window");
        if (systemService != null) {
            WindowManager windowManager = (WindowManager) systemService;
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                windowManager.getDefaultDisplay().getSize(point);
            }
            return point.y;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final int getScreenHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            WindowManager windowManager = (WindowManager) systemService;
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                windowManager.getDefaultDisplay().getSize(point);
            }
            return point.y;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final int getScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            WindowManager windowManager = (WindowManager) systemService;
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                windowManager.getDefaultDisplay().getSize(point);
            }
            return point.x;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final int getNotchHeight(View view) {
        Intrinsics.checkNotNullParameter(view, "decorView");
        if (Build.VERSION.SDK_INT < 28 || view.getRootWindowInsets() == null || view.getRootWindowInsets().getDisplayCutout() == null) {
            return 0;
        }
        DisplayCutout displayCutout = view.getRootWindowInsets().getDisplayCutout();
        Intrinsics.checkNotNull(displayCutout);
        return displayCutout.getSafeInsetTop();
    }

    public final int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 60;
    }

    public final int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int px2dip(Context context, float f) {
        return context == null ? (int) f : (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int[] getViewLocation(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    public final boolean isOverFlowTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Layout layout = textView.getLayout();
        if (layout == null || layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
            return false;
        }
        return true;
    }

    public final int[] getLocationOnScreen(View view, View view2) {
        int[] iArr = new int[2];
        if (!(view2 == null || view == null)) {
            view2.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                iArr[0] = rect.left;
                iArr[1] = rect.top;
            }
        }
        return iArr;
    }

    public final int parseColor(String str, int i) {
        try {
            return !TextUtils.isEmpty(str) ? Color.parseColor(str) : i;
        } catch (IllegalArgumentException unused) {
            return i;
        }
    }

    public final int parseColor(String str, String str2) {
        if (str == null) {
            str = str2;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return Color.parseColor(str2);
        }
    }

    public final boolean checkDeviceHasNavigationBar(Context context) {
        return (!ViewConfiguration.get(context).hasPermanentMenuKey()) & (!KeyCharacterMap.deviceHasKey(4));
    }

    public final boolean checkDeviceHasNavigationBar1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", new Class[]{String.class});
            Intrinsics.checkNotNullExpressionValue(method, "systemPropertiesClass.ge…get\", String::class.java)");
            Object invoke = method.invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if (invoke != null) {
                String str = (String) invoke;
                if (Intrinsics.areEqual((Object) "1", (Object) str)) {
                    return false;
                }
                if (Intrinsics.areEqual((Object) "0", (Object) str)) {
                    return true;
                }
                return z;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r4 = r4.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getNavigationBarHeight(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r3.checkDeviceHasNavigationBar1(r4)
            if (r0 == 0) goto L_0x0020
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r0 = "navigation_bar_height"
            java.lang.String r1 = "dimen"
            java.lang.String r2 = "android"
            int r0 = r4.getIdentifier(r0, r1, r2)
            if (r0 <= 0) goto L_0x0020
            int r4 = r4.getDimensionPixelSize(r0)
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.util.UiUtils.getNavigationBarHeight(android.content.Context):int");
    }

    public final Point getNavigationBarSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Point a = m36713a(context);
        Point realScreenSize = getRealScreenSize(context);
        if (a.x < realScreenSize.x) {
            return new Point(realScreenSize.x - a.x, a.y);
        }
        if (a.y < realScreenSize.y) {
            return new Point(a.x, realScreenSize.y - a.y);
        }
        return new Point();
    }

    /* renamed from: a */
    private final Point m36713a(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[ExcHandler: IllegalAccessException | NoSuchMethodException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:15:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Point getRealScreenSize(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Int"
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "window"
            java.lang.Object r7 = r7.getSystemService(r1)
            if (r7 == 0) goto L_0x0072
            android.view.WindowManager r7 = (android.view.WindowManager) r7
            android.view.Display r7 = r7.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x0024
            r7.getRealSize(r1)
            goto L_0x0071
        L_0x0024:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 14
            if (r2 < r3) goto L_0x0071
            r2 = 0
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawWidth"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ InvocationTargetException -> 0x004c }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ InvocationTargetException -> 0x004c }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x004c }
            java.lang.Object r3 = r3.invoke(r7, r4)     // Catch:{ InvocationTargetException -> 0x004c }
            if (r3 == 0) goto L_0x0046
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ InvocationTargetException -> 0x004c }
            int r3 = r3.intValue()     // Catch:{ InvocationTargetException -> 0x004c }
            r1.x = r3     // Catch:{ InvocationTargetException -> 0x004c }
            goto L_0x0050
        L_0x0046:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ InvocationTargetException -> 0x004c }
            r3.<init>(r0)     // Catch:{ InvocationTargetException -> 0x004c }
            throw r3     // Catch:{ InvocationTargetException -> 0x004c }
        L_0x004c:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
        L_0x0050:
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawHeight"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            java.lang.Object r7 = r3.invoke(r7, r2)     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            if (r7 == 0) goto L_0x006b
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            int r7 = r7.intValue()     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            r1.y = r7     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            goto L_0x0071
        L_0x006b:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            r7.<init>(r0)     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
            throw r7     // Catch:{ IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071, IllegalAccessException | NoSuchMethodException -> 0x0071 }
        L_0x0071:
            return r1
        L_0x0072:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.view.WindowManager"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.util.UiUtils.getRealScreenSize(android.content.Context):android.graphics.Point");
    }

    public final boolean isNavigationBarShow(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            int i = point2.y;
            int i2 = point.y;
            if (point2.y != point.y) {
                return true;
            }
        } else {
            boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final GradientDrawable getBackgroundDrawable(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "color_start");
        Intrinsics.checkNotNullParameter(str2, "color_end");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{Color.parseColor(str), Color.parseColor(str2)});
            return gradientDrawable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Drawable getRadiusBgDrawable(Context context, String str, String str2, String str3, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "color_start");
        Intrinsics.checkNotNullParameter(str2, "color_end");
        Intrinsics.checkNotNullParameter(str3, "defaultColor");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) dip2px(context, f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gradientDrawable.setColor(Color.parseColor(str3));
        } else {
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor(str), Color.parseColor(str2)});
                return gradientDrawable;
            } catch (Exception e) {
                e.printStackTrace();
                gradientDrawable.setColor(Color.parseColor(str3));
            }
        }
        return gradientDrawable;
    }
}
