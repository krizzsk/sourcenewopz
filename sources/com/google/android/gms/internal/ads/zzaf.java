package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaf {
    private final zzu zzai;
    private final AtomicInteger zzbi;
    private final Set<zzab<?>> zzbj;
    private final PriorityBlockingQueue<zzab<?>> zzbk;
    private final PriorityBlockingQueue<zzab<?>> zzbl;
    private final zzx[] zzbm;
    private zzm zzbn;
    private final List<zzah> zzbo;
    private final List<zzae> zzbp;
    private final zzk zzn;
    private final zzal zzo;

    private zzaf(zzk zzk, zzu zzu, int i, zzal zzal) {
        this.zzbi = new AtomicInteger();
        this.zzbj = new HashSet();
        this.zzbk = new PriorityBlockingQueue<>();
        this.zzbl = new PriorityBlockingQueue<>();
        this.zzbo = new ArrayList();
        this.zzbp = new ArrayList();
        this.zzn = zzk;
        this.zzai = zzu;
        this.zzbm = new zzx[4];
        this.zzo = zzal;
    }

    private zzaf(zzk zzk, zzu zzu, int i) {
        this(zzk, zzu, 4, new zzq(new Handler(Looper.getMainLooper())));
    }

    public zzaf(zzk zzk, zzu zzu) {
        this(zzk, zzu, 4);
    }

    public final void start() {
        zzm zzm = this.zzbn;
        if (zzm != null) {
            zzm.quit();
        }
        for (zzx zzx : this.zzbm) {
            if (zzx != null) {
                zzx.quit();
            }
        }
        zzm zzm2 = new zzm(this.zzbk, this.zzbl, this.zzn, this.zzo);
        this.zzbn = zzm2;
        zzm2.start();
        for (int i = 0; i < this.zzbm.length; i++) {
            zzx zzx2 = new zzx(this.zzbl, this.zzai, this.zzn, this.zzo);
            this.zzbm[i] = zzx2;
            zzx2.start();
        }
    }

    public final <T> zzab<T> zzd(zzab<T> zzab) {
        zzab.zza(this);
        synchronized (this.zzbj) {
            this.zzbj.add(zzab);
        }
        zzab.zze(this.zzbi.incrementAndGet());
        zzab.zzc("add-to-queue");
        zzb(zzab, 0);
        if (!zzab.zzh()) {
            this.zzbl.add(zzab);
        } else {
            this.zzbk.add(zzab);
        }
        return zzab;
    }

    /* access modifiers changed from: package-private */
    public final <T> void zze(zzab<T> zzab) {
        synchronized (this.zzbj) {
            this.zzbj.remove(zzab);
        }
        synchronized (this.zzbo) {
            for (zzah zzf : this.zzbo) {
                zzf.zzf(zzab);
            }
        }
        zzb(zzab, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzab<?> zzab, int i) {
        synchronized (this.zzbp) {
            for (zzae zza : this.zzbp) {
                zza.zza(zzab, i);
            }
        }
    }
}
