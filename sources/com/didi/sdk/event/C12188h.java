package com.didi.sdk.event;

/* renamed from: com.didi.sdk.event.h */
/* compiled from: Subscription */
final class C12188h {

    /* renamed from: a */
    final Object f35877a;

    /* renamed from: b */
    final C12186f f35878b;

    /* renamed from: c */
    final int f35879c;

    /* renamed from: d */
    volatile boolean f35880d = true;

    C12188h(Object obj, C12186f fVar, int i) {
        this.f35877a = obj;
        this.f35878b = fVar;
        this.f35879c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C12188h)) {
            return false;
        }
        C12188h hVar = (C12188h) obj;
        if (this.f35877a != hVar.f35877a || !this.f35878b.equals(hVar.f35878b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f35877a.hashCode() + this.f35878b.f35873d.hashCode();
    }
}
