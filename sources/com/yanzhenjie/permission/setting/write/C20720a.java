package com.yanzhenjie.permission.setting.write;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.setting.write.a */
/* compiled from: BaseRequest */
abstract class C20720a implements WriteRequest {

    /* renamed from: a */
    private Source f56249a;

    /* renamed from: b */
    private Rationale<Void> f56250b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f56251c;

    /* renamed from: d */
    private Action<Void> f56252d;

    C20720a(Source source) {
        this.f56249a = source;
    }

    public final WriteRequest rationale(Rationale<Void> rationale) {
        this.f56250b = rationale;
        return this;
    }

    public final WriteRequest onGranted(Action<Void> action) {
        this.f56251c = action;
        return this;
    }

    public final WriteRequest onDenied(Action<Void> action) {
        this.f56252d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169136a(RequestExecutor requestExecutor) {
        this.f56250b.showRationale(this.f56249a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169135a() {
        Action<Void> action = this.f56251c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo169137b() {
        Action<Void> action = this.f56252d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
