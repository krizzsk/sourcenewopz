package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.splitinstall.ak */
final class C18559ak extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ C18619i f53294a;

    /* renamed from: b */
    final /* synthetic */ C18570av f53295b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18559ak(C18570av avVar, C18619i iVar, C18619i iVar2) {
        super(iVar);
        this.f53295b = avVar;
        this.f53294a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53295b.f53303a.mo149094b().mo149114a(this.f53295b.f53304d, new C18567as(this.f53295b, this.f53294a));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "getSessionStates", new Object[0]);
            this.f53294a.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
