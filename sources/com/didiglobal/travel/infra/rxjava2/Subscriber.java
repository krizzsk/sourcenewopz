package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/rxjava2/Subscriber;", "", "()V", "onErrorAction", "Lkotlin/Function1;", "", "", "getOnErrorAction$lib_rxjava2_release", "()Lkotlin/jvm/functions/Function1;", "setOnErrorAction$lib_rxjava2_release", "(Lkotlin/jvm/functions/Function1;)V", "onError", "action", "Lcom/didiglobal/travel/infra/rxjava2/CompletableSubscribe;", "Lcom/didiglobal/travel/infra/rxjava2/ObservableSubscribe;", "Lcom/didiglobal/travel/infra/rxjava2/FlowableSubscribe;", "Lcom/didiglobal/travel/infra/rxjava2/SingleSubscribe;", "lib-rxjava2_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
public abstract class Subscriber {

    /* renamed from: a */
    private Function1<? super Throwable, Unit> f51437a;

    private Subscriber() {
    }

    public /* synthetic */ Subscriber(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Function1<Throwable, Unit> getOnErrorAction$lib_rxjava2_release() {
        return this.f51437a;
    }

    public final void setOnErrorAction$lib_rxjava2_release(Function1<? super Throwable, Unit> function1) {
        this.f51437a = function1;
    }

    public final void onError(Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "action");
        this.f51437a = function1;
    }
}
