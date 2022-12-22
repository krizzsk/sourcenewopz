package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ak */
final class C18436ak extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ C18442aq f53134a;

    C18436ak(C18442aq aqVar) {
        this.f53134a = aqVar;
    }

    /* renamed from: a */
    public final void mo148807a() {
        if (this.f53134a.f53150l != null) {
            this.f53134a.f53141c.mo149084c("Unbind from service.", new Object[0]);
            this.f53134a.f53140b.unbindService(this.f53134a.f53149k);
            this.f53134a.f53144f = false;
            this.f53134a.f53150l = null;
            this.f53134a.f53149k = null;
        }
    }
}
