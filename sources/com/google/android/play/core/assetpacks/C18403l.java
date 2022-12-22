package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.l */
final /* synthetic */ class C18403l implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f53096a = new C18403l();

    private C18403l() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
