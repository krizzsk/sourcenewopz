package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18476bx;
import com.google.android.play.core.tasks.C18619i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ae */
final class C18553ae extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ Collection f53275a;

    /* renamed from: b */
    final /* synthetic */ Collection f53276b;

    /* renamed from: c */
    final /* synthetic */ C18619i f53277c;

    /* renamed from: d */
    final /* synthetic */ C18570av f53278d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18553ae(C18570av avVar, C18619i iVar, Collection collection, Collection collection2, C18619i iVar2) {
        super(iVar);
        this.f53278d = avVar;
        this.f53275a = collection;
        this.f53276b = collection2;
        this.f53277c = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        ArrayList a = C18570av.m38122a(this.f53275a);
        a.addAll(C18570av.m38124b(this.f53276b));
        try {
            this.f53278d.f53303a.mo149094b().mo149115a(this.f53278d.f53304d, (List<Bundle>) a, C18570av.m38123b(), (C18476bx) new C18568at(this.f53278d, this.f53277c));
        } catch (RemoteException e) {
            C18570av.f53301b.mo149082a((Throwable) e, "startInstall(%s,%s)", this.f53275a, this.f53276b);
            this.f53277c.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
