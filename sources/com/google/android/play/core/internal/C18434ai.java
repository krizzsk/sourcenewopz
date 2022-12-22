package com.google.android.play.core.internal;

import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ai */
final /* synthetic */ class C18434ai implements IBinder.DeathRecipient {

    /* renamed from: a */
    private final C18442aq f53131a;

    C18434ai(C18442aq aqVar) {
        this.f53131a = aqVar;
    }

    public final void binderDied() {
        this.f53131a.mo149095c();
    }
}
