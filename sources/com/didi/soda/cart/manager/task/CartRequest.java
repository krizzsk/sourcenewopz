package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B`\u0012Y\u0010\u0002\u001aU\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u00122\u00120\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0011`\n¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0003j\u0002`\f¢\u0006\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRd\u0010\u0002\u001aU\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u00122\u00120\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0011`\n¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0003j\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequest;", "", "run", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cartRequest", "Lkotlin/Function1;", "Lcom/didi/soda/cart/manager/task/CartResponse;", "", "Lcom/didi/soda/cart/manager/task/CardRequestCallback;", "requestCallback", "Lcom/didi/soda/cart/manager/task/RunCartRequest;", "(Lkotlin/jvm/functions/Function2;)V", "requestKey", "", "getRequestKey", "()J", "setRequestKey", "(J)V", "retryEffectData", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getRetryEffectData", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "setRetryEffectData", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;)V", "retryTimes", "", "getRetryTimes", "()I", "setRetryTimes", "(I)V", "getRun", "()Lkotlin/jvm/functions/Function2;", "session", "", "getSession", "()Ljava/lang/String;", "setSession", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequest.kt */
public final class CartRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_RETRY_TIMES = 1;

    /* renamed from: a */
    private final Function2<CartRequest, Function1<? super CartResponse, Unit>, Unit> f40003a;

    /* renamed from: b */
    private String f40004b = "";

    /* renamed from: c */
    private long f40005c = -1;

    /* renamed from: d */
    private int f40006d;

    /* renamed from: e */
    private CartInfoEntity f40007e;

    public CartRequest(Function2<? super CartRequest, ? super Function1<? super CartResponse, Unit>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "run");
        this.f40003a = function2;
    }

    public final Function2<CartRequest, Function1<? super CartResponse, Unit>, Unit> getRun() {
        return this.f40003a;
    }

    public final String getSession() {
        return this.f40004b;
    }

    public final void setSession(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40004b = str;
    }

    public final long getRequestKey() {
        return this.f40005c;
    }

    public final void setRequestKey(long j) {
        this.f40005c = j;
    }

    public final int getRetryTimes() {
        return this.f40006d;
    }

    public final void setRetryTimes(int i) {
        this.f40006d = i;
    }

    public final CartInfoEntity getRetryEffectData() {
        return this.f40007e;
    }

    public final void setRetryEffectData(CartInfoEntity cartInfoEntity) {
        this.f40007e = cartInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ja\u0010\u0005\u001a\u00020\u00062Y\u0010\u0007\u001aU\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u00122\u00120\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0011`\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\bj\u0002`\u0011Ja\u0010\u0012\u001a\u00020\u00062Y\u0010\u0007\u001aU\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u00122\u00120\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0011`\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\bj\u0002`\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequest$Companion;", "", "()V", "MAX_RETRY_TIMES", "", "createCardSetAmount", "Lcom/didi/soda/cart/manager/task/CartRequest;", "runRequest", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cartRequest", "Lkotlin/Function1;", "Lcom/didi/soda/cart/manager/task/CartResponse;", "", "Lcom/didi/soda/cart/manager/task/CardRequestCallback;", "requestCallback", "Lcom/didi/soda/cart/manager/task/RunCartRequest;", "createSetItemRequest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CartRequest createSetItemRequest(Function2<? super CartRequest, ? super Function1<? super CartResponse, Unit>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "runRequest");
            return new CartRequest(function2);
        }

        public final CartRequest createCardSetAmount(Function2<? super CartRequest, ? super Function1<? super CartResponse, Unit>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "runRequest");
            return new CartRequest(function2);
        }
    }
}
