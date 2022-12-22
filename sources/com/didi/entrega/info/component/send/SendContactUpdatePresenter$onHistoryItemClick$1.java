package com.didi.entrega.info.component.send;

import android.text.TextUtils;
import com.didi.entrega.address.data.entity.AddressCheckEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.model.HistoryModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/info/component/send/SendContactUpdatePresenter$onHistoryItemClick$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/address/data/entity/AddressCheckEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SendContactUpdatePresenter.kt */
public final class SendContactUpdatePresenter$onHistoryItemClick$1 extends CustomerRpcCallback<AddressCheckEntity> {
    final /* synthetic */ HistoryModel $item;
    final /* synthetic */ SendContactUpdatePresenter this$0;

    SendContactUpdatePresenter$onHistoryItemClick$1(SendContactUpdatePresenter sendContactUpdatePresenter, HistoryModel historyModel) {
        this.this$0 = sendContactUpdatePresenter;
        this.$item = historyModel;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        super.onRpcFailure(sFRpcException);
        ((ContactConstract.AbsEditContactView) this.this$0.getLogicView()).hideLoading();
        ToastUtil.showCustomerToast(this.this$0.getScopeContext(), ResourceHelper.getString(R.string.FoodC_orderlist3_Check_the_uDiY));
    }

    public void onRpcSuccess(AddressCheckEntity addressCheckEntity, long j) {
        ((ContactConstract.AbsEditContactView) this.this$0.getLogicView()).hideLoading();
        if (addressCheckEntity == null) {
            return;
        }
        if (addressCheckEntity.legal) {
            this.this$0.infoAutoFill(this.$item);
        } else if (!TextUtils.isEmpty(addressCheckEntity.content)) {
            ToastUtil.showCustomerToast(this.this$0.getScopeContext(), addressCheckEntity.content);
        }
    }
}
