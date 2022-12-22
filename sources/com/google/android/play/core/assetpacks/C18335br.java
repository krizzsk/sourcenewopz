package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C18420a;
import com.google.android.play.core.common.C18422c;
import com.google.android.play.core.internal.C18491cl;
import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import com.google.android.play.core.splitinstall.C18589p;
import com.google.android.play.core.splitinstall.C18590q;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.br */
public final class C18335br implements C18290a {

    /* renamed from: a */
    private final C18406n f52834a;

    /* renamed from: b */
    private C18494co<Context> f52835b;

    /* renamed from: c */
    private C18494co<C18383dl> f52836c;

    /* renamed from: d */
    private C18494co<C18319bb> f52837d;

    /* renamed from: e */
    private C18494co<C18343bz> f52838e;

    /* renamed from: f */
    private C18494co<C18308ar> f52839f;

    /* renamed from: g */
    private C18494co<String> f52840g = C18492cm.m37910a(new C18412t(this.f52835b));

    /* renamed from: h */
    private C18494co<C18415w> f52841h = new C18491cl();

    /* renamed from: i */
    private C18494co<Executor> f52842i;

    /* renamed from: j */
    private C18494co<C18360cp> f52843j;

    /* renamed from: k */
    private C18494co<C18313aw> f52844k;

    /* renamed from: l */
    private C18494co<C18337bt> f52845l;

    /* renamed from: m */
    private C18494co<C18393dv> f52846m;

    /* renamed from: n */
    private C18494co<C18377df> f52847n;

    /* renamed from: o */
    private C18494co<C18381dj> f52848o;

    /* renamed from: p */
    private C18494co<C18420a> f52849p;

    /* renamed from: q */
    private C18494co<C18386do> f52850q;

    /* renamed from: r */
    private C18494co<C18328bk> f52851r;

    /* renamed from: s */
    private C18494co<C18363cs> f52852s;

    /* renamed from: t */
    private C18494co<C18340bw> f52853t;

    /* renamed from: u */
    private C18494co<C18331bn> f52854u;

    /* renamed from: v */
    private C18494co<Executor> f52855v;

    /* renamed from: w */
    private C18494co<C18370cz> f52856w;

    /* renamed from: x */
    private C18494co<C18589p> f52857x;

    /* renamed from: y */
    private C18494co<C18401j> f52858y;

    /* renamed from: z */
    private C18494co<AssetPackManager> f52859z;

    /* synthetic */ C18335br(C18406n nVar) {
        this.f52834a = nVar;
        C18411s sVar = new C18411s(nVar);
        this.f52835b = sVar;
        C18494co<C18383dl> a = C18492cm.m37910a(new C18384dm(sVar));
        this.f52836c = a;
        this.f52837d = C18492cm.m37910a(new C18320bc(this.f52835b, a));
        C18494co<C18343bz> a2 = C18492cm.m37910a(C18345ca.f52907a);
        this.f52838e = a2;
        this.f52839f = C18492cm.m37910a(new C18309as(this.f52835b, a2));
        C18494co<Executor> a3 = C18492cm.m37910a(C18407o.f53101a);
        this.f52842i = a3;
        this.f52843j = C18492cm.m37910a(new C18361cq(this.f52837d, this.f52841h, this.f52838e, a3));
        C18491cl clVar = new C18491cl();
        this.f52844k = clVar;
        this.f52845l = C18492cm.m37910a(new C18338bu(this.f52837d, this.f52841h, clVar, this.f52838e));
        this.f52846m = C18492cm.m37910a(new C18394dw(this.f52837d));
        this.f52847n = C18492cm.m37910a(new C18378dg(this.f52837d));
        this.f52848o = C18492cm.m37910a(new C18382dk(this.f52837d, this.f52841h, this.f52843j, this.f52842i, this.f52838e));
        C18494co<C18420a> a4 = C18492cm.m37910a(C18422c.m37739b());
        this.f52849p = a4;
        this.f52850q = C18492cm.m37910a(new C18387dp(this.f52837d, this.f52841h, a4));
        C18494co<C18328bk> a5 = C18492cm.m37910a(new C18329bl(this.f52841h));
        this.f52851r = a5;
        C18494co<C18363cs> a6 = C18492cm.m37910a(new C18364ct(this.f52843j, this.f52837d, a5));
        this.f52852s = a6;
        this.f52853t = C18492cm.m37910a(new C18341bx(this.f52843j, this.f52841h, this.f52845l, this.f52846m, this.f52847n, this.f52848o, this.f52850q, a6));
        this.f52854u = C18492cm.m37910a(C18332bo.f52832a);
        C18494co<Executor> a7 = C18492cm.m37910a(C18413u.f53109a);
        this.f52855v = a7;
        C18491cl.m37908a(this.f52844k, C18492cm.m37910a(new C18314ax(this.f52835b, this.f52843j, this.f52853t, this.f52841h, this.f52838e, this.f52854u, this.f52849p, this.f52842i, a7)));
        C18494co<C18370cz> a8 = C18492cm.m37910a(new C18372da(this.f52840g, this.f52844k, this.f52838e, this.f52835b, this.f52836c, this.f52842i));
        this.f52856w = a8;
        C18491cl.m37908a(this.f52841h, C18492cm.m37910a(new C18410r(this.f52835b, this.f52839f, a8)));
        C18494co<C18589p> a9 = C18492cm.m37910a(C18590q.m38173a(this.f52835b));
        this.f52857x = a9;
        C18494co<C18401j> a10 = C18492cm.m37910a(new C18402k(this.f52837d, this.f52841h, this.f52844k, a9, this.f52843j, this.f52838e, this.f52854u, this.f52842i));
        this.f52858y = a10;
        this.f52859z = C18492cm.m37910a(new C18409q(a10, this.f52835b));
    }

    /* renamed from: a */
    public final AssetPackManager mo148873a() {
        return this.f52859z.mo148801a();
    }

    /* renamed from: a */
    public final void mo148874a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f52695a = C18411s.m37714a(this.f52834a);
        assetPackExtractionService.f52696b = this.f52858y.mo148801a();
        assetPackExtractionService.f52697c = this.f52837d.mo148801a();
    }
}
