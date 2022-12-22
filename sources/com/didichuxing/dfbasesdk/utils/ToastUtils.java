package com.didichuxing.dfbasesdk.utils;

import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;

public class ToastUtils {
    private ToastUtils() {
    }

    public static void toast(int i) {
        toast(ResUtils.getString(i));
    }

    public static void toast(String str) {
        SystemUtils.showToast(Toast.makeText(AppContextHolder.getAppContext(), str, 0));
    }

    public static void toastLong(int i) {
        toastLong(ResUtils.getString(i));
    }

    public static void toastLong(String str) {
        SystemUtils.showToast(Toast.makeText(AppContextHolder.getAppContext(), str, 1));
    }
}
