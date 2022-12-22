package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ToastUtils */
public class ToastUtils {
    public static void showToast(Context context, String str, int i) {
        Toast toast = new Toast(context.getApplicationContext());
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(str);
        ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(i);
        toast.setView(inflate);
        toast.setDuration(0);
        toast.setGravity(81, 0, UiUtils.dip2px(context, 108.0f));
        SystemUtils.showToast(toast);
    }
}
