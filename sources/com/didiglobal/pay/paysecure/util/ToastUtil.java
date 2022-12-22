package com.didiglobal.pay.paysecure.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u000bJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/util/ToastUtil;", "", "()V", "sToast", "Landroid/widget/Toast;", "createToast", "context", "Landroid/content/Context;", "msg", "", "imageRes", "", "duration", "showError", "", "showSuccess", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ToastUtil.kt */
public final class ToastUtil {
    public static final ToastUtil INSTANCE = new ToastUtil();

    /* renamed from: a */
    private static Toast f50473a;

    private ToastUtil() {
    }

    public final void showError(Context context, String str) {
        Toast a = m36286a(context, str, R.drawable.ic_toast_failure, 0);
        if (a != null) {
            SystemUtils.showToast(a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showError(android.content.Context r3, int r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x000d
            android.content.res.Resources r0 = r3.getResources()
            if (r0 == 0) goto L_0x000d
            java.lang.String r4 = r0.getString(r4)
            goto L_0x000e
        L_0x000d:
            r4 = 0
        L_0x000e:
            r0 = 2131233732(0x7f080bc4, float:1.808361E38)
            r1 = 0
            android.widget.Toast r3 = r2.m36286a(r3, r4, r0, r1)
            if (r3 == 0) goto L_0x001b
            com.didi.sdk.apm.SystemUtils.showToast(r3)
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.util.ToastUtil.showError(android.content.Context, int):void");
    }

    public final void showSuccess(Context context, String str) {
        Toast a = m36286a(context, str, R.drawable.ic_toast_success, 0);
        if (a != null) {
            SystemUtils.showToast(a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showSuccess(android.content.Context r3, int r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x000d
            android.content.res.Resources r0 = r3.getResources()
            if (r0 == 0) goto L_0x000d
            java.lang.String r4 = r0.getString(r4)
            goto L_0x000e
        L_0x000d:
            r4 = 0
        L_0x000e:
            r0 = 2131233733(0x7f080bc5, float:1.8083612E38)
            r1 = 0
            android.widget.Toast r3 = r2.m36286a(r3, r4, r0, r1)
            if (r3 == 0) goto L_0x001b
            com.didi.sdk.apm.SystemUtils.showToast(r3)
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.util.ToastUtil.showSuccess(android.content.Context, int):void");
    }

    /* renamed from: a */
    private final Toast m36286a(Context context, String str, int i, int i2) {
        if (context == null) {
            return null;
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.toast_pay_secure, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…t.toast_pay_secure, null)");
        View findViewById = inflate.findViewById(R.id.iv_pay_secure_toast);
        if (findViewById != null) {
            ((ImageView) findViewById).setImageResource(i);
            View findViewById2 = inflate.findViewById(R.id.tv_pay_secure_toast);
            if (findViewById2 != null) {
                ((TextView) findViewById2).setText(charSequence);
                Toast toast = new Toast(context);
                toast.setView(inflate);
                toast.setDuration(i2);
                return toast;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
    }
}
