package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u0006H\u0000\u001a\u001f\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u0006\"\b\b\u0000\u0010\f*\u00020\u0007H\b\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\" \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, mo175978d2 = {"emptyCompleteAction", "Lkotlin/Function0;", "", "getEmptyCompleteAction", "()Lkotlin/jvm/functions/Function0;", "emptyConsumer", "Lkotlin/Function1;", "", "getEmptyConsumer", "()Lkotlin/jvm/functions/Function1;", "defaultErrorHandler", "", "T", "lib-rxjava2_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
public final class RxSubscriber {

    /* renamed from: a */
    private static final Function0<Unit> f51434a = RxSubscriber$emptyCompleteAction$1.INSTANCE;

    /* renamed from: b */
    private static final Function1<Object, Unit> f51435b = RxSubscriber$emptyConsumer$1.INSTANCE;

    public static final Function1<Throwable, Unit> defaultErrorHandler() {
        return RxSubscriber$defaultErrorHandler$1.INSTANCE;
    }

    public static final Function0<Unit> getEmptyCompleteAction() {
        return f51434a;
    }

    public static final Function1<Object, Unit> getEmptyConsumer() {
        return f51435b;
    }

    public static final <T> Function1<T, Unit> emptyConsumer() {
        return getEmptyConsumer();
    }
}
