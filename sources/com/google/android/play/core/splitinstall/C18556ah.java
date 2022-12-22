package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ah */
final class C18556ah extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f53285a;

    /* renamed from: b */
    final /* synthetic */ C18619i f53286b;

    /* renamed from: c */
    final /* synthetic */ C18570av f53287c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18556ah(C18570av avVar, C18619i iVar, List list, C18619i iVar2) {
        super(iVar);
        this.f53287c = avVar;
        this.f53285a = list;
        this.f53286b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53287c.f53303a.mo149094b().mo149118d(this.f53287c.f53304d, C18570av.m38124b((Collection) this.f53285a), C18570av.m38123b(), new C18563ao(this.f53287c, this.f53286b));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "deferredLanguageInstall(%s)", this.f53285a);
            this.f53286b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
