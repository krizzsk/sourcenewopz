package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.8.0 */
final class zzelb {
    private final ConcurrentHashMap<zzela, List<Throwable>> zzioj = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zziok = new ReferenceQueue<>();

    zzelb() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zziok.poll();
        while (poll != null) {
            this.zzioj.remove(poll);
            poll = this.zziok.poll();
        }
        List<Throwable> list = this.zzioj.get(new zzela(th, (ReferenceQueue<Throwable>) null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzioj.putIfAbsent(new zzela(th, this.zziok), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
