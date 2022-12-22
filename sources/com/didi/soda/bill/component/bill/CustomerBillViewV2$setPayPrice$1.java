package com.didi.soda.bill.component.bill;

import com.didi.soda.bill.widgets.btn.BillPayLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "text", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillViewV2.kt */
final class CustomerBillViewV2$setPayPrice$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $oriPrice;
    final /* synthetic */ CustomerBillViewV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillViewV2$setPayPrice$1(CustomerBillViewV2 customerBillViewV2, String str) {
        super(1);
        this.this$0 = customerBillViewV2;
        this.$oriPrice = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        BillPayLayout access$getPayLayout$p = this.this$0.f38910i;
        if (access$getPayLayout$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payLayout");
            access$getPayLayout$p = null;
        }
        access$getPayLayout$p.setRightText(str, this.$oriPrice);
    }
}
