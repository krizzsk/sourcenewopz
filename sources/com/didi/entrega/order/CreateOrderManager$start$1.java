package com.didi.entrega.order;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "focusType", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
final class CreateOrderManager$start$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ CreateOrderManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateOrderManager$start$1(CreateOrderManager createOrderManager) {
        super(1);
        this.this$0 = createOrderManager;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.this$0.onProgressEnd();
    }
}
