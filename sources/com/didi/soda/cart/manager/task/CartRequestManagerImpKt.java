package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.manager.task.CartRequestManagerImp;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004*r\u0010\u0005\"6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u000626\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\r"}, mo175978d2 = {"log", "", "Lcom/didi/soda/cart/manager/task/CartRequestManagerImp$Companion;", "msg", "", "RunRollback", "Lkotlin/Function2;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "Lkotlin/ParameterName;", "name", "cartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestManagerImp.kt */
public final class CartRequestManagerImpKt {
    public static final void log(CartRequestManagerImp.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "msg");
        LogUtil.m29104i("CartRequestManagerImp", str);
    }
}
