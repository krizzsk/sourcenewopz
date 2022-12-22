package com.didi.global.fintech.cashier.threeds.cvv;

import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCCVBtnViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "length", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVPresenter.kt */
final class GlobalCashierCVVPresenter$bindView$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ GlobalCashierCVVPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierCVVPresenter$bindView$1(GlobalCashierCVVPresenter globalCashierCVVPresenter) {
        super(1);
        this.this$0 = globalCashierCVVPresenter;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        IGlobalCashierCCVBtnViewBinder iGlobalCashierCCVBtnViewBinder;
        Object obj;
        Iterator it = this.this$0.f21666a.iterator();
        while (true) {
            iGlobalCashierCCVBtnViewBinder = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IGlobalCashierCVVBaseViewBinder) obj) instanceof IGlobalCashierCCVBtnViewBinder) {
                break;
            }
        }
        IGlobalCashierCVVBaseViewBinder iGlobalCashierCVVBaseViewBinder = (IGlobalCashierCVVBaseViewBinder) obj;
        if (iGlobalCashierCVVBaseViewBinder instanceof IGlobalCashierCCVBtnViewBinder) {
            iGlobalCashierCCVBtnViewBinder = iGlobalCashierCVVBaseViewBinder;
        }
        IGlobalCashierCCVBtnViewBinder iGlobalCashierCCVBtnViewBinder2 = iGlobalCashierCCVBtnViewBinder;
        if (iGlobalCashierCCVBtnViewBinder2 != null) {
            iGlobalCashierCCVBtnViewBinder2.updateBtn(i > 2);
        }
    }
}
