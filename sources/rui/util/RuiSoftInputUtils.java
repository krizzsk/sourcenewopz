package rui.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class RuiSoftInputUtils {

    /* renamed from: a */
    private static InputMethodManager f6824a;

    public static void showSoftInputForced(EditText editText) {
        if (f6824a == null) {
            f6824a = (InputMethodManager) editText.getContext().getSystemService("input_method");
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        f6824a.showSoftInput(editText, 2);
    }

    public static boolean hideSoftInputForced(Activity activity, View view) {
        if (!isSoftInputVisible(activity)) {
            return false;
        }
        if (f6824a == null) {
            f6824a = (InputMethodManager) activity.getSystemService("input_method");
        }
        view.clearFocus();
        return f6824a.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean hideSoftInput(View view) {
        if (view == null) {
            return false;
        }
        if (f6824a == null) {
            f6824a = (InputMethodManager) view.getContext().getSystemService("input_method");
        }
        return f6824a.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean hideSoftInput(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null) {
            return false;
        }
        if (f6824a == null) {
            f6824a = (InputMethodManager) activity.getSystemService("input_method");
        }
        return f6824a.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static boolean isSoftInputVisible(Activity activity) {
        return isSoftInputVisible(activity, 200);
    }

    public static boolean isSoftInputVisible(Activity activity, int i) {
        return m3857a(activity) >= i;
    }

    public static int getSoftInputHeight(Activity activity) {
        Rect rect = new Rect();
        View decorView = activity.getWindow().getDecorView();
        decorView.getWindowVisibleDisplayFrame(rect);
        return decorView.getHeight() - (rect.bottom - rect.top);
    }

    /* renamed from: a */
    private static int m3857a(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        return findViewById.getRootView().getHeight() - rect.height();
    }
}
