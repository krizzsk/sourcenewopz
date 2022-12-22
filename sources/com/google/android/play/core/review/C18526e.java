package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.review.e */
final class C18526e extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ C18619i f53213a;

    /* renamed from: b */
    final /* synthetic */ C18529h f53214b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18526e(C18529h hVar, C18619i iVar, C18619i iVar2) {
        super(iVar);
        this.f53214b = hVar;
        this.f53213a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53214b.f53219a.mo149094b().mo149075a(this.f53214b.f53220c, PlayCoreVersion.m37734a(), new C18528g(this.f53214b, this.f53213a));
        } catch (RemoteException e) {
            C18529h.f53218b.mo149082a((Throwable) e, "error requesting in-app review for %s", this.f53214b.f53220c);
            this.f53213a.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
