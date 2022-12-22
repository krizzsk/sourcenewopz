package com.didi.soda.globalcart.component;

import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.globalcart.component.Contract;
import com.didi.soda.globalcart.component.GlobalCartPresenter;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/globalcart/component/GlobalCartPresenter$fetchBillListInfo$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/globalcart/entity/BillListInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartPresenter.kt */
public final class GlobalCartPresenter$fetchBillListInfo$1 extends CustomerRpcCallback<BillListInfoEntity> {
    final /* synthetic */ GlobalCartPresenter this$0;

    GlobalCartPresenter$fetchBillListInfo$1(GlobalCartPresenter globalCartPresenter) {
        this.this$0 = globalCartPresenter;
    }

    public void onRpcSuccess(BillListInfoEntity billListInfoEntity, long j) {
        ArrayList<BillInfoEntity> arrayList = null;
        LogUtil.m29104i(GlobalCartPresenter.TAG, Intrinsics.stringPlus("fetchBillListInfo onRpcSuccess, BillListInfoEntity = ", billListInfoEntity == null ? null : billListInfoEntity.toString()));
        ((Contract.AbsGlobalCartView) this.this$0.getLogicView()).hideLoadingView();
        if (billListInfoEntity != null) {
            Collection bills = billListInfoEntity.getBills();
            if (!(bills == null || bills.isEmpty())) {
                this.this$0.m29797a(billListInfoEntity);
                return;
            }
        }
        if (billListInfoEntity != null) {
            arrayList = billListInfoEntity.getBills();
        }
        if (arrayList == null || billListInfoEntity.getBills().isEmpty()) {
            this.this$0.m29795a(GlobalCartPresenter.ErrorType.NO_DATA, "");
            this.this$0.f42285b = true;
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        String message;
        LogUtil.m29104i(GlobalCartPresenter.TAG, Intrinsics.stringPlus("fetchBillListInfo onRpcFailure, SFRpcException = ", sFRpcException == null ? null : sFRpcException.toString()));
        ((Contract.AbsGlobalCartView) this.this$0.getLogicView()).hideLoadingView();
        if (!NetWorkUtils.isNetworkConnected(this.this$0.getContext())) {
            this.this$0.m29795a(GlobalCartPresenter.ErrorType.NO_NETWORK, "");
        } else {
            String string = this.this$0.getContext().getResources().getString(R.string.customer_service_not_connected);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…er_service_not_connected)");
            if (!(sFRpcException == null || (message = sFRpcException.getMessage()) == null)) {
                CharSequence charSequence = message;
                if (!(charSequence.length() == 0) && !StringsKt.contains$default(charSequence, (CharSequence) StringConst.JAVA, false, 2, (Object) null)) {
                    string = message;
                }
            }
            this.this$0.m29795a(GlobalCartPresenter.ErrorType.NO_SERVICE, string);
        }
        this.this$0.f42285b = true;
    }
}
