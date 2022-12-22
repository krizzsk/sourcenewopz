package com.didi.dimina.container.secondparty.permission.notify.listener;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.listener.a */
/* compiled from: BaseRequest */
abstract class C7600a implements ListenerRequest {

    /* renamed from: a */
    private final Source f17372a;

    /* renamed from: b */
    private Rationale<Void> f17373b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f17374c;

    /* renamed from: d */
    private Action<Void> f17375d;

    C7600a(Source source) {
        this.f17372a = source;
    }

    public final ListenerRequest rationale(Rationale<Void> rationale) {
        this.f17373b = rationale;
        return this;
    }

    public final ListenerRequest onGranted(Action<Void> action) {
        this.f17374c = action;
        return this;
    }

    public final ListenerRequest onDenied(Action<Void> action) {
        this.f17375d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55923a(RequestExecutor requestExecutor) {
        this.f17373b.showRationale(this.f17372a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55922a() {
        Action<Void> action = this.f17374c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo55924b() {
        Action<Void> action = this.f17375d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
