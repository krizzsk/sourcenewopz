package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.m */
final /* synthetic */ class C18404m implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f53097a = new C18404m();

    private C18404m() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
