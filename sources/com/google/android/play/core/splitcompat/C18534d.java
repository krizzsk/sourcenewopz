package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.splitcompat.d */
final class C18534d implements C18539i {

    /* renamed from: a */
    final /* synthetic */ C18535e f53231a;

    C18534d(C18535e eVar) {
        this.f53231a = eVar;
    }

    /* renamed from: a */
    public final void mo149230a(C18540j jVar, File file, boolean z) throws IOException {
        this.f53231a.f53233b.add(file);
        if (!z) {
            this.f53231a.f53234c.set(false);
        }
    }
}
