package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cg */
final class C18486cg extends C18483cd {

    /* renamed from: a */
    private final C18485cf f53174a = new C18485cf();

    C18486cg() {
    }

    /* renamed from: a */
    public final void mo149135a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f53174a.mo149138a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
