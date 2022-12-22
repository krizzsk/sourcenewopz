package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdrr<AdT extends zzbpc> {
    /* access modifiers changed from: private */
    public final zzdqz zzhkm;
    private final zzdqs zzhrr;
    /* access modifiers changed from: private */
    public zzdrx zzhrs;
    /* access modifiers changed from: private */
    public zzecb<zzdrj<AdT>> zzhrt;
    private zzebt<zzdrj<AdT>> zzhru;
    /* access modifiers changed from: private */
    public int zzhrv = zzdrw.zzhsb;
    /* access modifiers changed from: private */
    public final zzdru<AdT> zzhrw;
    private final LinkedList<zzdrx> zzhrx;
    private final zzebi<zzdrj<AdT>> zzhry = new zzdrs(this);

    public zzdrr(zzdqz zzdqz, zzdqs zzdqs, zzdru<AdT> zzdru) {
        this.zzhkm = zzdqz;
        this.zzhrr = zzdqs;
        this.zzhrw = zzdru;
        this.zzhrx = new LinkedList<>();
        this.zzhrr.zza(new zzdrt(this));
    }

    public final void zzb(zzdrx zzdrx) {
        this.zzhrx.add(zzdrx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzebt<com.google.android.gms.internal.ads.zzdrv<AdT>> zzc(com.google.android.gms.internal.ads.zzdrx r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzaxj()     // Catch:{ all -> 0x0044 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            int r0 = com.google.android.gms.internal.ads.zzdrw.zzhsd     // Catch:{ all -> 0x0044 }
            r3.zzhrv = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdrx r0 = r3.zzhrs     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdri r0 = r0.zzavp()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdri r0 = r4.zzavp()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdrx r0 = r3.zzhrs     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdri r0 = r0.zzavp()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdri r2 = r4.zzavp()     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            int r0 = com.google.android.gms.internal.ads.zzdrw.zzhsc     // Catch:{ all -> 0x0044 }
            r3.zzhrv = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzecb<com.google.android.gms.internal.ads.zzdrj<AdT>> r0 = r3.zzhrt     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdrq r1 = new com.google.android.gms.internal.ads.zzdrq     // Catch:{ all -> 0x0044 }
            r1.<init>(r3)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.Executor r4 = r4.getExecutor()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzebt r4 = com.google.android.gms.internal.ads.zzebh.zzb(r0, r1, (java.util.concurrent.Executor) r4)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return r4
        L_0x0042:
            monitor-exit(r3)
            return r1
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrr.zzc(com.google.android.gms.internal.ads.zzdrx):com.google.android.gms.internal.ads.zzebt");
    }

    /* access modifiers changed from: private */
    public final void zzd(zzdrx zzdrx) {
        while (zzaxj()) {
            if (zzdrx != null || !this.zzhrx.isEmpty()) {
                if (zzdrx == null) {
                    zzdrx = this.zzhrx.remove();
                }
                if (zzdrx.zzavp() == null || !this.zzhkm.zzb(zzdrx.zzavp())) {
                    zzdrx = null;
                } else {
                    this.zzhrs = zzdrx.zzavq();
                    this.zzhrt = zzecb.zzbbf();
                    zzebt<zzdrj<AdT>> zza = this.zzhrw.zza(this.zzhrs);
                    this.zzhru = zza;
                    zzebh.zza(zza, this.zzhry, zzdrx.getExecutor());
                    return;
                }
            } else {
                return;
            }
        }
        if (zzdrx != null) {
            this.zzhrx.add(zzdrx);
        }
    }

    private final boolean zzaxj() {
        zzebt<zzdrj<AdT>> zzebt = this.zzhru;
        return zzebt == null || zzebt.isDone();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaxk() {
        synchronized (this) {
            zzd(this.zzhrs);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzc(zzdrj zzdrj) throws Exception {
        zzebt zzag;
        synchronized (this) {
            zzag = zzebh.zzag(new zzdrv(zzdrj, this.zzhrs));
        }
        return zzag;
    }
}
