package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.internal.ah */
public abstract class C18433ah implements Runnable {

    /* renamed from: a */
    private final C18619i<?> f53130a;

    C18433ah() {
        this.f53130a = null;
    }

    public C18433ah(C18619i<?> iVar) {
        this.f53130a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo148807a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C18619i<?> mo149086b() {
        return this.f53130a;
    }

    public final void run() {
        try {
            mo148807a();
        } catch (Exception e) {
            C18619i<?> iVar = this.f53130a;
            if (iVar != null) {
                iVar.mo149341b(e);
            }
        }
    }
}
