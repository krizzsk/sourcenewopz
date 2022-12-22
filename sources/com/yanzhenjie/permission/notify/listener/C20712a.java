package com.yanzhenjie.permission.notify.listener;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.listener.a */
/* compiled from: BaseRequest */
abstract class C20712a implements ListenerRequest {

    /* renamed from: a */
    private Source f56211a;

    /* renamed from: b */
    private Rationale<Void> f56212b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f56213c;

    /* renamed from: d */
    private Action<Void> f56214d;

    C20712a(Source source) {
        this.f56211a = source;
    }

    public final ListenerRequest rationale(Rationale<Void> rationale) {
        this.f56212b = rationale;
        return this;
    }

    public final ListenerRequest onGranted(Action<Void> action) {
        this.f56213c = action;
        return this;
    }

    public final ListenerRequest onDenied(Action<Void> action) {
        this.f56214d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169096a(RequestExecutor requestExecutor) {
        this.f56212b.showRationale(this.f56211a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169095a() {
        Action<Void> action = this.f56213c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo169097b() {
        Action<Void> action = this.f56214d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
