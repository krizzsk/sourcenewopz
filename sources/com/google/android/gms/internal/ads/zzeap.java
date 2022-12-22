package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeah;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
abstract class zzeap<OutputT> extends zzeah.zzh<OutputT> {
    private static final Logger zzice;
    private static final zza zzida;
    private volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private static abstract class zza {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzeap zzeap, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int zzc(zzeap zzeap);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private static final class zzb extends zza {
        private zzb() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzeap zzeap, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzeap) {
                if (zzeap.seenExceptions == null) {
                    Set unused = zzeap.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int zzc(zzeap zzeap) {
            int zzb;
            synchronized (zzeap) {
                zzb = zzeap.zzb(zzeap);
            }
            return zzb;
        }
    }

    zzeap(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzh(Set<Throwable> set);

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private static final class zzc extends zza {
        private final AtomicReferenceFieldUpdater<zzeap, Set<Throwable>> zzide;
        private final AtomicIntegerFieldUpdater<zzeap> zzidf;

        zzc(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzide = atomicReferenceFieldUpdater;
            this.zzidf = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzeap zzeap, Set<Throwable> set, Set<Throwable> set2) {
            this.zzide.compareAndSet(zzeap, (Object) null, set2);
        }

        /* access modifiers changed from: package-private */
        public final int zzc(zzeap zzeap) {
            return this.zzidf.decrementAndGet(zzeap);
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> zzbax() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzh(newSetFromMap);
        zzida.zza(this, (Set<Throwable>) null, newSetFromMap);
        return this.seenExceptions;
    }

    /* access modifiers changed from: package-private */
    public final int zzbay() {
        return zzida.zzc(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzbaz() {
        this.seenExceptions = null;
    }

    static /* synthetic */ int zzb(zzeap zzeap) {
        int i = zzeap.remaining - 1;
        zzeap.remaining = i;
        return i;
    }

    static {
        Throwable th;
        zza zza2;
        Class<zzeap> cls = zzeap.class;
        zzice = Logger.getLogger(cls.getName());
        try {
            zza2 = new zzc(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
            th = null;
        } catch (Throwable th2) {
            zza2 = new zzb();
            th = th2;
        }
        zzida = zza2;
        if (th != null) {
            zzice.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
