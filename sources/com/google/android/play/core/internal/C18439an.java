package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.an */
final class C18439an extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ IBinder f53135a;

    /* renamed from: b */
    final /* synthetic */ C18441ap f53136b;

    C18439an(C18441ap apVar, IBinder iBinder) {
        this.f53136b = apVar;
        this.f53135a = iBinder;
    }

    /* renamed from: a */
    public final void mo148807a() {
        C18442aq aqVar = this.f53136b.f53138a;
        aqVar.f53150l = (IInterface) aqVar.f53146h.mo148806a(this.f53135a);
        C18442aq.m37776f(this.f53136b.f53138a);
        this.f53136b.f53138a.f53144f = false;
        for (Runnable run : this.f53136b.f53138a.f53143e) {
            run.run();
        }
        this.f53136b.f53138a.f53143e.clear();
    }
}
