package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.f */
final class C18536f implements C18538h {

    /* renamed from: a */
    final /* synthetic */ Set f53236a;

    /* renamed from: b */
    final /* synthetic */ C18547q f53237b;

    /* renamed from: c */
    final /* synthetic */ C18541k f53238c;

    C18536f(C18541k kVar, Set set, C18547q qVar) {
        this.f53238c = kVar;
        this.f53236a = set;
        this.f53237b = qVar;
    }

    /* renamed from: a */
    public final void mo149231a(ZipFile zipFile, Set<C18540j> set) throws IOException {
        this.f53236a.addAll(C18541k.m38068a(this.f53238c, (Set) set, this.f53237b, zipFile));
    }
}
