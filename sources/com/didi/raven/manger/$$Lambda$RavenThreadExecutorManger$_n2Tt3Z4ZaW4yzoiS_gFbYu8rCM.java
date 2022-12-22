package com.didi.raven.manger;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.didi.raven.manger.-$$Lambda$RavenThreadExecutorManger$_n2Tt3Z4ZaW4yzoiS_gFbYu8rCM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$RavenThreadExecutorManger$_n2Tt3Z4ZaW4yzoiS_gFbYu8rCM implements ThreadFactory {
    public static final /* synthetic */ $$Lambda$RavenThreadExecutorManger$_n2Tt3Z4ZaW4yzoiS_gFbYu8rCM INSTANCE = new $$Lambda$RavenThreadExecutorManger$_n2Tt3Z4ZaW4yzoiS_gFbYu8rCM();

    private /* synthetic */ $$Lambda$RavenThreadExecutorManger$_n2Tt3Z4ZaW4yzoiS_gFbYu8rCM() {
    }

    public final Thread newThread(Runnable runnable) {
        return RavenThreadExecutorManger.m23313b(runnable);
    }
}
