package com.didi.addressold.util;

import android.content.Context;
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
import java.util.Locale;

public class ViewUtils {

    /* renamed from: a */
    private static final String f7791a = "ViewUtils";

    /* renamed from: b */
    private static Toast f7792b;

    public static void showToast(Context context, String str) {
        Toast toast = f7792b;
        if (toast == null) {
            f7792b = Toast.makeText(context, str, 0);
        } else {
            toast.setText(str);
        }
        SystemUtils.showToast(f7792b);
    }

    public static void hideInputMethodForEditText(Context context, final EditText editText) {
        final int inputType = editText.getInputType();
        editText.setInputType(0);
        hideInputWindow(context, editText);
        editText.postDelayed(new Runnable() {
            public void run() {
                editText.setInputType(inputType);
            }
        }, 500);
    }

    public static void showInputMethodForEditText(Context context, EditText editText, boolean z) {
        if (context != null && editText != null) {
            editText.setCursorVisible(true);
            if (z) {
                editText.requestFocus();
            }
            SystemUtils.log(6, f7791a, "showInputMethodForEditText(), requestFocus: " + z + " editTextFocus: " + editText.isFocused(), (Throwable) null, "com.didi.addressold.util.ViewUtils", 72);
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.util.ViewUtils.getStatusBarHeight(android.content.Context):int");
    }

    public static int getNavigationBarHeight(Context context) {
        if (!isNavigationBarShow(context) || context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean isNavigationBarShow(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y != point.y) {
                return true;
            }
            return false;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey() && !KeyCharacterMap.deviceHasKey(4);
    }

    public static int getScreenWidth(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}
