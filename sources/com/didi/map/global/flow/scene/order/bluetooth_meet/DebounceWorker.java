package com.didi.map.global.flow.scene.order.bluetooth_meet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/DebounceWorker;", "", "()V", "INTERVAL", "", "lastHitTimeStamp", "summit", "", "job", "Lkotlin/Function0;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMUtils.kt */
public final class DebounceWorker {
    public static final DebounceWorker INSTANCE = new DebounceWorker();

    /* renamed from: a */
    private static final long f26451a = 3000;

    /* renamed from: b */
    private static long f26452b;

    private DebounceWorker() {
    }

    public final void summit(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "job");
        if (System.currentTimeMillis() - f26452b > f26451a) {
            f26452b = System.currentTimeMillis();
            function0.invoke();
        }
    }
}
