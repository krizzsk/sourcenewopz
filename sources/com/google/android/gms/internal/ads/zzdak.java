package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdak extends zzxp {
    private final zzvt zzbpy;
    private final String zzbvf;
    private final Context zzham;
    private final zzczm zzhas;
    private final zzdmr zzhbh;
    private final zzdnb zzhbi;
    /* access modifiers changed from: private */
    public zzcaj zzhbj;
    private boolean zzhbk = ((Boolean) zzww.zzra().zzd(zzabq.zzcpl)).booleanValue();

    public zzdak(Context context, zzvt zzvt, String str, zzdmr zzdmr, zzczm zzczm, zzdnb zzdnb) {
        this.zzbpy = zzvt;
        this.zzbvf = str;
        this.zzham = context;
        this.zzhbh = zzdmr;
        this.zzhas = zzczm;
        this.zzhbi = zzdnb;
    }

    public final zzzd getVideoController() {
        return null;
    }

    public final void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final void stopLoading() {
    }

    public final void zza(zzaaz zzaaz) {
    }

    public final void zza(zzasr zzasr) {
    }

    public final void zza(zzasx zzasx, String str) {
    }

    public final void zza(zzsq zzsq) {
    }

    public final void zza(zzvt zzvt) {
    }

    public final void zza(zzwc zzwc) {
    }

    public final void zza(zzwx zzwx) {
    }

    public final void zza(zzye zzye) {
    }

    public final void zza(zzzj zzzj) {
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzki() {
        return null;
    }

    public final void zzkj() {
    }

    public final zzvt zzkk() {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.internal.ads.zzvq r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x0054 }
            android.content.Context r0 = r4.zzham     // Catch:{ all -> 0x0054 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzj.zzbc(r0)     // Catch:{ all -> 0x0054 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzvf r0 = r5.zzcip     // Catch:{ all -> 0x0054 }
            if (r0 != 0) goto L_0x002d
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.zzd.zzex(r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzczm r5 = r4.zzhas     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzczm r5 = r4.zzhas     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdqj r0 = com.google.android.gms.internal.ads.zzdqj.APP_ID_MISSING     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzvh r0 = com.google.android.gms.internal.ads.zzdqh.zza(r0, r2, r2)     // Catch:{ all -> 0x0054 }
            r5.zzd((com.google.android.gms.internal.ads.zzvh) r0)     // Catch:{ all -> 0x0054 }
        L_0x002b:
            monitor-exit(r4)
            return r1
        L_0x002d:
            boolean r0 = r4.zzati()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0035
            monitor-exit(r4)
            return r1
        L_0x0035:
            android.content.Context r0 = r4.zzham     // Catch:{ all -> 0x0054 }
            boolean r1 = r5.zzcid     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdqa.zze(r0, r1)     // Catch:{ all -> 0x0054 }
            r4.zzhbj = r2     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdmr r0 = r4.zzhbh     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = r4.zzbvf     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdms r2 = new com.google.android.gms.internal.ads.zzdms     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzvt r3 = r4.zzbpy     // Catch:{ all -> 0x0054 }
            r2.<init>(r3)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdan r3 = new com.google.android.gms.internal.ads.zzdan     // Catch:{ all -> 0x0054 }
            r3.<init>(r4)     // Catch:{ all -> 0x0054 }
            boolean r5 = r0.zza(r5, r1, r2, r3)     // Catch:{ all -> 0x0054 }
            monitor-exit(r4)
            return r5
        L_0x0054:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdak.zza(com.google.android.gms.internal.ads.zzvq):boolean");
    }

    public final void zza(zzvq zzvq, zzxd zzxd) {
        this.zzhas.zza(zzxd);
        zza(zzvq);
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzhbj == null) {
            zzd.zzez("Interstitial can not be shown before loaded.");
            this.zzhas.zzk(zzdqh.zza(zzdqj.NOT_READY, (String) null, (zzvh) null));
            return;
        }
        this.zzhbj.zzb(this.zzhbk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(zzyg zzyg) {
        this.zzhas.zzb(zzyg);
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzalk().zzcg((Context) null);
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzalk().zzce((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzalk().zzcf((Context) null);
        }
    }

    public final void zza(zzxc zzxc) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzhas.zzc(zzxc);
    }

    public final void zza(zzxy zzxy) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzhas.zzb(zzxy);
    }

    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzb(this.zzhbk, (Activity) null);
        }
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhbj == null || this.zzhbj.zzall() == null) {
            return null;
        }
        return this.zzhbj.zzall().getMediationAdapterClassName();
    }

    public final synchronized String zzkl() {
        if (this.zzhbj == null || this.zzhbj.zzall() == null) {
            return null;
        }
        return this.zzhbj.zzall().getMediationAdapterClassName();
    }

    public final synchronized zzzc zzkm() {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return null;
        }
        if (this.zzhbj == null) {
            return null;
        }
        return this.zzhbj.zzall();
    }

    public final synchronized boolean isLoading() {
        return this.zzhbh.isLoading();
    }

    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzati();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbvf;
    }

    public final zzxy zzkn() {
        return this.zzhas.zzatf();
    }

    public final zzxc zzko() {
        return this.zzhas.zzate();
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzhbk = z;
    }

    public final synchronized void zza(zzacm zzacm) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzhbh.zza(zzacm);
    }

    private final synchronized boolean zzati() {
        return this.zzhbj != null && !this.zzhbj.isClosed();
    }

    public final void zza(zzyx zzyx) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzhas.zzb(zzyx);
    }

    public final void zza(zzxt zzxt) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zza(zzavn zzavn) {
        this.zzhbi.zzb(zzavn);
    }
}
