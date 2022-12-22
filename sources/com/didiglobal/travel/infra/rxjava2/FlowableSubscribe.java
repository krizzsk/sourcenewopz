package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Subscription;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0015\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001a\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\fJ\u001a\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0019"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/rxjava2/FlowableSubscribe;", "T", "Lcom/didiglobal/travel/infra/rxjava2/Subscriber;", "()V", "onCompleteAction", "Lkotlin/Function0;", "", "getOnCompleteAction$lib_rxjava2_release", "()Lkotlin/jvm/functions/Function0;", "setOnCompleteAction$lib_rxjava2_release", "(Lkotlin/jvm/functions/Function0;)V", "onNextAction", "Lkotlin/Function1;", "getOnNextAction$lib_rxjava2_release", "()Lkotlin/jvm/functions/Function1;", "setOnNextAction$lib_rxjava2_release", "(Lkotlin/jvm/functions/Function1;)V", "onSubscribeAction", "Lorg/reactivestreams/Subscription;", "getOnSubscribeAction$lib_rxjava2_release", "setOnSubscribeAction$lib_rxjava2_release", "onComplete", "action", "onNext", "onSubscribe", "lib-rxjava2_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
public final class FlowableSubscribe<T> extends Subscriber {

    /* renamed from: a */
    private Function1<? super T, Unit> f51427a;

    /* renamed from: b */
    private Function0<Unit> f51428b;

    /* renamed from: c */
    private Function1<? super Subscription, Unit> f51429c;

    public FlowableSubscribe() {
        super((DefaultConstructorMarker) null);
    }

    public final Function1<T, Unit> getOnNextAction$lib_rxjava2_release() {
        return this.f51427a;
    }

    public final void setOnNextAction$lib_rxjava2_release(Function1<? super T, Unit> function1) {
        this.f51427a = function1;
    }

    public final Function0<Unit> getOnCompleteAction$lib_rxjava2_release() {
        return this.f51428b;
    }

    public final void setOnCompleteAction$lib_rxjava2_release(Function0<Unit> function0) {
        this.f51428b = function0;
    }

    public final Function1<Subscription, Unit> getOnSubscribeAction$lib_rxjava2_release() {
        return this.f51429c;
    }

    public final void setOnSubscribeAction$lib_rxjava2_release(Function1<? super Subscription, Unit> function1) {
        this.f51429c = function1;
    }

    public final void onNext(Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "action");
        this.f51427a = function1;
    }

    public final void onComplete(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "action");
        this.f51428b = function0;
    }

    public final void onSubscribe(Function1<? super Subscription, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "action");
        this.f51429c = function1;
    }
}
