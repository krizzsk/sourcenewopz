package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.sdk.apm.SystemUtils;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IDiff;
import com.pay99.diff_base.base.IToastDiff;
import com.taxis99.R;

public class WalletToastNew {

    /* renamed from: a */
    private static Toast f30262a;

    /* renamed from: b */
    private static TextView f30263b;

    /* renamed from: c */
    private static ImageView f30264c;

    /* renamed from: d */
    private static Context f30265d = ApplicationContextProvider.Companion.getContext();

    /* renamed from: a */
    private static void m21158a() {
        f30262a = new Toast(f30265d);
        IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_TOAST);
        if (diffValue instanceof IToastDiff) {
            f30262a = ((IToastDiff) diffValue).configToast(f30265d, f30262a);
        }
        Toast toast = f30262a;
        if (toast != null && toast.getView() != null) {
            f30263b = (TextView) f30262a.getView().findViewById(R.id.toast_msg_tv);
            f30264c = (ImageView) f30262a.getView().findViewById(R.id.toast_icon_iv);
        }
    }

    public static void showSuccessMsg(Context context, String str) {
        TextView textView;
        if (f30262a == null) {
            m21158a();
        }
        if (f30264c != null && (textView = f30263b) != null) {
            textView.setText(str);
            if (f30264c.getVisibility() != 0) {
                f30264c.setVisibility(0);
            }
            f30264c.setImageResource(R.drawable.wallet_toast_icon_successful);
            f30262a.setDuration(0);
            SystemUtils.showToast(f30262a);
        }
    }

    public static void showFailedMsg(Context context, String str) {
        TextView textView;
        if (f30262a == null) {
            m21158a();
        }
        if (f30264c != null && (textView = f30263b) != null) {
            textView.setText(str);
            if (f30264c.getVisibility() != 0) {
                f30264c.setVisibility(0);
            }
            f30264c.setImageResource(R.drawable.wallet_toast_icon_fail);
            f30262a.setDuration(0);
            SystemUtils.showToast(f30262a);
        }
    }

    public static void showMsg(Context context, String str) {
        TextView textView;
        if (f30262a == null) {
            m21158a();
        }
        if (f30264c != null && (textView = f30263b) != null) {
            textView.setText(str);
            f30264c.setImageBitmap((Bitmap) null);
            f30264c.setVisibility(8);
            f30262a.setDuration(0);
            SystemUtils.showToast(f30262a);
        }
    }

    public static void cancel() {
        Toast toast = f30262a;
        if (toast != null) {
            toast.cancel();
        }
    }
}
