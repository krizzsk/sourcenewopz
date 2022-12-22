package com.didi.sdk.global.sign.payselect;

import com.didi.sdk.global.base.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodSelVM.kt */
final class PayMethodSelVM$refreshDataFromLocal$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayMethodSelVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayMethodSelVM$refreshDataFromLocal$1(PayMethodSelVM payMethodSelVM) {
        super(0);
        this.this$0 = payMethodSelVM;
    }

    public final void invoke() {
        this.this$0.getClosePageEvent().setValue(new Event(Unit.INSTANCE));
    }
}
