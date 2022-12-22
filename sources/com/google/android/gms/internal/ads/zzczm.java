package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczm implements AppEventListener, zzbsy, zzbsz, zzbtm, zzbtq, zzbuj, zzbvb, zzbvm, zzve {
    private final zzdtw zzdjf;
    private final AtomicReference<zzxc> zzhav = new AtomicReference<>();
    private final AtomicReference<zzxy> zzhaw = new AtomicReference<>();
    private final AtomicReference<zzyx> zzhax = new AtomicReference<>();
    private final AtomicReference<zzxd> zzhay = new AtomicReference<>();
    private final AtomicReference<zzyg> zzhaz = new AtomicReference<>();
    private final AtomicBoolean zzhba = new AtomicBoolean(true);
    private final BlockingQueue<Pair<String, String>> zzhbb = new ArrayBlockingQueue(((Integer) zzww.zzra().zzd(zzabq.zzdbp)).intValue());

    public zzczm(zzdtw zzdtw) {
        this.zzdjf = zzdtw;
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
    }

    public final void zzd(zzauj zzauj) {
    }

    public final synchronized zzxc zzate() {
        return this.zzhav.get();
    }

    public final synchronized zzxy zzatf() {
        return this.zzhaw.get();
    }

    public final void zzc(zzxc zzxc) {
        this.zzhav.set(zzxc);
    }

    public final void zzb(zzxy zzxy) {
        this.zzhaw.set(zzxy);
    }

    public final void zzb(zzyx zzyx) {
        this.zzhax.set(zzyx);
    }

    public final void zza(zzxd zzxd) {
        this.zzhay.set(zzxd);
    }

    public final void zzb(zzyg zzyg) {
        this.zzhaz.set(zzyg);
    }

    public final void zzd(zzdpi zzdpi) {
        this.zzhba.set(true);
    }

    public final void onAdClosed() {
        zzdlx.zza(this.zzhav, zzczp.zzhbd);
        zzdlx.zza(this.zzhaz, zzczo.zzhbd);
    }

    public final void zzd(zzvh zzvh) {
        zzdlx.zza(this.zzhav, new zzczw(zzvh));
        zzdlx.zza(this.zzhav, new zzczz(zzvh));
        zzdlx.zza(this.zzhay, new zzczy(zzvh));
        this.zzhba.set(false);
        this.zzhbb.clear();
    }

    public final void onAdLeftApplication() {
        zzdlx.zza(this.zzhav, zzdab.zzhbd);
    }

    public final synchronized void onAdLoaded() {
        zzdlx.zza(this.zzhav, zzdaa.zzhbd);
        zzdlx.zza(this.zzhay, zzdad.zzhbd);
        for (Pair zzczx : this.zzhbb) {
            zzdlx.zza(this.zzhaw, new zzczx(zzczx));
        }
        this.zzhbb.clear();
        this.zzhba.set(false);
    }

    public final void onAdOpened() {
        zzdlx.zza(this.zzhav, zzdac.zzhbd);
        zzdlx.zza(this.zzhaz, zzdaf.zzhbd);
        zzdlx.zza(this.zzhaz, zzczr.zzhbd);
    }

    public final void onAdClicked() {
        zzdlx.zza(this.zzhav, zzczq.zzhbd);
    }

    public final void onAdImpression() {
        zzdlx.zza(this.zzhav, zzczt.zzhbd);
    }

    public final void zzb(zzvv zzvv) {
        zzdlx.zza(this.zzhax, new zzczs(zzvv));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAppEvent(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzhba     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0038
            java.util.concurrent.BlockingQueue<android.util.Pair<java.lang.String, java.lang.String>> r0 = r3.zzhbb     // Catch:{ all -> 0x0044 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0044 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.ads.internal.util.zzd.zzdz(r0)     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdtw r0 = r3.zzdjf     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzdtw r0 = r3.zzdjf     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "dae_action"
            com.google.android.gms.internal.ads.zzdtx r1 = com.google.android.gms.internal.ads.zzdtx.zzgy(r1)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "dae_name"
            com.google.android.gms.internal.ads.zzdtx r4 = r1.zzw(r2, r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "dae_data"
            com.google.android.gms.internal.ads.zzdtx r4 = r4.zzw(r1, r5)     // Catch:{ all -> 0x0044 }
            r0.zzb(r4)     // Catch:{ all -> 0x0044 }
        L_0x0036:
            monitor-exit(r3)
            return
        L_0x0038:
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzxy> r0 = r3.zzhaw     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzczv r1 = new com.google.android.gms.internal.ads.zzczv     // Catch:{ all -> 0x0044 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdlx.zza(r0, r1)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczm.onAppEvent(java.lang.String, java.lang.String):void");
    }

    public final void zzk(zzvh zzvh) {
        zzdlx.zza(this.zzhaz, new zzczu(zzvh));
    }
}
