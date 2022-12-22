package com.didi.sdk.global.sign.payselect;

import com.didi.sdk.global.sign.model.local.PaySelItemData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodSelActivity.kt */
final class PayMethodSelActivity$subscribeUi$6 extends Lambda implements Function1<PaySelItemData, Unit> {
    final /* synthetic */ PayMethodSelActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayMethodSelActivity$subscribeUi$6(PayMethodSelActivity payMethodSelActivity) {
        super(1);
        this.this$0 = payMethodSelActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaySelItemData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "it");
        this.this$0.f36221g.performClick(paySelItemData);
    }
}
