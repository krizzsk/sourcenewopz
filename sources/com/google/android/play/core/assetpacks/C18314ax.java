package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C18420a;
import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ax */
public final class C18314ax implements C18494co<C18313aw> {

    /* renamed from: a */
    private final C18494co<Context> f52780a;

    /* renamed from: b */
    private final C18494co<C18360cp> f52781b;

    /* renamed from: c */
    private final C18494co<C18340bw> f52782c;

    /* renamed from: d */
    private final C18494co<C18415w> f52783d;

    /* renamed from: e */
    private final C18494co<C18343bz> f52784e;

    /* renamed from: f */
    private final C18494co<C18331bn> f52785f;

    /* renamed from: g */
    private final C18494co<C18420a> f52786g;

    /* renamed from: h */
    private final C18494co<Executor> f52787h;

    /* renamed from: i */
    private final C18494co<Executor> f52788i;

    public C18314ax(C18494co<Context> coVar, C18494co<C18360cp> coVar2, C18494co<C18340bw> coVar3, C18494co<C18415w> coVar4, C18494co<C18343bz> coVar5, C18494co<C18331bn> coVar6, C18494co<C18420a> coVar7, C18494co<Executor> coVar8, C18494co<Executor> coVar9) {
        this.f52780a = coVar;
        this.f52781b = coVar2;
        this.f52782c = coVar3;
        this.f52783d = coVar4;
        this.f52784e = coVar5;
        this.f52785f = coVar6;
        this.f52786g = coVar7;
        this.f52787h = coVar8;
        this.f52788i = coVar9;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        Context b = ((C18411s) this.f52780a).mo148801a();
        C18360cp a = this.f52781b.mo148801a();
        C18340bw a2 = this.f52782c.mo148801a();
        C18490ck<C18415w> b2 = C18492cm.m37911b(this.f52783d);
        C18343bz a3 = this.f52784e.mo148801a();
        C18331bn a4 = this.f52785f.mo148801a();
        return new C18313aw(b, a, a2, b2, a3, a4, this.f52786g.mo148801a(), C18492cm.m37911b(this.f52787h), C18492cm.m37911b(this.f52788i));
    }
}
