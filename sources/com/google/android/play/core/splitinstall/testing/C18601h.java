package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.h */
final /* synthetic */ class C18601h implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f53384a;

    /* renamed from: b */
    private final List f53385b;

    /* renamed from: c */
    private final List f53386c;

    /* renamed from: d */
    private final List f53387d;

    /* renamed from: e */
    private final long f53388e;

    C18601h(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, List list3, long j) {
        this.f53384a = fakeSplitInstallManager;
        this.f53385b = list;
        this.f53386c = list2;
        this.f53387d = list3;
        this.f53388e = j;
    }

    public final void run() {
        this.f53384a.mo149308a(this.f53385b, this.f53386c, this.f53387d, this.f53388e);
    }
}
