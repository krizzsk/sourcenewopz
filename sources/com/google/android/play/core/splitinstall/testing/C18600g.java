package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.g */
final /* synthetic */ class C18600g implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f53379a;

    /* renamed from: b */
    private final long f53380b;

    /* renamed from: c */
    private final List f53381c;

    /* renamed from: d */
    private final List f53382d;

    /* renamed from: e */
    private final List f53383e;

    C18600g(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.f53379a = fakeSplitInstallManager;
        this.f53380b = j;
        this.f53381c = list;
        this.f53382d = list2;
        this.f53383e = list3;
    }

    public final void run() {
        this.f53379a.mo149305a(this.f53380b, this.f53381c, this.f53382d, this.f53383e);
    }
}
