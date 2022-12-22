package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.reactivex.Maybe;
import p242io.reactivex.android.schedulers.AndroidSchedulers;
import p242io.reactivex.schedulers.Schedulers;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a5\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\f"}, mo175978d2 = {"fromIoToMain", "Lio/reactivex/Maybe;", "T", "observeOnMain", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/rxjava2/MaybeSubscribe;", "", "Lkotlin/ExtensionFunctionType;", "subscribeOnIo", "lib-rxjava2_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Maybe.kt */
public final class MaybeKt {
    /* JADX WARNING: type inference failed for: r2v0, types: [com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Action$0] */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> p242io.reactivex.disposables.Disposable subscribeBy(p242io.reactivex.Maybe<T> r3, kotlin.jvm.functions.Function1<? super com.didiglobal.travel.infra.rxjava2.MaybeSubscribe<T>, kotlin.Unit> r4) {
        /*
            java.lang.String r0 = "$this$subscribeBy"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "supplier"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            com.didiglobal.travel.infra.rxjava2.MaybeSubscribe r0 = new com.didiglobal.travel.infra.rxjava2.MaybeSubscribe
            r0.<init>()
            r4.invoke(r0)
            kotlin.jvm.functions.Function1 r4 = r0.getOnSuccessAction$lib_rxjava2_release()
            if (r4 == 0) goto L_0x0053
            com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Consumer$0 r1 = new com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Consumer$0
            r1.<init>(r4)
            io.reactivex.functions.Consumer r1 = (p242io.reactivex.functions.Consumer) r1
            kotlin.jvm.functions.Function1 r4 = r0.getOnErrorAction$lib_rxjava2_release()
            if (r4 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            kotlin.jvm.functions.Function1 r4 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.defaultErrorHandler()
        L_0x002a:
            if (r4 == 0) goto L_0x0032
            com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Consumer$0 r2 = new com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Consumer$0
            r2.<init>(r4)
            r4 = r2
        L_0x0032:
            io.reactivex.functions.Consumer r4 = (p242io.reactivex.functions.Consumer) r4
            kotlin.jvm.functions.Function0 r0 = r0.getOnCompleteAction$lib_rxjava2_release()
            if (r0 == 0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            kotlin.jvm.functions.Function0 r0 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.getEmptyCompleteAction()
        L_0x003f:
            if (r0 == 0) goto L_0x0047
            com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Action$0 r2 = new com.didiglobal.travel.infra.rxjava2.MaybeKt$sam$io_reactivex_functions_Action$0
            r2.<init>(r0)
            r0 = r2
        L_0x0047:
            io.reactivex.functions.Action r0 = (p242io.reactivex.functions.Action) r0
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r1, r4, r0)
            java.lang.String r4 = "this.subscribe(\n        …emptyCompleteAction\n    )"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            return r3
        L_0x0053:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Must provide onSuccess consumer."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.rxjava2.MaybeKt.subscribeBy(io.reactivex.Maybe, kotlin.jvm.functions.Function1):io.reactivex.disposables.Disposable");
    }

    public static final <T> Maybe<T> subscribeOnIo(Maybe<T> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$subscribeOnIo");
        Maybe<T> subscribeOn = maybe.subscribeOn(Schedulers.m41911io());
        Intrinsics.checkExpressionValueIsNotNull(subscribeOn, "this.subscribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public static final <T> Maybe<T> observeOnMain(Maybe<T> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$observeOnMain");
        Maybe<T> observeOn = maybe.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.observeOn(AndroidSchedulers.mainThread())");
        return observeOn;
    }

    public static final <T> Maybe<T> fromIoToMain(Maybe<T> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$fromIoToMain");
        Maybe<T> observeOn = maybe.subscribeOn(Schedulers.m41911io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.subscribeOn(Schedul…dSchedulers.mainThread())");
        return observeOn;
    }
}
