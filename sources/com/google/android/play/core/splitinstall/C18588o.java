package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.splitinstall.o */
public final class C18588o {

    /* renamed from: a */
    private static final AtomicReference<C18587n> f53332a = new AtomicReference<>((Object) null);

    /* renamed from: a */
    static C18587n m38164a() {
        return f53332a.get();
    }

    /* renamed from: a */
    public static void m38165a(C18587n nVar) {
        f53332a.compareAndSet((Object) null, nVar);
    }
}
