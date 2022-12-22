package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/Rollback;", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;)V", "getEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getEx", "()Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.cart.manager.task.a */
/* compiled from: CartRequestManager.kt */
final class C13538a {

    /* renamed from: a */
    private final CartInfoEntity f40039a;

    /* renamed from: b */
    private final SFRpcException f40040b;

    public C13538a() {
        this((CartInfoEntity) null, (SFRpcException) null, 3, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    public static /* synthetic */ C13538a m28525a(C13538a aVar, CartInfoEntity cartInfoEntity, SFRpcException sFRpcException, int i, Object obj) {
        if ((i & 1) != 0) {
            cartInfoEntity = aVar.f40039a;
        }
        if ((i & 2) != 0) {
            sFRpcException = aVar.f40040b;
        }
        return aVar.mo101346a(cartInfoEntity, sFRpcException);
    }

    /* renamed from: a */
    public final C13538a mo101346a(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        return new C13538a(cartInfoEntity, sFRpcException);
    }

    /* renamed from: c */
    public final CartInfoEntity mo101349c() {
        return this.f40039a;
    }

    /* renamed from: d */
    public final SFRpcException mo101350d() {
        return this.f40040b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13538a)) {
            return false;
        }
        C13538a aVar = (C13538a) obj;
        return Intrinsics.areEqual((Object) this.f40039a, (Object) aVar.f40039a) && Intrinsics.areEqual((Object) this.f40040b, (Object) aVar.f40040b);
    }

    public int hashCode() {
        CartInfoEntity cartInfoEntity = this.f40039a;
        int i = 0;
        int hashCode = (cartInfoEntity == null ? 0 : cartInfoEntity.hashCode()) * 31;
        SFRpcException sFRpcException = this.f40040b;
        if (sFRpcException != null) {
            i = sFRpcException.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Rollback(entity=" + this.f40039a + ", ex=" + this.f40040b + VersionRange.RIGHT_OPEN;
    }

    public C13538a(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        this.f40039a = cartInfoEntity;
        this.f40040b = sFRpcException;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C13538a(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cartInfoEntity, (i & 2) != 0 ? null : sFRpcException);
    }

    /* renamed from: a */
    public final CartInfoEntity mo101347a() {
        return this.f40039a;
    }

    /* renamed from: b */
    public final SFRpcException mo101348b() {
        return this.f40040b;
    }
}
