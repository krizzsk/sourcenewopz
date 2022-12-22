package com.didi.soda.address.component.selectlist;

import android.os.Bundle;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.OrderChangeAddress;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.rpc.net.SFRpcResult;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/address/component/selectlist/SelectedAddressPresenter$onConfirmClick$1$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderChangeAddress;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressPresenter.kt */
public final class SelectedAddressPresenter$onConfirmClick$1$1 extends CustomerRpcCallback<OrderChangeAddress> {
    final /* synthetic */ SelectedAddressPresenter this$0;

    SelectedAddressPresenter$onConfirmClick$1$1(SelectedAddressPresenter selectedAddressPresenter) {
        this.this$0 = selectedAddressPresenter;
    }

    public void onRpcSuccess(OrderChangeAddress orderChangeAddress, long j) {
        DialogUtil.hideLoadingDialog();
        if (orderChangeAddress != null && orderChangeAddress.getReminder() != null) {
            SelectedAddressPresenter selectedAddressPresenter = this.this$0;
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            hashMap.put("modifyAddressSuccessToast", orderChangeAddress.getReminder());
            bundle.putSerializable("data", hashMap);
            selectedAddressPresenter.getScopeContext().getNavigator().finish(bundle);
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(selectedAddressPresenter.getSelectedAddress(), 3);
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        SFRpcResult result;
        Object data;
        DialogUtil.hideLoadingDialog();
        Unit unit = null;
        if (!(sFRpcException == null || (result = sFRpcException.getResult()) == null || (data = result.getData()) == null)) {
            SelectedAddressPresenter selectedAddressPresenter = this.this$0;
            if (data instanceof OrderChangeAddress) {
                String reminder = ((OrderChangeAddress) data).getReminder();
                AddressOmegaHelper.traceDeliveryConfirmFailSW();
                DialogUtil.showOrderAddressUpdateFailed(selectedAddressPresenter.getScopeContext().getNavigator(), reminder, C13380x80705d3f.INSTANCE);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SelectedAddressPresenter$onConfirmClick$1$1 selectedAddressPresenter$onConfirmClick$1$1 = this;
            super.onRpcFailure(sFRpcException);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onRpcFailure$lambda-2$lambda-1  reason: not valid java name */
    public static final void m46718onRpcFailure$lambda2$lambda1(RFDialog rFDialog) {
        rFDialog.dismiss();
    }
}
