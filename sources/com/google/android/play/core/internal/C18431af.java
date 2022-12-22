package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.af */
public final class C18431af<StateT> {

    /* renamed from: a */
    protected final Set<StateUpdatedListener<StateT>> f53128a = new HashSet();

    /* renamed from: a */
    public final synchronized void mo149078a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f53128a.add(stateUpdatedListener);
    }

    /* renamed from: a */
    public final synchronized void mo149079a(StateT statet) {
        for (StateUpdatedListener<StateT> onStateUpdate : this.f53128a) {
            onStateUpdate.onStateUpdate(statet);
        }
    }

    /* renamed from: b */
    public final synchronized void mo149080b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f53128a.remove(stateUpdatedListener);
    }
}
