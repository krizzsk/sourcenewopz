package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/rxjava2/SingleSubscribe;", "T", "Lcom/didiglobal/travel/infra/rxjava2/Subscriber;", "()V", "onSuccessAction", "Lkotlin/Function1;", "", "getOnSuccessAction$lib_rxjava2_release", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessAction$lib_rxjava2_release", "(Lkotlin/jvm/functions/Function1;)V", "onSuccess", "action", "lib-rxjava2_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
public class SingleSubscribe<T> extends Subscriber {

    /* renamed from: a */
    private Function1<? super T, Unit> f51436a;

    public SingleSubscribe() {
        super((DefaultConstructorMarker) null);
    }

    public final Function1<T, Unit> getOnSuccessAction$lib_rxjava2_release() {
        return this.f51436a;
    }

    public final void setOnSuccessAction$lib_rxjava2_release(Function1<? super T, Unit> function1) {
        this.f51436a = function1;
    }

    public final void onSuccess(Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "action");
        this.f51436a = function1;
    }
}
