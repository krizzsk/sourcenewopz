package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.internal.C18513v;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.ag */
final class C18297ag extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ int f52727a;

    /* renamed from: b */
    final /* synthetic */ String f52728b;

    /* renamed from: c */
    final /* synthetic */ C18619i f52729c;

    /* renamed from: d */
    final /* synthetic */ int f52730d;

    /* renamed from: e */
    final /* synthetic */ C18308ar f52731e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18297ag(C18308ar arVar, C18619i iVar, int i, String str, C18619i iVar2, int i2) {
        super(iVar);
        this.f52731e = arVar;
        this.f52727a = i;
        this.f52728b = str;
        this.f52729c = iVar2;
        this.f52730d = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52731e.f52759e.mo149094b()).mo149176b(this.f52731e.f52757c, C18308ar.m37477c(this.f52727a, this.f52728b), C18308ar.m37482e(), (C18513v) new C18305ao(this.f52731e, this.f52729c, this.f52727a, this.f52728b, this.f52730d));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
