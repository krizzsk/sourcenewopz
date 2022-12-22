package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.a */
/* compiled from: BaseRequest */
abstract class C20709a implements PermissionRequest {

    /* renamed from: a */
    private Source f56205a;

    /* renamed from: b */
    private Rationale<Void> f56206b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f56207c;

    /* renamed from: d */
    private Action<Void> f56208d;

    C20709a(Source source) {
        this.f56205a = source;
    }

    public final PermissionRequest rationale(Rationale<Void> rationale) {
        this.f56206b = rationale;
        return this;
    }

    public final PermissionRequest onGranted(Action<Void> action) {
        this.f56207c = action;
        return this;
    }

    public final PermissionRequest onDenied(Action<Void> action) {
        this.f56208d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169088a(RequestExecutor requestExecutor) {
        this.f56206b.showRationale(this.f56205a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169087a() {
        Action<Void> action = this.f56207c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo169089b() {
        Action<Void> action = this.f56208d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
