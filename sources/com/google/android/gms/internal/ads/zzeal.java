package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
abstract class zzeal<InputT, OutputT> extends zzeap<OutputT> {
    private static final Logger logger = Logger.getLogger(zzeal.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdyv<? extends zzebt<? extends InputT>> zzict;
    private final boolean zzicu;
    private final boolean zzicv;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    zzeal(zzdyv<? extends zzebt<? extends InputT>> zzdyv, boolean z, boolean z2) {
        super(zzdyv.size());
        this.zzict = (zzdyv) zzdyi.checkNotNull(zzdyv);
        this.zzicu = z;
        this.zzicv = z2;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(int i, @NullableDecl InputT inputt);

    /* access modifiers changed from: package-private */
    public abstract void zzbaw();

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        zzdyv<? extends zzebt<? extends InputT>> zzdyv = this.zzict;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdyv != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdzx zzdzx = (zzdzx) zzdyv.iterator();
            while (zzdzx.hasNext()) {
                ((Future) zzdzx.next()).cancel(wasInterrupted);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdyv<? extends zzebt<? extends InputT>> zzdyv = this.zzict;
        if (zzdyv == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdyv);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("futures=");
        sb.append(valueOf);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzbav() {
        if (this.zzict.isEmpty()) {
            zzbaw();
        } else if (this.zzicu) {
            int i = 0;
            zzdzx zzdzx = (zzdzx) this.zzict.iterator();
            while (zzdzx.hasNext()) {
                zzebt zzebt = (zzebt) zzdzx.next();
                zzebt.addListener(new zzeao(this, zzebt, i), zzeba.INSTANCE);
                i++;
            }
        } else {
            zzean zzean = new zzean(this, this.zzicv ? this.zzict : null);
            zzdzx zzdzx2 = (zzdzx) this.zzict.iterator();
            while (zzdzx2.hasNext()) {
                ((zzebt) zzdzx2.next()).addListener(zzean, zzeba.INSTANCE);
            }
        }
    }

    private final void handleException(Throwable th) {
        zzdyi.checkNotNull(th);
        if (this.zzicu && !setException(th) && zza(zzbax(), th)) {
            zzk(th);
        } else if (th instanceof Error) {
            zzk(th);
        }
    }

    private static void zzk(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(Set<Throwable> set) {
        zzdyi.checkNotNull(set);
        if (!isCancelled()) {
            zza(set, zzbas());
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, zzebh.zza(future));
        } catch (ExecutionException e) {
            handleException(e.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(@NullableDecl zzdyv<? extends Future<? extends InputT>> zzdyv) {
        int zzbay = zzbay();
        int i = 0;
        if (!(zzbay >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        } else if (zzbay == 0) {
            if (zzdyv != null) {
                zzdzx zzdzx = (zzdzx) zzdyv.iterator();
                while (zzdzx.hasNext()) {
                    Future future = (Future) zzdzx.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzbaz();
            zzbaw();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        zzdyi.checkNotNull(zza2);
        this.zzict = null;
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
