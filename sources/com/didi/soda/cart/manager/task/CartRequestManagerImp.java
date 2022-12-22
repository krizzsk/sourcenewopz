package com.didi.soda.cart.manager.task;

import android.os.Looper;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&BI\u0012B\u0010\u0002\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000RJ\u0010\u0002\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestManagerImp;", "Lcom/didi/soda/cart/manager/task/ICartRequestManager;", "runRollback", "Lkotlin/Function2;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "Lkotlin/ParameterName;", "name", "cartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "", "Lcom/didi/soda/cart/manager/task/RunRollback;", "(Lkotlin/jvm/functions/Function2;)V", "isReleasable", "", "operations", "", "Lcom/didi/soda/cart/manager/task/Operation;", "session", "", "executeAllOp", "Lcom/didi/soda/cart/manager/task/CartRequest;", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartResponse;", "cartResponse", "executeRequest", "request", "release", "requestSetAmount", "requestSetItem", "retryRequest", "effectData", "rollback", "rollbackInfo", "Lcom/didi/soda/cart/manager/task/RollbackInfo;", "exception", "runUiThread", "tryRollback", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestManagerImp.kt */
public final class CartRequestManagerImp implements ICartRequestManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Function2<CartInfoEntity, SFRpcException, Unit> f40013a;

    /* renamed from: b */
    private final List<Operation> f40014b = CollectionsKt.listOf(new RequestVersionOperation(), new SaveOperation());

    /* renamed from: c */
    private long f40015c = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f40016d;

    public CartRequestManagerImp(Function2<? super CartInfoEntity, ? super SFRpcException, Unit> function2) {
        this.f40013a = function2;
    }

    /* renamed from: a */
    private final CartRequest m28510a(CartRequest cartRequest) {
        for (Operation execute : this.f40014b) {
            cartRequest = execute.execute(cartRequest);
        }
        return cartRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final CartResponse m28511a(CartResponse cartResponse) {
        for (Operation execute : this.f40014b) {
            cartResponse = execute.execute(cartResponse);
        }
        return cartResponse;
    }

    /* renamed from: b */
    private final void m28516b(CartRequest cartRequest) {
        cartRequest.setSession(String.valueOf(this.f40015c));
        CartRequest a = m28510a(cartRequest);
        CartRequestManagerImpKt.log(Companion, "******************************** 开始请求 ******************************** ");
        CartRequestManagerImpKt.log(Companion, Intrinsics.stringPlus("开始请求: requestKey = ", Long.valueOf(a.getRequestKey())));
        cartRequest.getRun().invoke(a, new CartRequestManagerImp$executeRequest$requestCallback$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m28517b(CartResponse cartResponse) {
        RollbackInfo rollbackInfo = cartResponse.getRollbackInfo();
        if (rollbackInfo != null) {
            Companion companion = Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("回滚信息: entity = ");
            CartInfoEntity effectiveInfo = rollbackInfo.getEffectiveInfo();
            sb.append(effectiveInfo == null ? null : effectiveInfo.getRevision());
            sb.append(" requestKey = ");
            sb.append(rollbackInfo.getRequestKey());
            CartRequestManagerImpKt.log(companion, sb.toString());
            CartRequest lastRequest = rollbackInfo.getLastRequest();
            if (lastRequest.getRequestKey() != rollbackInfo.getRequestKey()) {
                CartRequestManagerImpKt.log(Companion, "回滚的信息不是最后一次请求");
                if (lastRequest.getRetryTimes() < 1) {
                    m28512a(lastRequest, rollbackInfo.getEffectiveInfo());
                } else {
                    m28515a(rollbackInfo, cartResponse.getException());
                }
            } else {
                CartRequestManagerImpKt.log(Companion, "回滚的信息是最后一次请求");
                m28515a(rollbackInfo, cartResponse.getException());
            }
        }
    }

    /* renamed from: a */
    private final void m28512a(CartRequest cartRequest, CartInfoEntity cartInfoEntity) {
        CartRequestManagerImpKt.log(Companion, "发起重试请求");
        CartRequest cartRequest2 = new CartRequest(cartRequest.getRun());
        cartRequest2.setRequestKey(cartRequest.getRequestKey());
        cartRequest2.setRetryTimes(cartRequest2.getRetryTimes() + 1);
        cartRequest2.setRetryEffectData(cartInfoEntity);
        m28516b(cartRequest2);
    }

    /* renamed from: a */
    static /* synthetic */ void m28514a(CartRequestManagerImp cartRequestManagerImp, RollbackInfo rollbackInfo, SFRpcException sFRpcException, int i, Object obj) {
        if ((i & 2) != 0) {
            sFRpcException = null;
        }
        cartRequestManagerImp.m28515a(rollbackInfo, sFRpcException);
    }

    /* renamed from: a */
    private final void m28515a(RollbackInfo rollbackInfo, SFRpcException sFRpcException) {
        String message;
        Companion companion = Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("开始回滚: requestKey = ");
        sb.append(rollbackInfo.getRequestKey());
        sb.append(" serverVer = ");
        CartInfoEntity effectiveInfo = rollbackInfo.getEffectiveInfo();
        sb.append(effectiveInfo == null ? null : effectiveInfo.getRevision());
        sb.append(" exception = ");
        String str = "no error";
        if (!(sFRpcException == null || (message = sFRpcException.getMessage()) == null)) {
            str = message;
        }
        sb.append(str);
        CartRequestManagerImpKt.log(companion, sb.toString());
        this.f40015c++;
        Function2<CartInfoEntity, SFRpcException, Unit> function2 = this.f40013a;
        if (function2 != null) {
            function2.invoke(rollbackInfo.getEffectiveInfo(), sFRpcException);
        }
    }

    /* renamed from: c */
    private final void m28518c(CartRequest cartRequest) {
        if (!Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            UiHandlerUtil.post(new Runnable(cartRequest) {
                public final /* synthetic */ CartRequest f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CartRequestManagerImp.m28513a(CartRequestManagerImp.this, this.f$1);
                }
            });
        } else {
            m28516b(cartRequest);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28513a(CartRequestManagerImp cartRequestManagerImp, CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequestManagerImp, "this$0");
        Intrinsics.checkNotNullParameter(cartRequest, "$cartRequest");
        cartRequestManagerImp.m28516b(cartRequest);
    }

    public void requestSetItem(CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequest, "cartRequest");
        m28518c(cartRequest);
    }

    public void requestSetAmount(CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequest, "cartRequest");
        m28518c(cartRequest);
    }

    public void release() {
        this.f40016d = true;
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestManagerImp$Companion;", "", "()V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartRequestManagerImp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
