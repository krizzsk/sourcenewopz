package com.didi.payment.pix.topup;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixActivity.kt */
final class TopUpByPixActivity$initContentView$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TopUpByPixActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopUpByPixActivity$initContentView$5(TopUpByPixActivity topUpByPixActivity) {
        super(0);
        this.this$0 = topUpByPixActivity;
    }

    public final void invoke() {
        View access$getLlEmpty$p = this.this$0.f31214e;
        if (access$getLlEmpty$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llEmpty");
            access$getLlEmpty$p = null;
        }
        access$getLlEmpty$p.setVisibility(8);
        TopUpByPixActivity.access$getVm(this.this$0).loadData();
    }
}
