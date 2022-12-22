package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.tasks.C18619i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.af */
final class C18554af extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ List f53279a;

    /* renamed from: b */
    final /* synthetic */ C18619i f53280b;

    /* renamed from: c */
    final /* synthetic */ C18570av f53281c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18554af(C18570av avVar, C18619i iVar, List list, C18619i iVar2) {
        super(iVar);
        this.f53281c = avVar;
        this.f53279a = list;
        this.f53280b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            this.f53281c.f53303a.mo149094b().mo149116b(this.f53281c.f53304d, C18570av.m38122a((Collection) this.f53279a), C18570av.m38123b(), new C18565aq(this.f53281c, this.f53280b));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "deferredUninstall(%s)", this.f53279a);
            this.f53280b.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
