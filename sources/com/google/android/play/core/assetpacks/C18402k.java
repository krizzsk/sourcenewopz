package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import com.google.android.play.core.splitinstall.C18589p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.k */
public final class C18402k implements C18494co<C18401j> {

    /* renamed from: a */
    private final C18494co<C18319bb> f53088a;

    /* renamed from: b */
    private final C18494co<C18415w> f53089b;

    /* renamed from: c */
    private final C18494co<C18313aw> f53090c;

    /* renamed from: d */
    private final C18494co<C18589p> f53091d;

    /* renamed from: e */
    private final C18494co<C18360cp> f53092e;

    /* renamed from: f */
    private final C18494co<C18343bz> f53093f;

    /* renamed from: g */
    private final C18494co<C18331bn> f53094g;

    /* renamed from: h */
    private final C18494co<Executor> f53095h;

    public C18402k(C18494co<C18319bb> coVar, C18494co<C18415w> coVar2, C18494co<C18313aw> coVar3, C18494co<C18589p> coVar4, C18494co<C18360cp> coVar5, C18494co<C18343bz> coVar6, C18494co<C18331bn> coVar7, C18494co<Executor> coVar8) {
        this.f53088a = coVar;
        this.f53089b = coVar2;
        this.f53090c = coVar3;
        this.f53091d = coVar4;
        this.f53092e = coVar5;
        this.f53093f = coVar6;
        this.f53094g = coVar7;
        this.f53095h = coVar8;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        C18319bb a = this.f53088a.mo148801a();
        C18490ck<C18415w> b = C18492cm.m37911b(this.f53089b);
        C18313aw a2 = this.f53090c.mo148801a();
        return new C18401j(a, b, a2, this.f53091d.mo148801a(), this.f53092e.mo148801a(), this.f53093f.mo148801a(), this.f53094g.mo148801a(), C18492cm.m37911b(this.f53095h));
    }
}
