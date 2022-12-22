package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.appupdate.l */
final class C18276l extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ C18619i f52636a;

    /* renamed from: b */
    final /* synthetic */ String f52637b;

    /* renamed from: c */
    final /* synthetic */ C18280p f52638c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18276l(C18280p pVar, C18619i iVar, C18619i iVar2, String str) {
        super(iVar);
        this.f52638c = pVar;
        this.f52636a = iVar2;
        this.f52637b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f52638c.f52646a.mo149094b().mo149172b(this.f52638c.f52647d, C18280p.m37400d(), new C18278n(this.f52638c, this.f52636a));
        } catch (RemoteException e) {
            C18280p.f52644b.mo149082a((Throwable) e, "completeUpdate(%s)", this.f52637b);
            this.f52636a.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
