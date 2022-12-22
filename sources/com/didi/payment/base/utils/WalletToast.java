package com.didi.payment.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletToast {

    /* renamed from: a */
    private static Toast f30028a;

    /* renamed from: b */
    private static TextView f30029b;

    /* renamed from: c */
    private static ImageView f30030c;

    /* renamed from: a */
    private static void m21025a(Context context) {
        f30028a = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_toast_layout, (ViewGroup) null);
        f30029b = (TextView) inflate.findViewById(R.id.toast_msg_tv);
        f30030c = (ImageView) inflate.findViewById(R.id.toast_icon_iv);
        f30028a.setGravity(87, 0, 0);
        f30028a.setView(inflate);
    }

    /* renamed from: b */
    private static void m21026b(Context context) {
        f30028a = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_toast_layout, (ViewGroup) null);
        f30029b = (TextView) inflate.findViewById(R.id.toast_msg_tv);
        f30030c = (ImageView) inflate.findViewById(R.id.toast_icon_iv);
        f30028a.setGravity(55, 0, 0);
        f30028a.setView(inflate);
    }

    public static void showSuccessMsg(Context context, String str) {
        if (f30028a == null) {
            m21026b(context.getApplicationContext());
        }
        f30029b.setText(str);
        f30030c.setImageResource(R.drawable.wallet_toast_icon_successful);
        f30028a.setDuration(0);
        SystemUtils.showToast(f30028a);
    }

    public static void showFailedMsg(Context context, String str) {
        if (f30028a == null) {
            m21026b(context.getApplicationContext());
        }
        f30029b.setText(str);
        f30030c.setImageResource(R.drawable.wallet_toast_icon_fail);
        f30028a.setDuration(0);
        SystemUtils.showToast(f30028a);
    }

    public static void showMsg(Context context, String str) {
        if (f30028a == null) {
            m21026b(context.getApplicationContext());
        }
        f30029b.setText(str);
        f30030c.setImageBitmap((Bitmap) null);
        f30028a.setDuration(0);
        SystemUtils.showToast(f30028a);
    }

    public static void cancel() {
        Toast toast = f30028a;
        if (toast != null) {
            toast.cancel();
        }
    }
}
