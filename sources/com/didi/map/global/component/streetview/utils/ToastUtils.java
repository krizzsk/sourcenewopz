package com.didi.map.global.component.streetview.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ToastUtils {
    public static void showToast(Context context, int i) {
        if (context != null && i != 0) {
            Toast toast = new Toast(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.map_comp_common_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.toast_text)).setText(i);
            toast.setView(inflate);
            toast.setDuration(0);
            SystemUtils.showToast(toast);
        }
    }

    public static void showToast(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Toast toast = new Toast(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.map_comp_common_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
            toast.setView(inflate);
            toast.setDuration(0);
            SystemUtils.showToast(toast);
        }
    }
}
