package com.didi.soda.cart.manager.task;

import android.os.Looper;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+BI\u0012B\u0010\u0002\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJJ\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n0!j\u0002`#2\u0012\b\u0002\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010%\u001a\u00020\nJ\u0016\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000RV\u0010\u0002\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\f¨\u0006,"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestManager;", "", "runRollback", "Lkotlin/Function2;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "Lkotlin/ParameterName;", "name", "cartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "", "Lcom/didi/soda/cart/manager/task/RunRollback;", "(Lkotlin/jvm/functions/Function2;)V", "cartRequestManagerImp", "Lcom/didi/soda/cart/manager/task/CartRequestManagerImp;", "mergeSetAmountItem", "Lcom/didi/soda/cart/manager/task/CartRequestMerge;", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "mergeSetItem", "Lcom/didi/soda/cart/model/SetItemParams;", "rollbackList", "", "Lcom/didi/soda/cart/manager/task/Rollback;", "getRunRollback", "()Lkotlin/jvm/functions/Function2;", "setRunRollback", "createRpcCallback", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "model", "Lcom/didi/soda/cart/manager/task/AddTrackModel;", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartRequest;", "requestCallback", "Lkotlin/Function1;", "Lcom/didi/soda/cart/manager/task/CartResponse;", "Lcom/didi/soda/cart/manager/task/CardRequestCallback;", "rpcCallback", "release", "requestSetAmountItem", "params", "rpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "requestSetItem", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestManager.kt */
public final class CartRequestManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private Function2<? super CartInfoEntity, ? super SFRpcException, Unit> f40008a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CartRequestMerge<SetItemAmountParams> f40009b = CartRequestMergeKt.createSetAmountMerge(CartRequestMerge.Companion);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CartRequestMerge<SetItemParams> f40010c = CartRequestMergeKt.createSetItemMerge(CartRequestMerge.Companion);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<C13538a> f40011d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final CartRequestManagerImp f40012e = new CartRequestManagerImp(new CartRequestManager$cartRequestManagerImp$1(this));

    public CartRequestManager(Function2<? super CartInfoEntity, ? super SFRpcException, Unit> function2) {
        this.f40008a = function2;
    }

    public final Function2<CartInfoEntity, SFRpcException, Unit> getRunRollback() {
        return this.f40008a;
    }

    public final void setRunRollback(Function2<? super CartInfoEntity, ? super SFRpcException, Unit> function2) {
        this.f40008a = function2;
    }

    public final void requestSetItem(SetItemParams setItemParams, CustomerRpcService customerRpcService) {
        Intrinsics.checkNotNullParameter(setItemParams, "params");
        Intrinsics.checkNotNullParameter(customerRpcService, "rpcService");
        CartRequestManagerKt.m28519a(Intrinsics.stringPlus("requestSetItem : begin merge = ", setItemParams));
        this.f40010c.merge(setItemParams, new CartRequestManager$requestSetItem$1(this, customerRpcService));
    }

    public final void requestSetAmountItem(SetItemAmountParams setItemAmountParams, CustomerRpcService customerRpcService) {
        Intrinsics.checkNotNullParameter(setItemAmountParams, "params");
        Intrinsics.checkNotNullParameter(customerRpcService, "rpcService");
        CartRequestManagerKt.m28519a(Intrinsics.stringPlus("requestSetItem : begin merge = ", setItemAmountParams));
        this.f40009b.merge(setItemAmountParams, new CartRequestManager$requestSetAmountItem$1(this, customerRpcService));
    }

    public final void release() {
        this.f40012e.release();
    }

    /* renamed from: a */
    static /* synthetic */ CustomerRpcCallback m28509a(CartRequestManager cartRequestManager, AddTrackModel addTrackModel, CartRequest cartRequest, Function1 function1, CustomerRpcCallback customerRpcCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            customerRpcCallback = null;
        }
        return cartRequestManager.m28508a(addTrackModel, cartRequest, function1, customerRpcCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final CustomerRpcCallback<CartInfoEntity> m28508a(AddTrackModel addTrackModel, CartRequest cartRequest, Function1<? super CartResponse, Unit> function1, CustomerRpcCallback<CartInfoEntity> customerRpcCallback) {
        return new CartRequestManager$createRpcCallback$1(function1, cartRequest, customerRpcCallback, CartLoadingTrackKt.trackAddRpcCallback(addTrackModel));
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042B\u0010\u0005\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006j\u0004\u0018\u0001`\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestManager$Companion;", "", "()V", "createRequestManager", "Lcom/didi/soda/cart/manager/task/CartRequestManager;", "runRollback", "Lkotlin/Function2;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "Lkotlin/ParameterName;", "name", "cartInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "", "Lcom/didi/soda/cart/manager/task/RunRollback;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartRequestManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CartRequestManager createRequestManager(Function2<? super CartInfoEntity, ? super SFRpcException, Unit> function2) {
            if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
                return new CartRequestManager(function2);
            }
            throw new IllegalStateException("UI 线程才可以创建");
        }
    }
}
