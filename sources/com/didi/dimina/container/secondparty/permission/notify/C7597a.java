package com.didi.dimina.container.secondparty.permission.notify;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.a */
/* compiled from: BaseRequest */
abstract class C7597a implements PermissionRequest {

    /* renamed from: a */
    private final Source f17366a;

    /* renamed from: b */
    private Rationale<Void> f17367b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f17368c;

    /* renamed from: d */
    private Action<Void> f17369d;

    C7597a(Source source) {
        this.f17366a = source;
    }

    public final PermissionRequest rationale(Rationale<Void> rationale) {
        this.f17367b = rationale;
        return this;
    }

    public final PermissionRequest onGranted(Action<Void> action) {
        this.f17368c = action;
        return this;
    }

    public final PermissionRequest onDenied(Action<Void> action) {
        this.f17369d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55915a(RequestExecutor requestExecutor) {
        this.f17367b.showRationale(this.f17366a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55914a() {
        Action<Void> action = this.f17368c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo55916b() {
        Action<Void> action = this.f17369d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
