package com.didiglobal.ibg_rpc_service.internal;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/Executors;", "", "()V", "handler", "Landroid/os/Handler;", "runOnMain", "", "runnable", "Ljava/lang/Runnable;", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Executors.kt */
public final class Executors {
    public static final Executors INSTANCE = new Executors();

    /* renamed from: a */
    private static final Handler f50242a = new Handler(Looper.getMainLooper());

    private Executors() {
    }

    public final void runOnMain(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
            runnable.run();
        } else {
            f50242a.post(runnable);
        }
    }
}
