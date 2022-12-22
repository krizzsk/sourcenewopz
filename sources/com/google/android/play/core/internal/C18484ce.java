package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.play.core.internal.ce */
final class C18484ce extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f53171a;

    public C18484ce(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f53171a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            C18484ce ceVar = (C18484ce) obj;
            return this.f53171a == ceVar.f53171a && get() == ceVar.get();
        }
    }

    public final int hashCode() {
        return this.f53171a;
    }
}
