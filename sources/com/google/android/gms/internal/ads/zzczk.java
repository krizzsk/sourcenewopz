package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczk extends zzxp implements zzbvi {
    private final String zzbvf;
    /* access modifiers changed from: private */
    public zzbne zzhah;
    private final Context zzham;
    private final zzdpo zzhan;
    private final zzdlc zzhar;
    private final zzczm zzhas;
    private zzvt zzhat;

    public zzczk(Context context, zzvt zzvt, String str, zzdlc zzdlc, zzczm zzczm) {
        this.zzham = context;
        this.zzhar = zzdlc;
        this.zzhat = zzvt;
        this.zzbvf = str;
        this.zzhas = zzczm;
        this.zzhan = zzdlc.zzavi();
        zzdlc.zza((zzbvi) this);
    }

    public final boolean isReady() {
        return false;
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzasr zzasr) {
    }

    public final void zza(zzasx zzasx, String str) {
    }

    public final void zza(zzavn zzavn) {
    }

    public final void zza(zzsq zzsq) {
    }

    public final void zza(zzvq zzvq, zzxd zzxd) {
    }

    public final void zza(zzwc zzwc) {
    }

    public final void zza(zzyg zzyg) {
    }

    public final void zza(zzzj zzzj) {
    }

    public final void zzbl(String str) {
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final IObjectWrapper zzki() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzhar.zzavh());
    }

    public final synchronized boolean zza(zzvq zzvq) throws RemoteException {
        zzf(this.zzhat);
        return zzg(zzvq);
    }

    private final synchronized void zzf(zzvt zzvt) {
        this.zzhan.zzg(zzvt);
        this.zzhan.zzbr(this.zzhat.zzciy);
    }

    private final synchronized boolean zzg(zzvq zzvq) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzr.zzkv();
        if (!zzj.zzbc(this.zzham) || zzvq.zzcip != null) {
            zzdqa.zze(this.zzham, zzvq.zzcid);
            return this.zzhar.zza(zzvq, this.zzbvf, (zzdas) null, new zzczn(this));
        }
        zzd.zzex("Failed to load the ad because app ID is missing.");
        if (this.zzhas != null) {
            this.zzhas.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, (String) null, (zzvh) null));
        }
        return false;
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.destroy();
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.zzalk().zzce((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.zzalk().zzcf((Context) null);
        }
    }

    public final void zza(zzxc zzxc) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzhas.zzc(zzxc);
    }

    public final zzxc zzko() {
        return this.zzhas.zzate();
    }

    public final void zza(zzxy zzxy) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzhas.zzb(zzxy);
    }

    public final zzxy zzkn() {
        return this.zzhas.zzatf();
    }

    public final synchronized void zzkj() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.zzkj();
        }
    }

    public final synchronized zzvt zzkk() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzhah != null) {
            return zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhah.zzakk()));
        }
        return this.zzhan.zzkk();
    }

    public final synchronized void zza(zzvt zzvt) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzhan.zzg(zzvt);
        this.zzhat = zzvt;
        if (this.zzhah != null) {
            this.zzhah.zza(this.zzhar.zzavh(), zzvt);
        }
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhah == null || this.zzhah.zzall() == null) {
            return null;
        }
        return this.zzhah.zzall().getMediationAdapterClassName();
    }

    public final synchronized String zzkl() {
        if (this.zzhah == null || this.zzhah.zzall() == null) {
            return null;
        }
        return this.zzhah.zzall().getMediationAdapterClassName();
    }

    public final synchronized zzzc zzkm() {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return null;
        }
        if (this.zzhah == null) {
            return null;
        }
        return this.zzhah.zzall();
    }

    public final synchronized void zza(zzye zzye) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzhan.zzc(zzye);
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzhan.zzbs(z);
    }

    public final synchronized boolean isLoading() {
        return this.zzhar.isLoading();
    }

    public final synchronized zzzd getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzhah == null) {
            return null;
        }
        return this.zzhah.getVideoController();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbvf;
    }

    public final synchronized void zza(zzaaz zzaaz) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzhan.zzc(zzaaz);
    }

    public final void zza(zzwx zzwx) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzhar.zza(zzwx);
    }

    public final synchronized void zza(zzacm zzacm) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzhar.zza(zzacm);
    }

    public final synchronized void zzamo() {
        if (this.zzhar.zzavj()) {
            zzvt zzkk = this.zzhan.zzkk();
            if (!(this.zzhah == null || this.zzhah.zzakt() == null || !this.zzhan.zzawh())) {
                zzkk = zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhah.zzakt()));
            }
            zzf(zzkk);
            try {
                zzg(this.zzhan.zzawd());
            } catch (RemoteException unused) {
                zzd.zzez("Failed to refresh the banner ad.");
            }
        } else {
            this.zzhar.zzavk();
        }
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
}
