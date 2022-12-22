package com.didi.entrega.bill.component.bill;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.bill.BillExt;
import com.didi.entrega.bill.component.bill.Contract;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.bill.datastore.BillRepoExtKt;
import com.didi.entrega.bill.repo.BillConfig;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/bill/component/bill/BillPresenter$subscribeBillConfig$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/bill/repo/BillConfig;", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPresenter.kt */
public final class BillPresenter$subscribeBillConfig$1 implements Action1<BillConfig> {
    final /* synthetic */ BillPresenter this$0;

    BillPresenter$subscribeBillConfig$1(BillPresenter billPresenter) {
        this.this$0 = billPresenter;
    }

    public void call(BillConfig billConfig) {
        String str;
        if (billConfig != null) {
            BillPresenter billPresenter = this.this$0;
            if (billConfig.getStuffHasShow()) {
                if (BillExt.Companion.checkAddressAndPackageInfo()) {
                    str = ResourceHelper.getString(R.string.FoodC_order_Payment_ouBA);
                } else {
                    str = ResourceHelper.getString(R.string.FoodC_info_NEXT_YECx);
                }
                ((Contract.AbsBillView) billPresenter.getLogicView()).updatePriceText(str);
            }
            if (billConfig.getRequestBill()) {
                BillRepo.Companion companion = BillRepo.Companion;
                ScopeContext scopeContext = billPresenter.getScopeContext();
                Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
                companion.get(scopeContext).setPageSource(2);
                BillRepo.Companion companion2 = BillRepo.Companion;
                ScopeContext scopeContext2 = billPresenter.getScopeContext();
                Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
                BillRepoExtKt.updateAllInfo(companion2.get(scopeContext2));
            }
        }
    }
}
