package com.didi.dimina.container.secondparty.permission.setting.write;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.setting.write.a */
/* compiled from: BaseRequest */
abstract class C7608a implements WriteRequest {

    /* renamed from: a */
    private final Source f17409a;

    /* renamed from: b */
    private Rationale<Void> f17410b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f17411c;

    /* renamed from: d */
    private Action<Void> f17412d;

    C7608a(Source source) {
        this.f17409a = source;
    }

    public final WriteRequest rationale(Rationale<Void> rationale) {
        this.f17410b = rationale;
        return this;
    }

    public final WriteRequest onGranted(Action<Void> action) {
        this.f17411c = action;
        return this;
    }

    public final WriteRequest onDenied(Action<Void> action) {
        this.f17412d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55963a(RequestExecutor requestExecutor) {
        this.f17410b.showRationale(this.f17409a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo55962a() {
        Action<Void> action = this.f17411c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo55964b() {
        Action<Void> action = this.f17412d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
