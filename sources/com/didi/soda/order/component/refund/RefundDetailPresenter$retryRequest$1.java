package com.didi.soda.order.component.refund;

import com.didi.soda.customer.foundation.rpc.entity.AbnormalItemsInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.order.component.refund.Contract;
import com.didi.soda.order.model.AbnormalItemsInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/order/component/refund/RefundDetailPresenter$retryRequest$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemsInfoEntity;", "onRpcFailure", "", "exception", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "time", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RefundDetailPresenter.kt */
public final class RefundDetailPresenter$retryRequest$1 extends CustomerRpcCallback<AbnormalItemsInfoEntity> {
    final /* synthetic */ RefundDetailPresenter this$0;

    RefundDetailPresenter$retryRequest$1(RefundDetailPresenter refundDetailPresenter) {
        this.this$0 = refundDetailPresenter;
    }

    public void onRpcSuccess(AbnormalItemsInfoEntity abnormalItemsInfoEntity, long j) {
        Intrinsics.checkNotNullParameter(abnormalItemsInfoEntity, "entity");
        DialogUtil.hideLoadingDialog();
        Contract.AbsRefundDetailView absRefundDetailView = (Contract.AbsRefundDetailView) this.this$0.getLogicView();
        AbnormalItemsInfoModel convert = AbnormalItemsInfoModel.Companion.convert(abnormalItemsInfoEntity);
        String access$getOrderId$p = this.this$0.f43460b;
        if (access$getOrderId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderId");
            access$getOrderId$p = null;
        }
        absRefundDetailView.updateUI(convert, access$getOrderId$p);
        ((Contract.AbsRefundDetailView) this.this$0.getLogicView()).hideAbnormalView();
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        DialogUtil.hideLoadingDialog();
        ((Contract.AbsRefundDetailView) this.this$0.getLogicView()).showAbnormalView(sFRpcException == null ? null : sFRpcException.getMessage());
    }
}
