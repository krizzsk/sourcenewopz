package com.google.p217ar.core;

import android.content.Context;

/* renamed from: com.google.ar.core.z */
/* compiled from: InstallServiceImpl */
final class C18682z extends Thread {

    /* renamed from: a */
    private final Context f53578a;

    /* renamed from: b */
    private final C18675s f53579b;

    /* renamed from: c */
    private volatile boolean f53580c;

    C18682z(Context context, C18675s sVar) {
        this.f53578a = context;
        this.f53579b = sVar;
    }

    public final void run() {
        while (!this.f53580c) {
            if (C18665h.m38292a().mo149635b(this.f53578a)) {
                this.f53579b.mo149646a(C18672o.COMPLETED);
                return;
            }
            try {
                sleep(200);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149652a() {
        this.f53580c = true;
    }
}
