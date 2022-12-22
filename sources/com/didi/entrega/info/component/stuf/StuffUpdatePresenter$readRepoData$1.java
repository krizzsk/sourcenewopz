package com.didi.entrega.info.component.stuf;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.info.component.StuffConstract;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/info/component/stuf/StuffUpdatePresenter$readRepoData$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffUpdatePresenter.kt */
public final class StuffUpdatePresenter$readRepoData$1 extends CustomerRpcCallback<CommonInfoEntity> {
    final /* synthetic */ StuffUpdatePresenter this$0;

    StuffUpdatePresenter$readRepoData$1(StuffUpdatePresenter stuffUpdatePresenter) {
        this.this$0 = stuffUpdatePresenter;
    }

    public void onRpcSuccess(CommonInfoEntity commonInfoEntity, long j) {
        Unit unit;
        ((StuffConstract.AbsCommonStuffView) this.this$0.getLogicView()).hideAbnormal();
        ((StuffConstract.AbsCommonStuffView) this.this$0.getLogicView()).hideLoading();
        if (commonInfoEntity == null) {
            unit = null;
        } else {
            this.this$0.initStuffModel(commonInfoEntity);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            StuffUpdatePresenter stuffUpdatePresenter = this.this$0;
            String string = ResourceHelper.getString(R.string.FoodC_remind_Unable_to_Wjlz);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC_remind_Unable_to_Wjlz)");
            stuffUpdatePresenter.m15211a(string);
        }
        this.this$0.subscrib();
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Integer num;
        String message;
        super.onRpcFailure(sFRpcException);
        ((StuffConstract.AbsCommonStuffView) this.this$0.getLogicView()).hideLoading();
        ((StuffConstract.AbsCommonStuffView) this.this$0.getLogicView()).hideAbnormal();
        ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_E_INFO_CONFIG_ERROR).addModuleName("info");
        String str = null;
        if (sFRpcException == null) {
            num = null;
        } else {
            num = Integer.valueOf(sFRpcException.getCode());
        }
        String valueOf = String.valueOf(num);
        String str2 = "";
        if (valueOf == null) {
            valueOf = str2;
        }
        ErrorTracker.Builder addErrorType = addModuleName.addErrorType(valueOf);
        if (!(sFRpcException == null || (message = sFRpcException.getMessage()) == null)) {
            str2 = message;
        }
        addErrorType.addErrorMsg(str2).build().trackError();
        StuffUpdatePresenter stuffUpdatePresenter = this.this$0;
        if (sFRpcException != null) {
            str = sFRpcException.getMessage();
        }
        if (str == null) {
            str = ResourceHelper.getString(R.string.FoodC_remind_Unable_to_Wjlz);
        }
        Intrinsics.checkNotNullExpressionValue(str, "ex?.message\n            …dC_remind_Unable_to_Wjlz)");
        stuffUpdatePresenter.m15211a(str);
    }
}
