package com.didiglobal.travel.infra.rxjava2;

import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: Subscriber.kt */
final class RxSubscriber$defaultErrorHandler$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final RxSubscriber$defaultErrorHandler$1 INSTANCE = new RxSubscriber$defaultErrorHandler$1();

    RxSubscriber$defaultErrorHandler$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        StringBuilder sb = new StringBuilder();
        sb.append("defaultErrorHandler: ");
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        SystemUtils.log(3, "RxSubscriber", sb.toString(), th, "com.didiglobal.travel.infra.rxjava2.RxSubscriber$defaultErrorHandler$1", 101);
    }
}
