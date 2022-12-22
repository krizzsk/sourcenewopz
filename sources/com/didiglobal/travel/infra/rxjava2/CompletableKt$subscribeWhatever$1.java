package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "Lcom/didiglobal/travel/infra/rxjava2/CompletableSubscribe;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: Completable.kt */
final class CompletableKt$subscribeWhatever$1 extends Lambda implements Function1<CompletableSubscribe, Unit> {
    final /* synthetic */ Function1 $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompletableKt$subscribeWhatever$1(Function1 function1) {
        super(1);
        this.$onError = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CompletableSubscribe) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CompletableSubscribe completableSubscribe) {
        Intrinsics.checkParameterIsNotNull(completableSubscribe, "$receiver");
        completableSubscribe.onComplete(RxSubscriber.getEmptyCompleteAction());
        Function1<Throwable, Unit> function1 = this.$onError;
        if (function1 == null) {
            function1 = RxSubscriber.defaultErrorHandler();
        }
        completableSubscribe.onError(function1);
    }
}
