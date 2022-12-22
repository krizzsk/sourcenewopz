package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dk */
public final class C18382dk implements C18494co<C18381dj> {

    /* renamed from: a */
    private final C18494co<C18319bb> f53019a;

    /* renamed from: b */
    private final C18494co<C18415w> f53020b;

    /* renamed from: c */
    private final C18494co<C18360cp> f53021c;

    /* renamed from: d */
    private final C18494co<Executor> f53022d;

    /* renamed from: e */
    private final C18494co<C18343bz> f53023e;

    public C18382dk(C18494co<C18319bb> coVar, C18494co<C18415w> coVar2, C18494co<C18360cp> coVar3, C18494co<Executor> coVar4, C18494co<C18343bz> coVar5) {
        this.f53019a = coVar;
        this.f53020b = coVar2;
        this.f53021c = coVar3;
        this.f53022d = coVar4;
        this.f53023e = coVar5;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        C18319bb a = this.f53019a.mo148801a();
        return new C18381dj(a, C18492cm.m37911b(this.f53020b), this.f53021c.mo148801a(), C18492cm.m37911b(this.f53022d), this.f53023e.mo148801a());
    }
}
