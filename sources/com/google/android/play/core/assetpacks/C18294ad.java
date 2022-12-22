package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.tasks.C18619i;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ad */
final class C18294ad extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ Map f52713a;

    /* renamed from: b */
    final /* synthetic */ C18619i f52714b;

    /* renamed from: c */
    final /* synthetic */ C18308ar f52715c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18294ad(C18308ar arVar, C18619i iVar, Map map, C18619i iVar2) {
        super(iVar);
        this.f52715c = arVar;
        this.f52713a = map;
        this.f52714b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52715c.f52759e.mo149094b()).mo149174a(this.f52715c.f52757c, C18308ar.m37472b(this.f52713a), new C18303am(this.f52715c, this.f52714b));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "syncPacks", new Object[0]);
            this.f52714b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
