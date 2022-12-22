package com.didi.soda.cart.manager.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/RequestVersionOperation;", "Lcom/didi/soda/cart/manager/task/Operation;", "()V", "baseRequestVersion", "", "execute", "Lcom/didi/soda/cart/manager/task/CartRequest;", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartResponse;", "cartResponse", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestVersionOperation.kt */
public final class RequestVersionOperation implements Operation {

    /* renamed from: a */
    private long f40031a = 1;

    public CartResponse execute(CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "cartResponse");
        return cartResponse;
    }

    public CartRequest execute(CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequest, "cartRequest");
        if (cartRequest.getRetryTimes() == 0 && cartRequest.getRequestKey() < 0) {
            cartRequest.setRequestKey(this.f40031a);
            this.f40031a++;
        }
        return cartRequest;
    }
}
