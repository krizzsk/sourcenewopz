package com.ddmap.sdk.degrade;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/CrashMonitorImpl;", "Lcom/ddmap/sdk/degrade/ICrashMonitor;", "()V", "sHasInitialize", "", "start", "", "listener", "Lcom/ddmap/sdk/degrade/ICrashListener;", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CrashMonitorImpl.kt */
public final class CrashMonitorImpl implements ICrashMonitor {

    /* renamed from: a */
    private boolean f4276a;

    public void start(ICrashListener iCrashListener) {
        Intrinsics.checkParameterIsNotNull(iCrashListener, "listener");
        if (!this.f4276a) {
            Thread.setDefaultUncaughtExceptionHandler(new DegradeUncaughtExceptionHandler(iCrashListener));
            this.f4276a = true;
        }
    }
}
