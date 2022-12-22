package com.didi.soda.cart.repo;

import com.didi.soda.cart.manager.task.CartLoadingTrack;
import com.didi.soda.cart.manager.task.CartRequestManager;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.repo.CustomerResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u001b\u001a\u00020\u000f2B\u0010\u001c\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u001dj\u0004\u0018\u0001`$J\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010\u0013\u001a\u00020\u0014R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/cart/repo/CartDataContext;", "", "()V", "loading", "Lcom/didi/soda/customer/repo/CustomerResource;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getLoading", "()Lcom/didi/soda/customer/repo/CustomerResource;", "setLoading", "(Lcom/didi/soda/customer/repo/CustomerResource;)V", "loadingTrack", "Lcom/didi/soda/cart/manager/task/CartLoadingTrack;", "getLoadingTrack", "()Lcom/didi/soda/cart/manager/task/CartLoadingTrack;", "requestManager", "Lcom/didi/soda/cart/manager/task/CartRequestManager;", "resource", "getResource", "setResource", "retain", "", "reversion", "", "getReversion", "()Ljava/lang/String;", "setReversion", "(Ljava/lang/String;)V", "getCartRequestManager", "runRollback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "", "Lcom/didi/soda/cart/manager/task/RunRollback;", "release", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartDataContext.kt */
public final class CartDataContext {

    /* renamed from: a */
    private final CartLoadingTrack f40089a = new CartLoadingTrack();

    /* renamed from: b */
    private CustomerResource<CartInfoEntity> f40090b;

    /* renamed from: c */
    private CustomerResource<CartInfoEntity> f40091c;

    /* renamed from: d */
    private String f40092d = "0";

    /* renamed from: e */
    private CartRequestManager f40093e;

    /* renamed from: f */
    private int f40094f;

    public final CartLoadingTrack getLoadingTrack() {
        return this.f40089a;
    }

    public final CustomerResource<CartInfoEntity> getResource() {
        return this.f40090b;
    }

    public final void setResource(CustomerResource<CartInfoEntity> customerResource) {
        this.f40090b = customerResource;
    }

    public final CustomerResource<CartInfoEntity> getLoading() {
        return this.f40091c;
    }

    public final void setLoading(CustomerResource<CartInfoEntity> customerResource) {
        this.f40091c = customerResource;
    }

    public final String getReversion() {
        return this.f40092d;
    }

    public final void setReversion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40092d = str;
    }

    public final CartRequestManager getCartRequestManager(Function2<? super CartInfoEntity, ? super SFRpcException, Unit> function2) {
        if (this.f40093e == null) {
            this.f40093e = CartRequestManager.Companion.createRequestManager(function2);
        }
        CartRequestManager cartRequestManager = this.f40093e;
        if (cartRequestManager != null) {
            cartRequestManager.setRunRollback(function2);
        }
        CartRequestManager cartRequestManager2 = this.f40093e;
        Intrinsics.checkNotNull(cartRequestManager2);
        return cartRequestManager2;
    }

    public final int retain() {
        CartDataContextKt.m28532a(this, Intrinsics.stringPlus("before retain = ", Integer.valueOf(this.f40094f)));
        int i = this.f40094f + 1;
        this.f40094f = i;
        CartDataContextKt.m28532a(this, Intrinsics.stringPlus("after retain = ", Integer.valueOf(i)));
        return this.f40094f;
    }

    public final int release() {
        CartDataContextKt.m28532a(this, Intrinsics.stringPlus("before retain = ", Integer.valueOf(this.f40094f)));
        int i = this.f40094f - 1;
        this.f40094f = i;
        CartDataContextKt.m28532a(this, Intrinsics.stringPlus("after retain = ", Integer.valueOf(i)));
        if (this.f40094f <= 0) {
            CartRequestManager cartRequestManager = this.f40093e;
            if (cartRequestManager != null) {
                cartRequestManager.release();
            }
            this.f40093e = null;
        }
        return this.f40094f;
    }
}
