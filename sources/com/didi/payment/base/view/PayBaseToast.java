package com.didi.payment.base.view;

import android.content.Context;
import com.didi.sdk.util.ToastHelper;

public class PayBaseToast {
    public static void showInfo(Context context, int i) {
        showInfo(context, context.getString(i));
    }

    public static void showInfo(Context context, String str) {
        if (str.length() > 20) {
            ToastHelper.showLongInfo(context, str);
        } else {
            ToastHelper.showShortInfo(context, str);
        }
    }

    public static void showSucc(Context context, int i) {
        showSucc(context, context.getString(i));
    }

    public static void showSucc(Context context, String str) {
        if (str.length() > 20) {
            ToastHelper.showLongCompleted(context, str);
        } else {
            ToastHelper.showShortCompleted(context, str);
        }
    }
}
