package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cq */
public final class C18361cq implements C18494co<C18360cp> {

    /* renamed from: a */
    private final C18494co<C18319bb> f52948a;

    /* renamed from: b */
    private final C18494co<C18415w> f52949b;

    /* renamed from: c */
    private final C18494co<C18343bz> f52950c;

    /* renamed from: d */
    private final C18494co<Executor> f52951d;

    public C18361cq(C18494co<C18319bb> coVar, C18494co<C18415w> coVar2, C18494co<C18343bz> coVar3, C18494co<Executor> coVar4) {
        this.f52948a = coVar;
        this.f52949b = coVar2;
        this.f52950c = coVar3;
        this.f52951d = coVar4;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        C18319bb a = this.f52948a.mo148801a();
        return new C18360cp(a, C18492cm.m37911b(this.f52949b), this.f52950c.mo148801a(), C18492cm.m37911b(this.f52951d));
    }
}
