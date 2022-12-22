package com.didi.raven.manger;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.didi.raven.manger.-$$Lambda$RavenThreadExecutorManger$XkxRNCgSvd0E8QsCaA1i7Nwb0NM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$RavenThreadExecutorManger$XkxRNCgSvd0E8QsCaA1i7Nwb0NM implements ThreadFactory {
    public static final /* synthetic */ $$Lambda$RavenThreadExecutorManger$XkxRNCgSvd0E8QsCaA1i7Nwb0NM INSTANCE = new $$Lambda$RavenThreadExecutorManger$XkxRNCgSvd0E8QsCaA1i7Nwb0NM();

    private /* synthetic */ $$Lambda$RavenThreadExecutorManger$XkxRNCgSvd0E8QsCaA1i7Nwb0NM() {
    }

    public final Thread newThread(Runnable runnable) {
        return RavenThreadExecutorManger.m23312a(runnable);
    }
}
