package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartResponse;", "", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartRequest;", "cartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "exception", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "(Lcom/didi/soda/cart/manager/task/CartRequest;Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;)V", "getCartInfoEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getCartRequest", "()Lcom/didi/soda/cart/manager/task/CartRequest;", "getException", "()Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "requestKey", "", "getRequestKey", "()J", "rollbackInfo", "Lcom/didi/soda/cart/manager/task/RollbackInfo;", "getRollbackInfo", "()Lcom/didi/soda/cart/manager/task/RollbackInfo;", "setRollbackInfo", "(Lcom/didi/soda/cart/manager/task/RollbackInfo;)V", "serverVersion", "getServerVersion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartResponse.kt */
public final class CartResponse {

    /* renamed from: a */
    private final CartRequest f40025a;

    /* renamed from: b */
    private final CartInfoEntity f40026b;

    /* renamed from: c */
    private final SFRpcException f40027c;

    /* renamed from: d */
    private final long f40028d;

    /* renamed from: e */
    private final long f40029e;

    /* renamed from: f */
    private RollbackInfo f40030f;

    public CartResponse(CartRequest cartRequest, CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(cartRequest, "cartRequest");
        this.f40025a = cartRequest;
        this.f40026b = cartInfoEntity;
        this.f40027c = sFRpcException;
        this.f40028d = cartRequest.getRequestKey();
        this.f40029e = CartResponseKt.getServerRevision(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartResponse(CartRequest cartRequest, CartInfoEntity cartInfoEntity, SFRpcException sFRpcException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cartRequest, (i & 2) != 0 ? null : cartInfoEntity, (i & 4) != 0 ? null : sFRpcException);
    }

    public final CartRequest getCartRequest() {
        return this.f40025a;
    }

    public final CartInfoEntity getCartInfoEntity() {
        return this.f40026b;
    }

    public final SFRpcException getException() {
        return this.f40027c;
    }

    public final long getRequestKey() {
        return this.f40028d;
    }

    public final long getServerVersion() {
        return this.f40029e;
    }

    public final RollbackInfo getRollbackInfo() {
        return this.f40030f;
    }

    public final void setRollbackInfo(RollbackInfo rollbackInfo) {
        this.f40030f = rollbackInfo;
    }
}
