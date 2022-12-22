package com.didi.soda.globalcart.repo;

import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.globalcart.omega.GlobalCartOmegaHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/globalcart/repo/GlobalCartListRepo$fetchGlobalCartListInfo$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/globalcart/entity/BillListInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartListRepo.kt */
public final class GlobalCartListRepo$fetchGlobalCartListInfo$1 extends CustomerRpcCallback<BillListInfoEntity> {
    final /* synthetic */ CustomerRpcCallback<BillListInfoEntity> $callback;
    final /* synthetic */ GlobalCartListRepo this$0;

    GlobalCartListRepo$fetchGlobalCartListInfo$1(GlobalCartListRepo globalCartListRepo, CustomerRpcCallback<BillListInfoEntity> customerRpcCallback) {
        this.this$0 = globalCartListRepo;
        this.$callback = customerRpcCallback;
    }

    public void onRpcSuccess(BillListInfoEntity billListInfoEntity, long j) {
        if (billListInfoEntity != null) {
            this.this$0.setValue(CustomerResource.success(billListInfoEntity));
            CustomerRpcCallback<BillListInfoEntity> customerRpcCallback = this.$callback;
            if (customerRpcCallback != null) {
                customerRpcCallback.onRpcSuccess(billListInfoEntity, j);
            }
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        if (sFRpcException != null) {
            this.this$0.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            CustomerRpcCallback<BillListInfoEntity> customerRpcCallback = this.$callback;
            if (customerRpcCallback != null) {
                customerRpcCallback.onRpcFailure(sFRpcException);
            }
            GlobalCartOmegaHelper globalCartOmegaHelper = new GlobalCartOmegaHelper();
            String valueOf = String.valueOf(sFRpcException.getCode());
            String message = sFRpcException.getMessage();
            if (message == null) {
                message = "";
            }
            globalCartOmegaHelper.trackGlobalCartListError(EventConst.GlobalCart.TECH_SAILING_C_CART_LIST_API_ERROR, valueOf, message);
        }
    }
}
