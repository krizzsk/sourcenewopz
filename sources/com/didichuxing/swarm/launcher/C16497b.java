package com.didichuxing.swarm.launcher;

import org.osgi.framework.Bundle;

/* renamed from: com.didichuxing.swarm.launcher.b */
/* compiled from: BundleInfo */
class C16497b {

    /* renamed from: a */
    private final Bundle f49194a;

    /* renamed from: b */
    private boolean f49195b;

    public C16497b(Bundle bundle) {
        this.f49194a = bundle;
    }

    /* renamed from: a */
    public boolean mo121206a() {
        return this.f49195b;
    }

    /* renamed from: a */
    public synchronized void mo121205a(boolean z) {
        this.f49195b = z;
    }

    /* renamed from: b */
    public Bundle mo121207b() {
        return this.f49194a;
    }
}
