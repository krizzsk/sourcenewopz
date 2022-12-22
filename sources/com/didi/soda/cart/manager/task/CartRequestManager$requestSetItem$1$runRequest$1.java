package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.AddCartRequestParamsKt;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032%\u0010\u0004\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0011`\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004H\n"}, mo175978d2 = {"<anonymous>", "", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartRequest;", "requestCallback", "Lkotlin/Function1;", "Lcom/didi/soda/cart/manager/task/CartResponse;", "Lcom/didi/soda/cart/manager/task/CardRequestCallback;", "Lkotlin/ParameterName;", "name"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestManager.kt */
final class CartRequestManager$requestSetItem$1$runRequest$1 extends Lambda implements Function2<CartRequest, Function1<? super CartResponse, ? extends Unit>, Unit> {
    final /* synthetic */ CartMergeModel $mergeModel;
    final /* synthetic */ SetItemParams $requestParam;
    final /* synthetic */ CustomerRpcService $rpcService;
    final /* synthetic */ CartRequestManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CartRequestManager$requestSetItem$1$runRequest$1(SetItemParams setItemParams, CartMergeModel cartMergeModel, CartRequestManager cartRequestManager, CustomerRpcService customerRpcService) {
        super(2);
        this.$requestParam = setItemParams;
        this.$mergeModel = cartMergeModel;
        this.this$0 = cartRequestManager;
        this.$rpcService = customerRpcService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CartRequest) obj, (Function1<? super CartResponse, Unit>) (Function1) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(CartRequest cartRequest, Function1<? super CartResponse, Unit> function1) {
        CartRequest cartRequest2 = cartRequest;
        Function1<? super CartResponse, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(cartRequest2, "cartRequest");
        Intrinsics.checkNotNullParameter(function12, "requestCallback");
        String str = this.$requestParam.getMduId() == null ? "1" : "0";
        this.$mergeModel.track(str, cartRequest.getSession());
        this.$rpcService.setItem(this.$requestParam.getCartId(), this.$requestParam.getShopId(), this.$requestParam.getMduId(), this.$requestParam.getNodeList(), this.$requestParam.getWineConfirm(), AddCartRequestParamsKt.getBaseRevision(this.$requestParam, cartRequest.getRequestKey()), this.$requestParam.getBiData(), Integer.valueOf(this.$requestParam.getTyingItemsFlag()), this.$requestParam.getActInfo(), this.this$0.m28508a(new AddTrackModel(str, this.$mergeModel.getRunMergeTimes(), cartRequest.getSession()), cartRequest2, function12, new C13537x387a17f4(this.$requestParam)));
    }
}
