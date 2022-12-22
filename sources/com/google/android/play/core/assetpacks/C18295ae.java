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

/* renamed from: com.google.android.play.core.assetpacks.ae */
final class C18295ae extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f52716a;

    /* renamed from: b */
    final /* synthetic */ Map f52717b;

    /* renamed from: c */
    final /* synthetic */ C18619i f52718c;

    /* renamed from: d */
    final /* synthetic */ C18316az f52719d;

    /* renamed from: e */
    final /* synthetic */ C18308ar f52720e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18295ae(C18308ar arVar, C18619i iVar, List list, Map map, C18619i iVar2, C18316az azVar) {
        super(iVar);
        this.f52720e = arVar;
        this.f52716a = list;
        this.f52717b = map;
        this.f52718c = iVar2;
        this.f52719d = azVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        ArrayList a = C18308ar.m37466a((Collection) this.f52716a);
        try {
            String a2 = this.f52720e.f52757c;
            Bundle b = C18308ar.m37472b(this.f52717b);
            C18308ar arVar = this.f52720e;
            ((C18511t) this.f52720e.f52759e.mo149094b()).mo149180c(a2, (List<Bundle>) a, b, (C18513v) new C18306ap(arVar, this.f52718c, arVar.f52758d, this.f52719d));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "getPackStates(%s)", this.f52716a);
            this.f52718c.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
