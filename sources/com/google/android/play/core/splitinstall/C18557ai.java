package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ai */
final class C18557ai extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f53288a;

    /* renamed from: b */
    final /* synthetic */ C18619i f53289b;

    /* renamed from: c */
    final /* synthetic */ C18570av f53290c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18557ai(C18570av avVar, C18619i iVar, List list, C18619i iVar2) {
        super(iVar);
        this.f53290c = avVar;
        this.f53288a = list;
        this.f53289b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53290c.f53303a.mo149094b().mo149119e(this.f53290c.f53304d, C18570av.m38124b((Collection) this.f53288a), C18570av.m38123b(), new C18564ap(this.f53290c, this.f53289b));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "deferredLanguageUninstall(%s)", this.f53288a);
            this.f53289b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
