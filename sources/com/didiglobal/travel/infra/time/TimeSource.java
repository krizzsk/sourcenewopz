package com.didiglobal.travel.infra.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/time/TimeSource;", "", "()V", "outerTimeSource", "Lkotlin/Function0;", "", "currentTimeMillis", "setCustomTimeSource", "", "provider", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TimeSource.kt */
public final class TimeSource {
    public static final TimeSource INSTANCE = new TimeSource();

    /* renamed from: a */
    private static Function0<Long> f51447a;

    private TimeSource() {
    }

    public final void setCustomTimeSource(Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "provider");
        f51447a = function0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long currentTimeMillis() {
        /*
            r2 = this;
            kotlin.jvm.functions.Function0<java.lang.Long> r0 = f51447a
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.invoke()
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L_0x0011
            long r0 = r0.longValue()
            goto L_0x0015
        L_0x0011:
            long r0 = java.lang.System.currentTimeMillis()
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.time.TimeSource.currentTimeMillis():long");
    }
}
