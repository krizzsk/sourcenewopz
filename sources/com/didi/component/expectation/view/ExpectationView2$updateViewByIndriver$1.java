package com.didi.component.expectation.view;

import com.didi.component.business.xpanelnew.IXpCompRefresh;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationView2.kt */
final class ExpectationView2$updateViewByIndriver$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IXpCompRefresh.IXpCompRefreshCb $callback;
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $refresh;
    final /* synthetic */ boolean $small;
    final /* synthetic */ ExpectationView2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpectationView2$updateViewByIndriver$1(ExpectationView2 expectationView2, boolean z, boolean z2, long j, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        super(0);
        this.this$0 = expectationView2;
        this.$small = z;
        this.$refresh = z2;
        this.$duration = j;
        this.$callback = iXpCompRefreshCb;
    }

    public final void invoke() {
        this.this$0.m9428a(this.$small, this.$refresh, this.$duration, this.$callback);
    }
}
