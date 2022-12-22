package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.appupdate.k */
final class C18275k extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ String f52633a;

    /* renamed from: b */
    final /* synthetic */ C18619i f52634b;

    /* renamed from: c */
    final /* synthetic */ C18280p f52635c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18275k(C18280p pVar, C18619i iVar, String str, C18619i iVar2) {
        super(iVar);
        this.f52635c = pVar;
        this.f52633a = str;
        this.f52634b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f52635c.f52646a.mo149094b().mo149171a(this.f52635c.f52647d, C18280p.m37394a(this.f52635c, this.f52633a), new C18279o(this.f52635c, this.f52634b, this.f52633a));
        } catch (RemoteException e) {
            C18280p.f52644b.mo149082a((Throwable) e, "requestUpdateInfo(%s)", this.f52633a);
            this.f52634b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
