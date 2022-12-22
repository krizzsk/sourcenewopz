package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.splitinstall.aj */
final class C18558aj extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ int f53291a;

    /* renamed from: b */
    final /* synthetic */ C18619i f53292b;

    /* renamed from: c */
    final /* synthetic */ C18570av f53293c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18558aj(C18570av avVar, C18619i iVar, int i, C18619i iVar2) {
        super(iVar);
        this.f53293c = avVar;
        this.f53291a = i;
        this.f53292b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53293c.f53303a.mo149094b().mo149113a(this.f53293c.f53304d, this.f53291a, new C18566ar(this.f53293c, this.f53292b));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "getSessionState(%d)", Integer.valueOf(this.f53291a));
            this.f53292b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
