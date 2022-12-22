package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.da */
public final class C18372da implements C18494co<C18370cz> {

    /* renamed from: a */
    private final C18494co<String> f52987a;

    /* renamed from: b */
    private final C18494co<C18313aw> f52988b;

    /* renamed from: c */
    private final C18494co<C18343bz> f52989c;

    /* renamed from: d */
    private final C18494co<Context> f52990d;

    /* renamed from: e */
    private final C18494co<C18383dl> f52991e;

    /* renamed from: f */
    private final C18494co<Executor> f52992f;

    public C18372da(C18494co<String> coVar, C18494co<C18313aw> coVar2, C18494co<C18343bz> coVar3, C18494co<Context> coVar4, C18494co<C18383dl> coVar5, C18494co<Executor> coVar6) {
        this.f52987a = coVar;
        this.f52988b = coVar2;
        this.f52989c = coVar3;
        this.f52990d = coVar4;
        this.f52991e = coVar5;
        this.f52992f = coVar6;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        String a = this.f52987a.mo148801a();
        C18313aw a2 = this.f52988b.mo148801a();
        C18343bz a3 = this.f52989c.mo148801a();
        Context b = ((C18411s) this.f52990d).mo148801a();
        C18383dl a4 = this.f52991e.mo148801a();
        return new C18370cz(a != null ? new File(b.getExternalFilesDir((String) null), a) : b.getExternalFilesDir((String) null), a2, a3, b, a4, C18492cm.m37911b(this.f52992f));
    }
}
