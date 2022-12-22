package com.didi.addressnew.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.text.TextUtilsCompat;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Method;
import java.util.Locale;

public class ViewUtils {

    /* renamed from: a */
    private static final String f7480a = "ViewUtils";

    /* renamed from: b */
    private static Toast f7481b;

    public static void showToast(Context context, String str) {
        Toast toast = f7481b;
        if (toast == null) {
            f7481b = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        SystemUtils.showToast(f7481b);
    }

    public static void hideInputMethodForEditText(Context context, final EditText editText) {
        if (editText != null) {
            final int inputType = editText.getInputType();
            editText.setInputType(0);
            hideInputWindow(context, editText);
            editText.postDelayed(new Runnable() {
                public void run() {
                    editText.setInputType(inputType);
                }
            }, 500);
        }
    }

    public static void showInputMethodForEditText(Context context, EditText editText, boolean z) {
        if (context != null && editText != null) {
            editText.setCursorVisible(true);
            if (z) {
                editText.requestFocus();
            }
            SystemUtils.log(6, f7480a, "showInputMethodForEditText(), requestFocus: " + z + " editTextFocus: " + editText.isFocused(), (Throwable) null, "com.didi.addressnew.util.ViewUtils", 80);
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 0);
            }
        }
    }

    public static void showInputMethodForEditText(Context context, EditText editText) {
        showInputMethodForEditText(context, editText, true);
    }

    public static void hideInputWindow(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context != null && view != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f / context.getResources().getDisplayMetrics().density);
    }

    public static boolean isBigScreen(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels > 640 && displayMetrics.heightPixels > 960;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r5.getResources().getIdentifier("status_bar_height", "dimen", "android");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getStatusBarHeight(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x001c
            android.content.res.Resources r1 = r5.getResources()
            java.lang.String r2 = "status_bar_height"
            java.lang.String r3 = "dimen"
            java.lang.String r4 = "android"
            int r1 = r1.getIdentifier(r2, r3, r4)
            if (r1 <= 0) goto L_0x001c
            android.content.res.Resources r5 = r5.getResources()
            int r5 = r5.getDimensionPixelSize(r1)
            goto L_0x001d
        L_0x001c:
            r5 = 0
        L_0x001d:
            int r5 = java.lang.Math.max(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.util.ViewUtils.getStatusBarHeight(android.content.Context):int");
    }

    public static int getNavigationBarHeight(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            Resources resources = activity.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
            int i = point2.y - point.y;
            if (i > dimensionPixelSize - 10) {
                return i;
            }
            if (dimensionPixelSize > 0) {
                return dimensionPixelSize;
            }
            return 0;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources2 = activity.getResources();
        return resources2.getDimensionPixelSize(resources2.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r0.equalsIgnoreCase("OPPO") != false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNavigationBarShow(android.content.Context r5) {
        /*
            boolean r0 = m4733a(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0045
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r0 < r2) goto L_0x0045
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r2 = "HUAWEI"
            boolean r2 = r0.equalsIgnoreCase(r2)
            java.lang.String r3 = "navigation_gesture_on"
            java.lang.String r4 = "navigationbar_is_min"
            if (r2 == 0) goto L_0x001d
        L_0x001b:
            r3 = r4
            goto L_0x0039
        L_0x001d:
            java.lang.String r2 = "XIAOMI"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0028
            java.lang.String r3 = "force_fsg_nav_bar"
            goto L_0x0039
        L_0x0028:
            java.lang.String r2 = "VIVO"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0031
            goto L_0x0039
        L_0x0031:
            java.lang.String r2 = "OPPO"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x001b
        L_0x0039:
            android.content.ContentResolver r5 = r5.getContentResolver()
            int r5 = android.provider.Settings.Global.getInt(r5, r3, r1)
            if (r5 != 0) goto L_0x0045
            r5 = 1
            return r5
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.util.ViewUtils.isNavigationBarShow(android.content.Context):boolean");
    }

    /* renamed from: a */
    private static boolean m4733a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String a = m4732a();
        if ("1".equals(a)) {
            return false;
        }
        if ("0".equals(a)) {
            return true;
        }
        return z;
    }

    /* renamed from: a */
    private static String m4732a() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static DisplayMetrics getDisplayMetrics(View view) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(view == null || view.getContext() == null || (windowManager = (WindowManager) view.getContext().getSystemService("window")) == null)) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }
}
