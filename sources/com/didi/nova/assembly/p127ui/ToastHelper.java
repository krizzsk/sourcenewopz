package com.didi.nova.assembly.p127ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.nova.assembly.ui.ToastHelper */
public class ToastHelper {

    /* renamed from: a */
    private static Toast f29223a;

    /* renamed from: a */
    private static Toast m20614a(Context context, String str, int i, int i2) {
        Context applicationContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.nova_assembly_common_toast, (ViewGroup) null);
        if (i != 0) {
            ((ImageView) inflate.findViewById(R.id.iv_icon)).setImageResource(i);
        } else {
            inflate.findViewById(R.id.ll_icon_root).setVisibility(8);
        }
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(str);
        if (f29223a == null) {
            f29223a = new Toast(applicationContext);
        }
        f29223a.setDuration(i2);
        f29223a.setView(inflate);
        f29223a.setGravity(17, 0, 0);
        return f29223a;
    }

    public static void showShortInfo(Context context, String str, int i) {
        SystemUtils.showToast(m20614a(context, str, i, 0));
    }

    public static void showLongInfo(Context context, String str, int i) {
        SystemUtils.showToast(m20614a(context, str, i, 1));
    }
}
