package com.didiglobal.travel.biz.callback;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0018\u001a\u00020\u00072\u001a\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\u0014\u0010\u001a\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u001a\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0013R0\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, mo175978d2 = {"Lcom/didiglobal/travel/biz/callback/LoadCallbackWrapper;", "T", "", "()V", "onErrorAction", "Lkotlin/Function2;", "", "", "getOnErrorAction", "()Lkotlin/jvm/functions/Function2;", "setOnErrorAction", "(Lkotlin/jvm/functions/Function2;)V", "onFinishAction", "Lkotlin/Function0;", "getOnFinishAction", "()Lkotlin/jvm/functions/Function0;", "setOnFinishAction", "(Lkotlin/jvm/functions/Function0;)V", "onSuccessAction", "Lkotlin/Function1;", "getOnSuccessAction", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessAction", "(Lkotlin/jvm/functions/Function1;)V", "onError", "action", "onFinish", "onSuccess", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoadCallbackWrapper.kt */
public final class LoadCallbackWrapper<T> {

    /* renamed from: a */
    private Function1<? super T, Unit> f51410a;

    /* renamed from: b */
    private Function2<? super T, ? super Throwable, Unit> f51411b;

    /* renamed from: c */
    private Function0<Unit> f51412c;

    public final Function1<T, Unit> getOnSuccessAction() {
        return this.f51410a;
    }

    public final void setOnSuccessAction(Function1<? super T, Unit> function1) {
        this.f51410a = function1;
    }

    public final Function2<T, Throwable, Unit> getOnErrorAction() {
        return this.f51411b;
    }

    public final void setOnErrorAction(Function2<? super T, ? super Throwable, Unit> function2) {
        this.f51411b = function2;
    }

    public final Function0<Unit> getOnFinishAction() {
        return this.f51412c;
    }

    public final void setOnFinishAction(Function0<Unit> function0) {
        this.f51412c = function0;
    }

    public final void onSuccess(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.f51410a = function1;
    }

    public final void onError(Function2<? super T, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.f51411b = function2;
    }

    public final void onFinish(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.f51412c = function0;
    }
}
