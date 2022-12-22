package com.didi.soda.cart.repo;

import android.os.Bundle;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.CustomerResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartRepo.kt */
final class CustomerCartRepo$getRequestManager$1 extends Lambda implements Function2<CartInfoEntity, SFRpcException, Unit> {
    final /* synthetic */ String $cartId;
    final /* synthetic */ String $shopId;
    final /* synthetic */ CustomerCartRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerCartRepo$getRequestManager$1(CustomerCartRepo customerCartRepo, String str, String str2) {
        super(2);
        this.this$0 = customerCartRepo;
        this.$shopId = str;
        this.$cartId = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CartInfoEntity) obj, (SFRpcException) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        CustomerResource customerResource;
        int i;
        String str;
        this.this$0.m28538b(this.$shopId).getLoadingTrack().track(this.$shopId, this.$cartId, cartInfoEntity, sFRpcException);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ParamConst.ADD_OR_MINUS_ITEM, true);
        CustomerCartRepo customerCartRepo = this.this$0;
        String str2 = this.$shopId;
        String str3 = null;
        if (cartInfoEntity == null) {
            customerResource = null;
        } else {
            if (sFRpcException == null) {
                str = null;
            } else {
                str = sFRpcException.getMessage();
            }
            customerResource = CustomerResource.success(cartInfoEntity, 0, str, bundle);
        }
        if (customerResource == null) {
            if (sFRpcException == null) {
                i = -1;
            } else {
                i = sFRpcException.getCode();
            }
            if (sFRpcException != null) {
                str3 = sFRpcException.getMessage();
            }
            customerResource = CustomerResource.error(i, str3, this.this$0.m28536a(this.$shopId), bundle);
            Intrinsics.checkNotNullExpressionValue(customerResource, "error(ex?.code\n         …foEntity(shopId), bundle)");
        }
        customerCartRepo.m28537a(str2, (CustomerResource<CartInfoEntity>) customerResource);
    }
}
