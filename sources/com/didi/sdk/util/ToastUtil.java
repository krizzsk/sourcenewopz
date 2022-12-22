package com.didi.sdk.util;

import android.content.Context;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;

public class ToastUtil {
    public static void show(Context context, int i) {
        show(context, context.getResources().getText(i), 0);
    }

    public static void show(Context context, int i, int i2) {
        show(context, context.getResources().getText(i), i2);
    }

    public static void show(Context context, CharSequence charSequence) {
        show(context, charSequence, 0);
    }

    public static void show(Context context, CharSequence charSequence, int i) {
        SystemUtils.showToast(Toast.makeText(context, charSequence, i));
    }

    public static void show(Context context, int i, Object... objArr) {
        show(context, (CharSequence) String.format(context.getResources().getString(i), objArr), 0);
    }

    public static void show(Context context, String str, Object... objArr) {
        show(context, (CharSequence) String.format(str, objArr), 0);
    }

    public static void show(Context context, int i, int i2, Object... objArr) {
        show(context, (CharSequence) String.format(context.getResources().getString(i), objArr), i2);
    }

    public static void show(Context context, String str, int i, Object... objArr) {
        show(context, (CharSequence) String.format(str, objArr), i);
    }
}
