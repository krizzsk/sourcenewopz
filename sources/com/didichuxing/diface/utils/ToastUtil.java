package com.didichuxing.diface.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ToastUtil {
    /* renamed from: a */
    private static void m34029a(Context context, String str, int i, int i2) {
        Toast toast = new Toast(context.getApplicationContext());
        View inflate = LayoutInflater.from(context).inflate(R.layout.df_custom_toast_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_toast)).setText(str);
        toast.setView(inflate);
        toast.setDuration(1);
        toast.setGravity(80, 0, 200);
        SystemUtils.showToast(toast);
    }

    public static void showToastInfo(Context context, String str) {
        m34029a(context, str, 0, 0);
    }

    public static void showToastInfo(Context context, int i) {
        m34029a(context, context.getResources().getString(i), 0, 0);
    }
}
