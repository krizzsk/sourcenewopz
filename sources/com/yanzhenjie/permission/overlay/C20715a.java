package com.yanzhenjie.permission.overlay;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.overlay.a */
/* compiled from: BaseRequest */
abstract class C20715a implements OverlayRequest {

    /* renamed from: a */
    private Source f56216a;

    /* renamed from: b */
    private Rationale<Void> f56217b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f56218c;

    /* renamed from: d */
    private Action<Void> f56219d;

    C20715a(Source source) {
        this.f56216a = source;
    }

    public final OverlayRequest rationale(Rationale<Void> rationale) {
        this.f56217b = rationale;
        return this;
    }

    public final OverlayRequest onGranted(Action<Void> action) {
        this.f56218c = action;
        return this;
    }

    public final OverlayRequest onDenied(Action<Void> action) {
        this.f56219d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169104a(RequestExecutor requestExecutor) {
        this.f56217b.showRationale(this.f56216a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169103a() {
        Action<Void> action = this.f56218c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo169105b() {
        Action<Void> action = this.f56219d;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* renamed from: a */
    static boolean m40479a(Context context) {
        Dialog dialog = new Dialog(context, 2132017655);
        dialog.getWindow().setType(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
        try {
            SystemUtils.showDialog(dialog);
            if (!dialog.isShowing()) {
                return true;
            }
            dialog.dismiss();
            return true;
        } catch (Exception unused) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            return false;
        } catch (Throwable th) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            throw th;
        }
    }
}
