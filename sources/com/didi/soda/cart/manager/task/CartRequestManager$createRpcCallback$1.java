package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/cart/manager/task/CartRequestManager$createRpcCallback$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestManager.kt */
public final class CartRequestManager$createRpcCallback$1 extends CustomerRpcCallback<CartInfoEntity> {
    final /* synthetic */ CartRequest $cartRequest;
    final /* synthetic */ Function1<CartResponse, Unit> $requestCallback;
    final /* synthetic */ CustomerRpcCallback<CartInfoEntity> $rpcCallback;
    final /* synthetic */ CustomerRpcCallback<CartInfoEntity> $trackRpcCallback;

    CartRequestManager$createRpcCallback$1(Function1<? super CartResponse, Unit> function1, CartRequest cartRequest, CustomerRpcCallback<CartInfoEntity> customerRpcCallback, CustomerRpcCallback<CartInfoEntity> customerRpcCallback2) {
        this.$requestCallback = function1;
        this.$cartRequest = cartRequest;
        this.$rpcCallback = customerRpcCallback;
        this.$trackRpcCallback = customerRpcCallback2;
    }

    public void onRpcSuccess(CartInfoEntity cartInfoEntity, long j) {
        this.$requestCallback.invoke(new CartResponse(this.$cartRequest, cartInfoEntity, (SFRpcException) null, 4, (DefaultConstructorMarker) null));
        CustomerRpcCallback<CartInfoEntity> customerRpcCallback = this.$rpcCallback;
        if (customerRpcCallback != null) {
            customerRpcCallback.onRpcSuccess(cartInfoEntity, j);
        }
        this.$trackRpcCallback.onRpcSuccess(cartInfoEntity, j);
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        this.$requestCallback.invoke(new CartResponse(this.$cartRequest, (CartInfoEntity) null, sFRpcException, 2, (DefaultConstructorMarker) null));
        CustomerRpcCallback<CartInfoEntity> customerRpcCallback = this.$rpcCallback;
        if (customerRpcCallback != null) {
            customerRpcCallback.onRpcFailure(sFRpcException);
        }
        this.$trackRpcCallback.onRpcFailure(sFRpcException);
    }
}
