package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;

/* renamed from: com.google.android.play.core.appupdate.y */
public final class C18289y {

    /* renamed from: a */
    private C18494co<Context> f52688a;

    /* renamed from: b */
    private C18494co<C18282r> f52689b;

    /* renamed from: c */
    private C18494co<C18280p> f52690c;

    /* renamed from: d */
    private C18494co<C18265a> f52691d;

    /* renamed from: e */
    private C18494co<C18269e> f52692e;

    /* renamed from: f */
    private C18494co<AppUpdateManager> f52693f;

    /* synthetic */ C18289y(C18271g gVar) {
        C18273i iVar = new C18273i(gVar);
        this.f52688a = iVar;
        C18494co<C18282r> a = C18492cm.m37910a(new C18283s(iVar));
        this.f52689b = a;
        this.f52690c = C18492cm.m37910a(new C18281q(this.f52688a, a));
        C18494co<C18265a> a2 = C18492cm.m37910a(new C18266b(this.f52688a));
        this.f52691d = a2;
        C18494co<C18269e> a3 = C18492cm.m37910a(new C18270f(this.f52690c, a2, this.f52688a));
        this.f52692e = a3;
        this.f52693f = C18492cm.m37910a(new C18272h(a3));
    }

    /* renamed from: a */
    public final AppUpdateManager mo148840a() {
        return this.f52693f.mo148801a();
    }
}
