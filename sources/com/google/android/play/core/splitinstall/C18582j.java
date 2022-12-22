package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.j */
public final class C18582j implements C18494co<C18581i> {

    /* renamed from: a */
    private final C18494co<C18607w> f53324a;

    /* renamed from: b */
    private final C18494co<FakeSplitInstallManager> f53325b;

    /* renamed from: c */
    private final C18494co<File> f53326c;

    public C18582j(C18494co<C18607w> coVar, C18494co<FakeSplitInstallManager> coVar2, C18494co<File> coVar3) {
        this.f53324a = coVar;
        this.f53325b = coVar2;
        this.f53326c = coVar3;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        return new C18581i(C18492cm.m37911b(this.f53324a), C18492cm.m37911b(this.f53325b), C18492cm.m37911b(this.f53326c));
    }
}
