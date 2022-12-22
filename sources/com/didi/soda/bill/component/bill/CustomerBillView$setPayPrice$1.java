package com.didi.soda.bill.component.bill;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "text", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillView.kt */
final class CustomerBillView$setPayPrice$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $oriPrice;
    final /* synthetic */ CustomerBillView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillView$setPayPrice$1(CustomerBillView customerBillView, String str) {
        super(1);
        this.this$0 = customerBillView;
        this.$oriPrice = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        this.this$0.setRightText(str, this.$oriPrice);
    }
}
