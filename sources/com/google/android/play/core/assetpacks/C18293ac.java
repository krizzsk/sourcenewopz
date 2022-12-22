package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.internal.C18513v;
import com.google.android.play.core.tasks.C18619i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ac */
final class C18293ac extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f52710a;

    /* renamed from: b */
    final /* synthetic */ C18619i f52711b;

    /* renamed from: c */
    final /* synthetic */ C18308ar f52712c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18293ac(C18308ar arVar, C18619i iVar, List list, C18619i iVar2) {
        super(iVar);
        this.f52712c = arVar;
        this.f52710a = list;
        this.f52711b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52712c.f52759e.mo149094b()).mo149178b(this.f52712c.f52757c, (List<Bundle>) C18308ar.m37466a((Collection) this.f52710a), C18308ar.m37482e(), (C18513v) new C18301ak(this.f52712c, this.f52711b, (byte[]) null));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "cancelDownloads(%s)", this.f52710a);
        }
    }
}
