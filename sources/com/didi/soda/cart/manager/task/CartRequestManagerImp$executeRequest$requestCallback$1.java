package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.manager.task.CartRequestManagerImp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didi/soda/cart/manager/task/CartResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestManagerImp.kt */
final class CartRequestManagerImp$executeRequest$requestCallback$1 extends Lambda implements Function1<CartResponse, Unit> {
    final /* synthetic */ CartRequestManagerImp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CartRequestManagerImp$executeRequest$requestCallback$1(CartRequestManagerImp cartRequestManagerImp) {
        super(1);
        this.this$0 = cartRequestManagerImp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CartResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "it");
        CartRequestManagerImp.Companion companion = CartRequestManagerImp.Companion;
        CartRequestManagerImpKt.log(companion, "原始请求请求结果: requestKey = " + cartResponse.getRequestKey() + " serverVer = " + cartResponse.getServerVersion());
        CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, "******************************** 请求结束 ******************************** ");
        if (!this.this$0.f40016d) {
            CartResponse access$executeAllOp = this.this$0.m28511a(cartResponse);
            if (access$executeAllOp.getRollbackInfo() == null) {
                CartRequestManagerImpKt.log(CartRequestManagerImp.Companion, "回滚信息: 没有回滚信息");
            } else {
                this.this$0.m28517b(access$executeAllOp);
            }
        }
    }
}
