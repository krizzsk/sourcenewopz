package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cl */
public final class C18491cl<T> implements C18494co<T> {

    /* renamed from: a */
    private C18494co<T> f53176a;

    /* renamed from: a */
    public static <T> void m37908a(C18494co<T> coVar, C18494co<T> coVar2) {
        C18470br.m37854a(coVar2);
        C18491cl clVar = (C18491cl) coVar;
        if (clVar.f53176a == null) {
            clVar.f53176a = coVar2;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final T mo148801a() {
        C18494co<T> coVar = this.f53176a;
        if (coVar != null) {
            return coVar.mo148801a();
        }
        throw new IllegalStateException();
    }
}
