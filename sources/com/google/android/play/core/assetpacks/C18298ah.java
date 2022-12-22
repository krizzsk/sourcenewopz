package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.internal.C18513v;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.ah */
final class C18298ah extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ int f52732a;

    /* renamed from: b */
    final /* synthetic */ C18619i f52733b;

    /* renamed from: c */
    final /* synthetic */ C18308ar f52734c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18298ah(C18308ar arVar, C18619i iVar, int i, C18619i iVar2) {
        super(iVar);
        this.f52734c = arVar;
        this.f52732a = i;
        this.f52733b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52734c.f52759e.mo149094b()).mo149179c(this.f52734c.f52757c, C18308ar.m37476c(this.f52732a), C18308ar.m37482e(), (C18513v) new C18301ak(this.f52734c, this.f52733b, (int[]) null));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "notifySessionFailed", new Object[0]);
        }
    }
}
