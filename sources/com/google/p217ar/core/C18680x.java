package com.google.p217ar.core;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.ar.core.x */
/* compiled from: InstallServiceImpl */
final class C18680x implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicBoolean f53574a;

    /* renamed from: b */
    private final /* synthetic */ C18678v f53575b;

    C18680x(C18678v vVar, AtomicBoolean atomicBoolean) {
        this.f53575b = vVar;
        this.f53574a = atomicBoolean;
    }

    public final void run() {
        if (!this.f53574a.getAndSet(true)) {
            SystemUtils.log(5, "ARCore-InstallService", "requestInstall timed out, launching fullscreen.", (Throwable) null, "com.google.ar.core.x", 3);
            C18673p.m38311b(this.f53575b.f53569a, this.f53575b.f53570b);
        }
    }
}
