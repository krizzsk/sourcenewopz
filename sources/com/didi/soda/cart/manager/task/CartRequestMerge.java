package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  *\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002 !BS\u0012$\u0010\u0003\u001a \u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0006\u0012&\u0010\u0007\u001a\"\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\b¢\u0006\u0002\u0010\tJ<\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u00002'\u0010\u001b\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f0\u0011R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u000e¢\u0006\u0002\n\u0000R/\u0010\u0003\u001a \u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\"\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestMerge;", "T", "", "predicate", "Lkotlin/Function2;", "", "Lcom/didi/soda/cart/manager/task/MergePredicate;", "runMerge", "Lcom/didi/soda/cart/manager/task/RunMerge;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "count", "", "isWaitMerge", "()Z", "mergeModel", "Lcom/didi/soda/cart/manager/task/CartMergeModel;", "mergeRunnable", "Lcom/didi/soda/cart/manager/task/CartRequestMerge$MergeRunnable;", "getPredicate", "()Lkotlin/jvm/functions/Function2;", "reset", "Ljava/lang/Runnable;", "waitParam", "Ljava/lang/Object;", "merge", "", "params", "block", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "resetMergeCount", "Companion", "MergeRunnable", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
public final class CartRequestMerge<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final long f40017h = ((long) CustomerApolloUtil.getAddCartDelayTime());

    /* renamed from: a */
    private final Function2<T, T, Boolean> f40018a;

    /* renamed from: b */
    private final Function2<T, T, T> f40019b;

    /* renamed from: c */
    private int f40020c;

    /* renamed from: d */
    private final Runnable f40021d = new Runnable() {
        public final void run() {
            CartRequestMerge.m28521a(CartRequestMerge.this);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f40022e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CartRequestMerge<T>.MergeRunnable f40023f = new MergeRunnable(this);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final CartMergeModel f40024g = new CartMergeModel(0, 0, 3, (DefaultConstructorMarker) null);

    public CartRequestMerge(Function2<? super T, ? super T, Boolean> function2, Function2<? super T, ? super T, ? extends T> function22) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Intrinsics.checkNotNullParameter(function22, "runMerge");
        this.f40018a = function2;
        this.f40019b = function22;
    }

    public final Function2<T, T, Boolean> getPredicate() {
        return this.f40018a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28521a(CartRequestMerge cartRequestMerge) {
        Intrinsics.checkNotNullParameter(cartRequestMerge, "this$0");
        cartRequestMerge.f40020c = 0;
    }

    public final boolean isWaitMerge() {
        return this.f40022e != null;
    }

    public final void merge(T t, Function2<? super T, ? super CartMergeModel, Unit> function2) {
        Intrinsics.checkNotNullParameter(t, "params");
        Intrinsics.checkNotNullParameter(function2, "block");
        this.f40024g.recordMerge();
        if (this.f40020c > 0) {
            boolean booleanValue = this.f40018a.invoke(this.f40022e, t).booleanValue();
            Function2 cartRequestMerge$merge$runNoMerge$1 = new CartRequestMerge$merge$runNoMerge$1(this, function2);
            if (booleanValue) {
                T invoke = this.f40019b.invoke(this.f40022e, t);
                if (invoke != null) {
                    this.f40024g.getTimeList().add(Long.valueOf(System.currentTimeMillis()));
                    this.f40022e = invoke;
                    UIHandler.removeCallbacks(this.f40023f);
                    long j = f40017h;
                    CartRequestMerge<T>.MergeRunnable mergeRunnable = this.f40023f;
                    mergeRunnable.setResult(invoke);
                    mergeRunnable.setBlock(function2);
                    Unit unit = Unit.INSTANCE;
                    UIHandler.postDelayed(j, mergeRunnable);
                } else {
                    cartRequestMerge$merge$runNoMerge$1.invoke(this.f40022e, t);
                }
            } else {
                cartRequestMerge$merge$runNoMerge$1.invoke(this.f40022e, t);
            }
        } else {
            function2.invoke(t, this.f40024g);
            this.f40024g.clearMergeRecord();
        }
        this.f40020c++;
        m28520a();
    }

    /* renamed from: a */
    private final void m28520a() {
        UIHandler.removeCallbacks(this.f40021d);
        UIHandler.postDelayed(f40017h, this.f40021d);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016R;\u0010\u0003\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestMerge$MergeRunnable;", "Ljava/lang/Runnable;", "(Lcom/didi/soda/cart/manager/task/CartRequestMerge;)V", "block", "Lkotlin/Function2;", "Lcom/didi/soda/cart/manager/task/CartMergeModel;", "Lkotlin/ParameterName;", "name", "mergeModel", "", "getBlock", "()Lkotlin/jvm/functions/Function2;", "setBlock", "(Lkotlin/jvm/functions/Function2;)V", "result", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "run", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartRequestMerge.kt */
    public final class MergeRunnable implements Runnable {
        public Function2<? super T, ? super CartMergeModel, Unit> block;
        public T result;
        final /* synthetic */ CartRequestMerge<T> this$0;

        public MergeRunnable(CartRequestMerge cartRequestMerge) {
            Intrinsics.checkNotNullParameter(cartRequestMerge, "this$0");
            this.this$0 = cartRequestMerge;
        }

        public final T getResult() {
            T t = this.result;
            if (t != null) {
                return t;
            }
            Intrinsics.throwUninitializedPropertyAccessException("result");
            return Unit.INSTANCE;
        }

        public final void setResult(T t) {
            Intrinsics.checkNotNullParameter(t, "<set-?>");
            this.result = t;
        }

        public final Function2<T, CartMergeModel, Unit> getBlock() {
            Function2<? super T, ? super CartMergeModel, Unit> function2 = this.block;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("block");
            return null;
        }

        public final void setBlock(Function2<? super T, ? super CartMergeModel, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.block = function2;
        }

        public void run() {
            getBlock().invoke(getResult(), this.this$0.f40024g);
            this.this$0.f40022e = null;
            this.this$0.f40024g.clearMergeRecord();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartRequestMerge$Companion;", "", "()V", "MERGE_INTERVAL", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartRequestMerge.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
