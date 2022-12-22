package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.play.core.internal.cf */
final class C18485cf {

    /* renamed from: a */
    private final ConcurrentHashMap<C18484ce, List<Throwable>> f53172a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f53173b = new ReferenceQueue<>();

    C18485cf() {
    }

    /* renamed from: a */
    public final List<Throwable> mo149138a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.f53173b.poll();
            if (poll == null) {
                break;
            }
            this.f53172a.remove(poll);
        }
        List<Throwable> list = this.f53172a.get(new C18484ce(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f53172a.putIfAbsent(new C18484ce(th, this.f53173b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
