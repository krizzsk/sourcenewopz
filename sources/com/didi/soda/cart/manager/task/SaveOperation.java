package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.manager.task.CartRequestManagerImp;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/SaveOperation;", "Lcom/didi/soda/cart/manager/task/Operation;", "()V", "saveList", "", "Lcom/didi/soda/cart/manager/task/SaveInfo;", "execute", "Lcom/didi/soda/cart/manager/task/CartRequest;", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartResponse;", "cartResponse", "getLastRequest", "printSaveList", "", "save", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaveOperation.kt */
public final class SaveOperation implements Operation {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long FAIL = 0;
    public static final long INVALID = -1;

    /* renamed from: a */
    private final List<SaveInfo> f40038a = new ArrayList();

    public CartRequest execute(CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequest, "cartRequest");
        m28523a(cartRequest);
        return cartRequest;
    }

    /* renamed from: a */
    private final CartRequest m28522a() {
        return ((SaveInfo) CollectionsKt.last(this.f40038a)).getRequest();
    }

    /* renamed from: a */
    private final void m28523a(CartRequest cartRequest) {
        this.f40038a.add(new SaveInfo(cartRequest, (CartResponse) null, 0, 6, (DefaultConstructorMarker) null));
    }

    public CartResponse execute(CartResponse cartResponse) {
        CartInfoEntity cartInfoEntity;
        CartResponse cartResponse2 = cartResponse;
        Intrinsics.checkNotNullParameter(cartResponse2, "cartResponse");
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, "************** SaveOperation Begin **************");
        if (this.f40038a.isEmpty()) {
            return cartResponse2;
        }
        boolean z = false;
        CartInfoEntity cartInfoEntity2 = null;
        long j = -1;
        for (SaveInfo saveInfo : this.f40038a) {
            if (saveInfo.getRequest().getRequestKey() == cartResponse.getRequestKey()) {
                saveInfo.setServerVersion(cartResponse.getServerVersion());
                saveInfo.setResponse(cartResponse2);
                if (saveInfo.getRequest().getRetryTimes() > 0 && cartResponse.getServerVersion() == 0) {
                    saveInfo.setResponse(new CartResponse(saveInfo.getRequest(), saveInfo.getRequest().getRetryEffectData(), (SFRpcException) null, 4, (DefaultConstructorMarker) null));
                }
            }
            if (saveInfo.getServerVersion() == -1) {
                z = true;
            }
            CartResponse response = saveInfo.getResponse();
            if (!(response == null || saveInfo.getServerVersion() == -1 || saveInfo.getRequest().getRequestKey() <= j || (cartInfoEntity = response.getCartInfoEntity()) == null)) {
                j = saveInfo.getRequest().getRequestKey();
                cartInfoEntity2 = cartInfoEntity;
            }
        }
        m28524b();
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, Intrinsics.stringPlus("是否有非法版本(请求未回来）: == ", Boolean.valueOf(z)));
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, Intrinsics.stringPlus("当前有效请求 requestKey == ", Long.valueOf(j)));
        if (!z) {
            cartResponse2.setRollbackInfo(new RollbackInfo(j, cartInfoEntity2, m28522a()));
            this.f40038a.clear();
        }
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, "************** SaveOperation End **************");
        return cartResponse2;
    }

    /* renamed from: b */
    private final void m28524b() {
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, "save list: ----开始打印列表----");
        for (SaveInfo saveInfo : this.f40038a) {
            CartRequestManagerImp.Companion companion = CartRequestManagerImp.Companion;
            CartRequestManagerImpKt.log(companion, "save list: request | " + saveInfo.getRequest().getRequestKey() + " | serverVer: " + saveInfo.getServerVersion() + " | ");
        }
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, "save list: ----打印列表结束----");
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/SaveOperation$Companion;", "", "()V", "FAIL", "", "INVALID", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SaveOperation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
