package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.e */
final class C18535e implements C18538h {

    /* renamed from: a */
    final /* synthetic */ C18547q f53232a;

    /* renamed from: b */
    final /* synthetic */ Set f53233b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f53234c;

    /* renamed from: d */
    final /* synthetic */ C18541k f53235d;

    C18535e(C18541k kVar, C18547q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.f53235d = kVar;
        this.f53232a = qVar;
        this.f53233b = set;
        this.f53234c = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo149231a(ZipFile zipFile, Set<C18540j> set) throws IOException {
        this.f53235d.m38071a(this.f53232a, set, new C18534d(this));
    }
}
