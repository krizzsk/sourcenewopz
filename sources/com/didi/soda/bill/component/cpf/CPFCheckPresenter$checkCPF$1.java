package com.didi.soda.bill.component.cpf;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.entity.bill.CPFInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/bill/component/cpf/CPFCheckPresenter$checkCPF$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/CPFInfoEntity;", "onRpcSuccess", "", "entity", "serverTime", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckPresenter.kt */
public final class CPFCheckPresenter$checkCPF$1 extends CustomerRpcCallback<CPFInfoEntity> {
    final /* synthetic */ CPFCheckPresenter this$0;

    CPFCheckPresenter$checkCPF$1(CPFCheckPresenter cPFCheckPresenter) {
        this.this$0 = cPFCheckPresenter;
    }

    public void onRpcSuccess(CPFInfoEntity cPFInfoEntity, long j) {
        if (cPFInfoEntity != null) {
            CPFCheckPresenter cPFCheckPresenter = this.this$0;
            if (cPFInfoEntity.getStatus() == 1) {
                CPFCheckVisibleListener access$getVisibleListener$p = cPFCheckPresenter.f38922a;
                if (access$getVisibleListener$p != null) {
                    access$getVisibleListener$p.hideCPFCheckView();
                    return;
                }
                return;
            }
            String statusDesc = cPFInfoEntity.getStatusDesc();
            if (statusDesc != null) {
                BillOmegaHelper.Companion.trackCPFCheckFailSW();
                ((Contract.AbsCPFCheckView) cPFCheckPresenter.getLogicView()).refreshInfo(statusDesc, statusDesc);
            }
            String timesDesc = cPFInfoEntity.getTimesDesc();
            if (timesDesc != null) {
                BillOmegaHelper.Companion.trackCPFToastSW();
                ((Contract.AbsCPFCheckView) cPFCheckPresenter.getLogicView()).showToast(timesDesc);
            }
        }
    }
}
