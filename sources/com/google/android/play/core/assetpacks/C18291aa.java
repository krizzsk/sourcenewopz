package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.aa */
final class C18291aa extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ String f52702a;

    /* renamed from: b */
    final /* synthetic */ C18619i f52703b;

    /* renamed from: c */
    final /* synthetic */ C18308ar f52704c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18291aa(C18308ar arVar, C18619i iVar, String str, C18619i iVar2) {
        super(iVar);
        this.f52704c = arVar;
        this.f52702a = str;
        this.f52703b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52704c.f52759e.mo149094b()).mo149182e(this.f52704c.f52757c, C18308ar.m37477c(0, this.f52702a), C18308ar.m37482e(), new C18301ak(this.f52704c, this.f52703b, (short[]) null));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "removePack(%s)", this.f52702a);
        }
    }
}
