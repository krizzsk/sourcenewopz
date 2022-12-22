package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ag */
final class C18555ag extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f53282a;

    /* renamed from: b */
    final /* synthetic */ C18619i f53283b;

    /* renamed from: c */
    final /* synthetic */ C18570av f53284c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18555ag(C18570av avVar, C18619i iVar, List list, C18619i iVar2) {
        super(iVar);
        this.f53284c = avVar;
        this.f53282a = list;
        this.f53283b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53284c.f53303a.mo149094b().mo149117c(this.f53284c.f53304d, C18570av.m38122a((Collection) this.f53282a), C18570av.m38123b(), new C18562an(this.f53284c, this.f53283b));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "deferredInstall(%s)", this.f53282a);
            this.f53283b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
