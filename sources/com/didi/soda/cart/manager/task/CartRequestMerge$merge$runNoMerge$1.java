package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.manager.task.CartRequestMerge;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0005\u001a\u0002H\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "T", "", "pre", "cur"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
final class CartRequestMerge$merge$runNoMerge$1 extends Lambda implements Function2<T, T, Unit> {
    final /* synthetic */ Function2<T, CartMergeModel, Unit> $block;
    final /* synthetic */ CartRequestMerge<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CartRequestMerge$merge$runNoMerge$1(CartRequestMerge<T> cartRequestMerge, Function2<? super T, ? super CartMergeModel, Unit> function2) {
        super(2);
        this.this$0 = cartRequestMerge;
        this.$block = function2;
    }

    public final void invoke(T t, T t2) {
        Intrinsics.checkNotNullParameter(t2, "cur");
        if (t != null) {
            CartRequestMerge<T> cartRequestMerge = this.this$0;
            Function2<T, CartMergeModel, Unit> function2 = this.$block;
            UIHandler.removeCallbacks(cartRequestMerge.f40023f);
            function2.invoke(t, cartRequestMerge.f40024g);
            cartRequestMerge.f40022e = null;
            cartRequestMerge.f40024g.clearMergeRecord();
        }
        this.this$0.f40022e = t2;
        long access$getMERGE_INTERVAL$cp = CartRequestMerge.f40017h;
        CartRequestMerge.MergeRunnable access$getMergeRunnable$p = this.this$0.f40023f;
        Function2<T, CartMergeModel, Unit> function22 = this.$block;
        access$getMergeRunnable$p.setResult(t2);
        access$getMergeRunnable$p.setBlock(function22);
        Unit unit = Unit.INSTANCE;
        UIHandler.postDelayed(access$getMERGE_INTERVAL$cp, access$getMergeRunnable$p);
    }
}
