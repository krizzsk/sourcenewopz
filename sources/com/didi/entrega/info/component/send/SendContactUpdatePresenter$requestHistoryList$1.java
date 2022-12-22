package com.didi.entrega.info.component.send;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactListEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.helper.InfoOmegaHelper;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.didi.entrega.info.model.BaseContactModel;
import com.didi.entrega.info.repo.HistoryListRepo;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/info/component/send/SendContactUpdatePresenter$requestHistoryList$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "contactListEntity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SendContactUpdatePresenter.kt */
public final class SendContactUpdatePresenter$requestHistoryList$1 extends CustomerRpcCallback<ContactListEntity> {
    final /* synthetic */ CommonInfoEntity $commonInfoEntity;
    final /* synthetic */ SendContactUpdatePresenter this$0;

    SendContactUpdatePresenter$requestHistoryList$1(SendContactUpdatePresenter sendContactUpdatePresenter, CommonInfoEntity commonInfoEntity) {
        this.this$0 = sendContactUpdatePresenter;
        this.$commonInfoEntity = commonInfoEntity;
    }

    public void onRpcSuccess(ContactListEntity contactListEntity, long j) {
        this.this$0.m15204b();
        this.this$0.m15205b(this.$commonInfoEntity);
        this.this$0.setHistoryContactList(InfoDataHelper.INSTANCE.parseHistoryModelByUpdate(contactListEntity));
        this.this$0.getHistoryListRepo().putSendHistoryContactList(this.this$0.getHistoryContactList(), HistoryListRepo.Companion.getUPDATE_HIS());
        SendContactUpdatePresenter sendContactUpdatePresenter = this.this$0;
        InfoDataHelper infoDataHelper = InfoDataHelper.INSTANCE;
        CommonInfoEntity commonInfoEntity = this.$commonInfoEntity;
        InfoStepConfig currentStepConfig = this.this$0.getCurrentStepConfig();
        sendContactUpdatePresenter.setTitleModel(infoDataHelper.parseHistoryTitle(commonInfoEntity, currentStepConfig == null ? 1 : currentStepConfig.getCurrentStep()));
        SendContactUpdatePresenter sendContactUpdatePresenter2 = this.this$0;
        ArrayList<BaseContactModel> randerHistoryWithTitle = sendContactUpdatePresenter2.randerHistoryWithTitle(sendContactUpdatePresenter2.getTitleModel(), this.this$0.getHistoryContactList());
        if (randerHistoryWithTitle != null) {
            SendContactUpdatePresenter sendContactUpdatePresenter3 = this.this$0;
            sendContactUpdatePresenter3.getDataListManager().addAll(randerHistoryWithTitle);
            InfoOmegaHelper.INSTANCE.trackHistorySw(sendContactUpdatePresenter3);
        }
        this.this$0.subscrib();
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Integer num;
        super.onRpcFailure(sFRpcException);
        this.this$0.m15204b();
        ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_E_INFO_HISTORY_ADDRESS_ERROR).addModuleName("info");
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
        this.this$0.m15205b(this.$commonInfoEntity);
    }
}
