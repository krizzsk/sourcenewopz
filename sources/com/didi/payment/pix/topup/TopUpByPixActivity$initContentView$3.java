package com.didi.payment.pix.topup;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "valid", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixActivity.kt */
final class TopUpByPixActivity$initContentView$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TopUpByPixActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopUpByPixActivity$initContentView$3(TopUpByPixActivity topUpByPixActivity) {
        super(1);
        this.this$0 = topUpByPixActivity;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        View access$getBtnTopUp$p = this.this$0.f31212c;
        if (access$getBtnTopUp$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTopUp");
            access$getBtnTopUp$p = null;
        }
        access$getBtnTopUp$p.setEnabled(z);
    }
}
