package com.didi.component.estimate.model;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/component/estimate/model/EstimateState;", "", "()V", "isInOneCarPage", "", "()Z", "setInOneCarPage", "(Z)V", "comp-estimate_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EstimateState.kt */
public final class EstimateState {
    public static final EstimateState INSTANCE = new EstimateState();

    /* renamed from: a */
    private static boolean f13029a;

    private EstimateState() {
    }

    public final boolean isInOneCarPage() {
        return f13029a;
    }

    public final void setInOneCarPage(boolean z) {
        f13029a = z;
    }
}
