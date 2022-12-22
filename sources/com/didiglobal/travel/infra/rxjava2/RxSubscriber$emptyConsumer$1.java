package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
final class RxSubscriber$emptyConsumer$1 extends Lambda implements Function1<Object, Unit> {
    public static final RxSubscriber$emptyConsumer$1 INSTANCE = new RxSubscriber$emptyConsumer$1();

    RxSubscriber$emptyConsumer$1() {
        super(1);
    }

    public final void invoke(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
    }
}
