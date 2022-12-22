package com.didi.entrega.pay;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.foundation.rpc.entity.PayMethodListInfoEntity;
import com.didi.entrega.pay.Contract;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/pay/PayMethodPresenter$getPayInfo$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/foundation/rpc/entity/PayMethodListInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodPresenter.kt */
public final class PayMethodPresenter$getPayInfo$1 extends CustomerRpcCallback<PayMethodListInfoEntity> {
    final /* synthetic */ PayMethodPresenter this$0;

    PayMethodPresenter$getPayInfo$1(PayMethodPresenter payMethodPresenter) {
        this.this$0 = payMethodPresenter;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        super.onRpcFailure(sFRpcException);
        DialogUtil.hideLoadingDialog();
        PayOmegaHelper.openPayView(this.this$0.getScopeContext(), 0, 0, false);
        ErrorTracker.create(ErrorConst.ErrorName.TECH_C_SERVICE_API_GET_PAY_INFO_ERROR).addModuleName("bill").addErrorType(String.valueOf(sFRpcException.getCode())).addErrorMsg(!TextUtils.isEmpty(sFRpcException.getOriginalMessage()) ? sFRpcException.getOriginalMessage() : "").build().trackError();
    }

    public void onRpcSuccess(PayMethodListInfoEntity payMethodListInfoEntity, long j) {
        DialogUtil.hideLoadingDialog();
        if (payMethodListInfoEntity != null) {
            this.this$0.f21006c.clear();
            List access$getMPayMethodInfoList$p = this.this$0.f21006c;
            List<PayMethodInfoModel> convert = PayMethodInfoModel.convert(this.this$0.getContext(), payMethodListInfoEntity, this.this$0.f21004a);
            Intrinsics.checkNotNullExpressionValue(convert, "convert(context, entity, mSelectedChannel)");
            access$getMPayMethodInfoList$p.addAll(convert);
            ((Contract.AbsPayMethodView) this.this$0.getLogicView()).updateView(this.this$0.f21006c);
            PayOmegaHelper.openPayView(this.this$0.getScopeContext(), this.this$0.m15370c(), PayMethodInfoModel.find99PayStatus(this.this$0.f21006c), PayMethodInfoModel.isDidiCashEnable(this.this$0.f21006c));
            PayMethodInfoModel.findPayPaySignStatus(this.this$0.f21006c);
        }
    }
}
