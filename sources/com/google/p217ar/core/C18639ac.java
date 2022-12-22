package com.google.p217ar.core;

import com.google.p217ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.ar.core.ac */
/* compiled from: Session */
class C18639ac implements ArCoreApk.C18625a {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f53503a;

    C18639ac(AtomicReference atomicReference) {
        this.f53503a = atomicReference;
    }

    /* renamed from: a */
    public void mo149385a(ArCoreApk.Availability availability) {
        this.f53503a.set(availability);
    }
}
