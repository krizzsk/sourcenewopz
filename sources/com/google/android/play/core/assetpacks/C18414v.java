package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18470br;
import com.google.android.play.core.internal.C18494co;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.v */
public final class C18414v implements C18494co<Executor> {
    /* renamed from: b */
    public static Executor m37719b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C18404m.f53097a);
        C18470br.m37859b(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        return m37719b();
    }
}
