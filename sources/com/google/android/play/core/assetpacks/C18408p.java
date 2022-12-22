package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18470br;
import com.google.android.play.core.internal.C18494co;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.p */
public final class C18408p implements C18494co<Executor> {
    /* renamed from: b */
    public static Executor m37710b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C18403l.f53096a);
        C18470br.m37859b(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        return m37710b();
    }
}
