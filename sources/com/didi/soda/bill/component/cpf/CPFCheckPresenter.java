package com.didi.soda.bill.component.cpf;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/bill/component/cpf/CPFCheckPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsCPFCheckPresenter;", "()V", "visibleListener", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "checkCPF", "", "cpfStr", "", "birthStr", "onCreate", "setCPFVisibleListener", "listener", "skip", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckPresenter.kt */
public final class CPFCheckPresenter extends Contract.AbsCPFCheckPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CPFCheckVisibleListener f38922a;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        BillOmegaHelper.Companion.trackCPFCheckSW();
    }

    public void checkCPF(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "cpfStr");
        Intrinsics.checkNotNullParameter(str2, "birthStr");
        BillOmegaHelper.Companion.trackCPFCheckCK(1);
        CustomerRpcManagerProxy.get().fetchCPFInfo(str, str2, new CPFCheckPresenter$checkCPF$1(this));
    }

    public void skip() {
        BillOmegaHelper.Companion.trackCPFCheckCK(2);
        CustomerRpcManagerProxy.get().commonNotifyConfirmation(1, "CPF", new CPFCheckPresenter$skip$1());
        CPFCheckVisibleListener cPFCheckVisibleListener = this.f38922a;
        if (cPFCheckVisibleListener != null) {
            cPFCheckVisibleListener.hideCPFCheckView();
        }
    }

    public void setCPFVisibleListener(CPFCheckVisibleListener cPFCheckVisibleListener) {
        Intrinsics.checkNotNullParameter(cPFCheckVisibleListener, "listener");
        this.f38922a = cPFCheckVisibleListener;
    }
}
