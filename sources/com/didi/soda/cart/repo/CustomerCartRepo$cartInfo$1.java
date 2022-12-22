package com.didi.soda.cart.repo;

import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.repo.CustomerResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/cart/repo/CustomerCartRepo$cartInfo$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartRepo.kt */
public final class CustomerCartRepo$cartInfo$1 extends CustomerRpcCallback<CartInfoEntity> {
    final /* synthetic */ String $shopId;
    final /* synthetic */ CustomerCartRepo this$0;

    CustomerCartRepo$cartInfo$1(CustomerCartRepo customerCartRepo, String str) {
        this.this$0 = customerCartRepo;
        this.$shopId = str;
    }

    public void onRpcSuccess(CartInfoEntity cartInfoEntity, long j) {
        if (!this.this$0.m28540c(this.$shopId) && cartInfoEntity != null) {
            CustomerCartRepo customerCartRepo = this.this$0;
            String str = this.$shopId;
            CustomerResource success = CustomerResource.success(cartInfoEntity);
            Intrinsics.checkNotNullExpressionValue(success, "success(var1)");
            customerCartRepo.m28537a(str, (CustomerResource<CartInfoEntity>) success);
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Unit unit;
        if (sFRpcException != null) {
            FloatingCartOmegaHelper.Companion.cartInfoError(sFRpcException.getCode(), sFRpcException.getMessage());
        }
        if (!this.this$0.m28540c(this.$shopId)) {
            if (sFRpcException == null) {
                unit = null;
            } else {
                CustomerCartRepo customerCartRepo = this.this$0;
                String str = this.$shopId;
                CustomerResource error = CustomerResource.error(sFRpcException.getCode(), "");
                Intrinsics.checkNotNullExpressionValue(error, "error(it.code, \"\")");
                customerCartRepo.m28537a(str, (CustomerResource<CartInfoEntity>) error);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                CustomerCartRepo customerCartRepo2 = this.this$0;
                String str2 = this.$shopId;
                CustomerResource error2 = CustomerResource.error(-1, "");
                Intrinsics.checkNotNullExpressionValue(error2, "error(-1, \"\")");
                customerCartRepo2.m28537a(str2, (CustomerResource<CartInfoEntity>) error2);
            }
        }
    }
}
