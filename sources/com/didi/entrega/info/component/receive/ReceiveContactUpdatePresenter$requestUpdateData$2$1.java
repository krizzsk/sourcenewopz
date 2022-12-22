package com.didi.entrega.info.component.receive;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/info/component/receive/ReceiveContactUpdatePresenter$requestUpdateData$2$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "commonInfoEntity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveContactUpdatePresenter.kt */
public final class ReceiveContactUpdatePresenter$requestUpdateData$2$1 extends CustomerRpcCallback<CommonInfoEntity> {
    final /* synthetic */ ReceiveContactUpdatePresenter $this_run;

    ReceiveContactUpdatePresenter$requestUpdateData$2$1(ReceiveContactUpdatePresenter receiveContactUpdatePresenter) {
        this.$this_run = receiveContactUpdatePresenter;
    }

    public void onRpcSuccess(CommonInfoEntity commonInfoEntity, long j) {
        if (commonInfoEntity != null) {
            ReceiveContactUpdatePresenter receiveContactUpdatePresenter = this.$this_run;
            ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class)).setCommonInfoEntity(commonInfoEntity);
            receiveContactUpdatePresenter.m15189a(InfoDataHelper.INSTANCE.addUpdateData(commonInfoEntity));
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Integer num;
        ReceiveContactUpdatePresenter receiveContactUpdatePresenter = this.$this_run;
        String string = ResourceHelper.getString(R.string.FoodC_remind_Unable_to_Wjlz);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC_remind_Unable_to_Wjlz)");
        receiveContactUpdatePresenter.m15192a(string);
        ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_E_INFO_FETCH_ERROR).addModuleName("info");
        String str = null;
        if (sFRpcException == null) {
            num = null;
        } else {
            num = Integer.valueOf(sFRpcException.getCode());
        }
        ErrorTracker.Builder addErrorType = addModuleName.addErrorType(String.valueOf(num));
        if (sFRpcException != null) {
            str = sFRpcException.getMessage();
        }
        addErrorType.addErrorMsg(String.valueOf(str)).build().trackError();
    }
}
