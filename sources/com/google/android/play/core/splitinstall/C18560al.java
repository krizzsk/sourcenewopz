package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18476bx;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.splitinstall.al */
final class C18560al extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ int f53296a;

    /* renamed from: b */
    final /* synthetic */ C18619i f53297b;

    /* renamed from: c */
    final /* synthetic */ C18570av f53298c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18560al(C18570av avVar, C18619i iVar, int i, C18619i iVar2) {
        super(iVar);
        this.f53298c = avVar;
        this.f53296a = i;
        this.f53297b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53298c.f53303a.mo149094b().mo149112a(this.f53298c.f53304d, this.f53296a, C18570av.m38123b(), (C18476bx) new C18561am(this.f53298c, this.f53297b));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "cancelInstall(%d)", Integer.valueOf(this.f53296a));
            this.f53297b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
