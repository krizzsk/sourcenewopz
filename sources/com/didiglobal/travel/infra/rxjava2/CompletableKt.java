package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p242io.reactivex.Completable;
import p242io.reactivex.android.schedulers.AndroidSchedulers;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.schedulers.Schedulers;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a#\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\"\u0010\u000b\u001a\u00020\u0004*\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¨\u0006\u000e"}, mo175978d2 = {"fromIoToMain", "Lio/reactivex/Completable;", "observeOnMain", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/rxjava2/CompletableSubscribe;", "", "Lkotlin/ExtensionFunctionType;", "subscribeOnIo", "subscribeWhatever", "onError", "", "lib-rxjava2_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Completable.kt */
public final class CompletableKt {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.didiglobal.travel.infra.rxjava2.CompletableKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final p242io.reactivex.disposables.Disposable subscribeBy(p242io.reactivex.Completable r2, kotlin.jvm.functions.Function1<? super com.didiglobal.travel.infra.rxjava2.CompletableSubscribe, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeBy"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "supplier"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            com.didiglobal.travel.infra.rxjava2.CompletableSubscribe r0 = new com.didiglobal.travel.infra.rxjava2.CompletableSubscribe
            r0.<init>()
            r3.invoke(r0)
            kotlin.jvm.functions.Function0 r3 = r0.getOnCompleteAction$lib_rxjava2_release()
            if (r3 == 0) goto L_0x0040
            com.didiglobal.travel.infra.rxjava2.CompletableKt$sam$io_reactivex_functions_Action$0 r1 = new com.didiglobal.travel.infra.rxjava2.CompletableKt$sam$io_reactivex_functions_Action$0
            r1.<init>(r3)
            io.reactivex.functions.Action r1 = (p242io.reactivex.functions.Action) r1
            kotlin.jvm.functions.Function1 r3 = r0.getOnErrorAction$lib_rxjava2_release()
            if (r3 == 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            kotlin.jvm.functions.Function1 r3 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.defaultErrorHandler()
        L_0x002b:
            if (r3 == 0) goto L_0x0033
            com.didiglobal.travel.infra.rxjava2.CompletableKt$sam$io_reactivex_functions_Consumer$0 r0 = new com.didiglobal.travel.infra.rxjava2.CompletableKt$sam$io_reactivex_functions_Consumer$0
            r0.<init>(r3)
            r3 = r0
        L_0x0033:
            io.reactivex.functions.Consumer r3 = (p242io.reactivex.functions.Consumer) r3
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r1, r3)
            java.lang.String r3 = "this.subscribe(\n        …faultErrorHandler()\n    )"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        L_0x0040:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Must provide onComplete action."
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.rxjava2.CompletableKt.subscribeBy(io.reactivex.Completable, kotlin.jvm.functions.Function1):io.reactivex.disposables.Disposable");
    }

    public static /* synthetic */ Disposable subscribeWhatever$default(Completable completable, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return subscribeWhatever(completable, function1);
    }

    public static final Disposable subscribeWhatever(Completable completable, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(completable, "$this$subscribeWhatever");
        return subscribeBy(completable, new CompletableKt$subscribeWhatever$1(function1));
    }

    public static final Completable subscribeOnIo(Completable completable) {
        Intrinsics.checkParameterIsNotNull(completable, "$this$subscribeOnIo");
        Completable subscribeOn = completable.subscribeOn(Schedulers.m41911io());
        Intrinsics.checkExpressionValueIsNotNull(subscribeOn, "this.subscribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public static final Completable observeOnMain(Completable completable) {
        Intrinsics.checkParameterIsNotNull(completable, "$this$observeOnMain");
        Completable observeOn = completable.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.observeOn(AndroidSchedulers.mainThread())");
        return observeOn;
    }

    public static final Completable fromIoToMain(Completable completable) {
        Intrinsics.checkParameterIsNotNull(completable, "$this$fromIoToMain");
        Completable observeOn = completable.subscribeOn(Schedulers.m41911io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.subscribeOn(Schedul…dSchedulers.mainThread())");
        return observeOn;
    }
}
