package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbkz implements zzbsy, zzbtm, zzbtq, zzbuj, zzve {
    /* access modifiers changed from: private */
    public final Context context;
    private final Executor executor;
    private final zzacv zzeut;
    /* access modifiers changed from: private */
    public final zzdpi zzftl;
    /* access modifiers changed from: private */
    public final zzdun zzftm;
    private final ScheduledExecutorService zzftq;
    /* access modifiers changed from: private */
    public final zzdot zzftr;
    /* access modifiers changed from: private */
    public final zzdpu zzfts;
    private final zzei zzftt;
    private final zzacw zzftu;
    private final WeakReference<View> zzftv;
    private boolean zzftw;
    private boolean zzftx;

    public zzbkz(Context context2, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdpi zzdpi, zzdot zzdot, zzdun zzdun, zzdpu zzdpu, View view, zzei zzei, zzacv zzacv, zzacw zzacw) {
        this.context = context2;
        this.executor = executor2;
        this.zzftq = scheduledExecutorService;
        this.zzftl = zzdpi;
        this.zzftr = zzdot;
        this.zzftm = zzdun;
        this.zzfts = zzdpu;
        this.zzftt = zzei;
        this.zzftv = new WeakReference<>(view);
        this.zzeut = zzacv;
        this.zzftu = zzacw;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
    }

    public final synchronized void onAdLoaded() {
        if (this.zzftw) {
            ArrayList arrayList = new ArrayList(this.zzftr.zzdnb);
            arrayList.addAll(this.zzftr.zzhmb);
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, true, (String) null, (String) null, arrayList));
        } else {
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, this.zzftr.zzhmd));
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, this.zzftr.zzhmb));
        }
        this.zzftw = true;
    }

    public final void onAdClicked() {
        if ((((Boolean) zzww.zzra().zzd(zzabq.zzcpb)).booleanValue() && this.zzftl.zzhnt.zzeuy.zzegd) || !zzadk.zzdep.get().booleanValue()) {
            zzdpu zzdpu = this.zzfts;
            zzdun zzdun = this.zzftm;
            zzdpi zzdpi = this.zzftl;
            zzdot zzdot = this.zzftr;
            List<String> zza = zzdun.zza(zzdpi, zzdot, zzdot.zzdna);
            zzr.zzkv();
            zzdpu.zza(zza, zzj.zzbd(this.context) ? zzcse.zzgui : zzcse.zzguh);
            return;
        }
        zzebh.zza(zzebc.zzg(this.zzftu.zza(this.context, this.zzeut.zzte(), this.zzeut.zztf())).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq), new zzbky(this), this.executor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAdImpression() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.zzftx     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzctj     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00aa }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00aa }
            r1 = 0
            if (r0 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzei r0 = r9.zzftt     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzdy r0 = r0.zzcb()     // Catch:{ all -> 0x00aa }
            android.content.Context r2 = r9.context     // Catch:{ all -> 0x00aa }
            java.lang.ref.WeakReference<android.view.View> r3 = r9.zzftv     // Catch:{ all -> 0x00aa }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x00aa }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x00aa }
            java.lang.String r1 = r0.zza((android.content.Context) r2, (android.view.View) r3, (android.app.Activity) r1)     // Catch:{ all -> 0x00aa }
        L_0x002c:
            r5 = r1
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcpb     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00aa }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00aa }
            r8 = 1
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.internal.ads.zzdpi r0 = r9.zzftl     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzdpg r0 = r0.zzhnt     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzdoy r0 = r0.zzeuy     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.zzegd     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            if (r0 != 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzacy<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzadk.zzdeq     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00aa }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x005e
            goto L_0x008f
        L_0x005e:
            com.google.android.gms.internal.ads.zzacw r0 = r9.zzftu     // Catch:{ all -> 0x00aa }
            android.content.Context r1 = r9.context     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzebt r0 = r0.zzk(r1)     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzebc r0 = com.google.android.gms.internal.ads.zzebc.zzg(r0)     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabq.zzcqd     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00aa }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x00aa }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00aa }
            long r1 = r1.longValue()     // Catch:{ all -> 0x00aa }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00aa }
            java.util.concurrent.ScheduledExecutorService r4 = r9.zzftq     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzebc r0 = r0.zza((long) r1, (java.util.concurrent.TimeUnit) r3, (java.util.concurrent.ScheduledExecutorService) r4)     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzblb r1 = new com.google.android.gms.internal.ads.zzblb     // Catch:{ all -> 0x00aa }
            r1.<init>(r9, r5)     // Catch:{ all -> 0x00aa }
            java.util.concurrent.Executor r2 = r9.executor     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzebh.zza(r0, r1, r2)     // Catch:{ all -> 0x00aa }
            r9.zzftx = r8     // Catch:{ all -> 0x00aa }
            goto L_0x00a8
        L_0x008f:
            com.google.android.gms.internal.ads.zzdpu r0 = r9.zzfts     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzdun r1 = r9.zzftm     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzdpi r2 = r9.zzftl     // Catch:{ all -> 0x00aa }
            com.google.android.gms.internal.ads.zzdot r3 = r9.zzftr     // Catch:{ all -> 0x00aa }
            r4 = 0
            r6 = 0
            com.google.android.gms.internal.ads.zzdot r7 = r9.zzftr     // Catch:{ all -> 0x00aa }
            java.util.List<java.lang.String> r7 = r7.zzdnb     // Catch:{ all -> 0x00aa }
            java.util.List r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00aa }
            r0.zzj(r1)     // Catch:{ all -> 0x00aa }
            r9.zzftx = r8     // Catch:{ all -> 0x00aa }
            monitor-exit(r9)
            return
        L_0x00a8:
            monitor-exit(r9)
            return
        L_0x00aa:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkz.onAdImpression():void");
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
        zzdpu zzdpu = this.zzfts;
        zzdun zzdun = this.zzftm;
        zzdot zzdot = this.zzftr;
        zzdpu.zzj(zzdun.zza(zzdot, zzdot.zzdxy, zzavd));
    }

    public final void onRewardedVideoStarted() {
        zzdpu zzdpu = this.zzfts;
        zzdun zzdun = this.zzftm;
        zzdpi zzdpi = this.zzftl;
        zzdot zzdot = this.zzftr;
        zzdpu.zzj(zzdun.zza(zzdpi, zzdot, zzdot.zzdxx));
    }

    public final void onRewardedVideoCompleted() {
        zzdpu zzdpu = this.zzfts;
        zzdun zzdun = this.zzftm;
        zzdpi zzdpi = this.zzftl;
        zzdot zzdot = this.zzftr;
        zzdpu.zzj(zzdun.zza(zzdpi, zzdot, zzdot.zzhmc));
    }

    public final void zzk(zzvh zzvh) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrs)).booleanValue()) {
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, zzdun.zza(2, zzvh.errorCode, this.zzftr.zzhme)));
        }
    }
}
