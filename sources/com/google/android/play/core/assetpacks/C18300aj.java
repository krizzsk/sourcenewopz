package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.aj */
final class C18300aj extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ C18619i f52741a;

    /* renamed from: b */
    final /* synthetic */ C18308ar f52742b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18300aj(C18308ar arVar, C18619i iVar, C18619i iVar2) {
        super(iVar);
        this.f52742b = arVar;
        this.f52741a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52742b.f52760f.mo149094b()).mo149177b(this.f52742b.f52757c, C18308ar.m37482e(), new C18304an(this.f52742b, this.f52741a));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "keepAlive", new Object[0]);
        }
    }
}
