package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.C18494co;
import com.google.android.play.core.splitinstall.C18589p;
import com.google.android.play.core.splitinstall.C18610z;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.testing.k */
public final class C18604k implements C18494co<FakeSplitInstallManager> {

    /* renamed from: a */
    private final C18494co<Context> f53395a;

    /* renamed from: b */
    private final C18494co<File> f53396b;

    /* renamed from: c */
    private final C18494co<C18589p> f53397c;

    public C18604k(C18494co<Context> coVar, C18494co<File> coVar2, C18494co<C18589p> coVar3) {
        this.f53395a = coVar;
        this.f53396b = coVar2;
        this.f53397c = coVar3;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        return new FakeSplitInstallManager(((C18610z) this.f53395a).mo148801a(), this.f53396b.mo148801a(), this.f53397c.mo148801a());
    }
}
