package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* renamed from: com.google.android.play.core.splitinstall.testing.f */
final /* synthetic */ class C18599f implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f53377a;

    /* renamed from: b */
    private final SplitInstallSessionState f53378b;

    C18599f(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.f53377a = fakeSplitInstallManager;
        this.f53378b = splitInstallSessionState;
    }

    public final void run() {
        this.f53377a.mo149306a(this.f53378b);
    }
}
