package com.didi.soda.bill.component.bill;

import com.didi.soda.bill.component.cpf.CPFCheckVisibleListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenter.kt */
final class CustomerBillPresenter$startAlertTask$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CustomerBillPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenter$startAlertTask$2$1(CustomerBillPresenter customerBillPresenter) {
        super(0);
        this.this$0 = customerBillPresenter;
    }

    public final Unit invoke() {
        CPFCheckVisibleListener access$getCpfVisibleListener$p = this.this$0.f38840l;
        if (access$getCpfVisibleListener$p == null) {
            return null;
        }
        access$getCpfVisibleListener$p.showCPFCheckView();
        return Unit.INSTANCE;
    }
}
