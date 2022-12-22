package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.reactivex.Single;
import p242io.reactivex.android.schedulers.AndroidSchedulers;
import p242io.reactivex.schedulers.Schedulers;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a5\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\f"}, mo175978d2 = {"fromIoToMain", "Lio/reactivex/Single;", "T", "observeOnMain", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/rxjava2/SingleSubscribe;", "", "Lkotlin/ExtensionFunctionType;", "subscribeOnIo", "lib-rxjava2_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Single.kt */
public final class SingleKt {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.didiglobal.travel.infra.rxjava2.SingleKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> p242io.reactivex.disposables.Disposable subscribeBy(p242io.reactivex.Single<T> r2, kotlin.jvm.functions.Function1<? super com.didiglobal.travel.infra.rxjava2.SingleSubscribe<T>, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeBy"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "supplier"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            com.didiglobal.travel.infra.rxjava2.SingleSubscribe r0 = new com.didiglobal.travel.infra.rxjava2.SingleSubscribe
            r0.<init>()
            r3.invoke(r0)
            kotlin.jvm.functions.Function1 r3 = r0.getOnSuccessAction$lib_rxjava2_release()
            if (r3 == 0) goto L_0x003e
            com.didiglobal.travel.infra.rxjava2.SingleKt$sam$io_reactivex_functions_Consumer$0 r1 = new com.didiglobal.travel.infra.rxjava2.SingleKt$sam$io_reactivex_functions_Consumer$0
            r1.<init>(r3)
            io.reactivex.functions.Consumer r1 = (p242io.reactivex.functions.Consumer) r1
            kotlin.jvm.functions.Function1 r3 = r0.getOnErrorAction$lib_rxjava2_release()
            if (r3 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            kotlin.jvm.functions.Function1 r3 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.defaultErrorHandler()
        L_0x002a:
            if (r3 == 0) goto L_0x0032
            com.didiglobal.travel.infra.rxjava2.SingleKt$sam$io_reactivex_functions_Consumer$0 r0 = new com.didiglobal.travel.infra.rxjava2.SingleKt$sam$io_reactivex_functions_Consumer$0
            r0.<init>(r3)
            r3 = r0
        L_0x0032:
            io.reactivex.functions.Consumer r3 = (p242io.reactivex.functions.Consumer) r3
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r1, r3)
            java.lang.String r3 = "this.subscribe(\n        …faultErrorHandler()\n    )"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        L_0x003e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Must provide onSuccess consumer."
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.rxjava2.SingleKt.subscribeBy(io.reactivex.Single, kotlin.jvm.functions.Function1):io.reactivex.disposables.Disposable");
    }

    public static final <T> Single<T> subscribeOnIo(Single<T> single) {
        Intrinsics.checkParameterIsNotNull(single, "$this$subscribeOnIo");
        Single<T> subscribeOn = single.subscribeOn(Schedulers.m41911io());
        Intrinsics.checkExpressionValueIsNotNull(subscribeOn, "this.subscribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public static final <T> Single<T> observeOnMain(Single<T> single) {
        Intrinsics.checkParameterIsNotNull(single, "$this$observeOnMain");
        Single<T> observeOn = single.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.observeOn(AndroidSchedulers.mainThread())");
        return observeOn;
    }

    public static final <T> Single<T> fromIoToMain(Single<T> single) {
        Intrinsics.checkParameterIsNotNull(single, "$this$fromIoToMain");
        Single<T> observeOn = single.subscribeOn(Schedulers.m41911io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.subscribeOn(Schedul…dSchedulers.mainThread())");
        return observeOn;
    }
}
