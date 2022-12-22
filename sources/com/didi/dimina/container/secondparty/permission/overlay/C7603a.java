package com.didi.dimina.container.secondparty.permission.overlay;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.secondparty.permission.overlay.a */
/* compiled from: BaseRequest */
abstract class C7603a implements OverlayRequest {

    /* renamed from: a */
    private final Source f17377a;

    /* renamed from: b */
    private Rationale<Void> f17378b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f17379c;

    /* renamed from: d */
    private Action<Void> f17380d;

    C7603a(Source source) {
        this.f17377a = source;
    }

    public final OverlayRequest rationale(Rationale<Void> rationale) {
        this.f17378b = rationale;
        return this;
    }

    public final OverlayRequest onGranted(Action<Void> action) {
        this.f17379c = action;
        return this;
    }

    public final OverlayRequest onDenied(Action<Void> action) {
        this.f17380d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55931a(RequestExecutor requestExecutor) {
        this.f17378b.showRationale(this.f17377a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55930a() {
        Action<Void> action = this.f17379c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo55932b() {
        Action<Void> action = this.f17380d;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* renamed from: a */
    static boolean m12911a(Context context) {
        Dialog dialog = new Dialog(context, R.style.DiminaPermissionDialogTransparent);
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
