package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.c */
final /* synthetic */ class C18596c implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f53372a;

    /* renamed from: b */
    private final List f53373b;

    /* renamed from: c */
    private final List f53374c;

    C18596c(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.f53372a = fakeSplitInstallManager;
        this.f53373b = list;
        this.f53374c = list2;
    }

    public final void run() {
        this.f53372a.mo149307a(this.f53373b, this.f53374c);
    }
}
