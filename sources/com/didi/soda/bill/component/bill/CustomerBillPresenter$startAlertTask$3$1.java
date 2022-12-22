package com.didi.soda.bill.component.bill;

import android.os.Bundle;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.ComponentModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenter.kt */
final class CustomerBillPresenter$startAlertTask$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ComponentModel $this_apply;
    final /* synthetic */ CustomerBillPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenter$startAlertTask$3$1(CustomerBillPresenter customerBillPresenter, ComponentModel componentModel) {
        super(0);
        this.this$0 = customerBillPresenter;
        this.$this_apply = componentModel;
    }

    public final void invoke() {
        IView logicView = this.this$0.getLogicView();
        Intrinsics.checkNotNullExpressionValue(logicView, "logicView");
        Contract.AbsBillView.autoClickItem$default((Contract.AbsBillView) logicView, this.$this_apply, 1, (Bundle) null, 4, (Object) null);
        this.this$0.f38826A = true;
    }
}
