package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.internal.C18513v;
import com.google.android.play.core.tasks.C18619i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ab */
final class C18292ab extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f52705a;

    /* renamed from: b */
    final /* synthetic */ Map f52706b;

    /* renamed from: c */
    final /* synthetic */ C18619i f52707c;

    /* renamed from: d */
    final /* synthetic */ List f52708d;

    /* renamed from: e */
    final /* synthetic */ C18308ar f52709e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18292ab(C18308ar arVar, C18619i iVar, List list, Map map, C18619i iVar2, List list2) {
        super(iVar);
        this.f52709e = arVar;
        this.f52705a = list;
        this.f52706b = map;
        this.f52707c = iVar2;
        this.f52708d = list2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        ArrayList a = C18308ar.m37466a((Collection) this.f52705a);
        try {
            String a2 = this.f52709e.f52757c;
            Bundle b = C18308ar.m37472b(this.f52706b);
            C18308ar arVar = this.f52709e;
            ((C18511t) this.f52709e.f52759e.mo149094b()).mo149175a(a2, (List<Bundle>) a, b, (C18513v) new C18307aq(arVar, this.f52707c, arVar.f52758d, this.f52708d));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "startDownload(%s)", this.f52705a);
            this.f52707c.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
