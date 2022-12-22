package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdkt extends zzxp implements zzp, zzsi {
    private final String zzbvf;
    private final zzbhh zzgxu;
    private final Context zzham;
    private AtomicBoolean zzhhy = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final zzdkd zzhia;
    private zzblz zzhic;
    private final zzdkr zzhjb;
    private long zzhjc = -1;
    protected zzbmz zzhjd;

    public zzdkt(zzbhh zzbhh, Context context, String str, zzdkr zzdkr, zzdkd zzdkd) {
        this.zzgxu = zzbhh;
        this.zzham = context;
        this.zzbvf = str;
        this.zzhjb = zzdkr;
        this.zzhia = zzdkd;
        zzdkd.zza((zzp) this);
    }

    public final boolean isReady() {
        return false;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final void stopLoading() {
    }

    public final void zza(zzasr zzasr) {
    }

    public final void zza(zzasx zzasx, String str) {
    }

    public final void zza(zzavn zzavn) {
    }

    public final void zza(zzvq zzvq, zzxd zzxd) {
    }

    public final void zza(zzwx zzwx) {
    }

    public final void zza(zzxc zzxc) {
    }

    public final void zza(zzxt zzxt) {
    }

    public final void zza(zzxy zzxy) {
    }

    public final void zza(zzyg zzyg) {
    }

    public final void zza(zzyx zzyx) {
    }

    public final void zza(zzzj zzzj) {
    }

    public final void zzbl(String str) {
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final IObjectWrapper zzki() {
        return null;
    }

    public final zzxy zzkn() {
        return null;
    }

    public final zzxc zzko() {
        return null;
    }

    public final void zza(zzwc zzwc) {
        this.zzhjb.zza(zzwc);
    }

    public final synchronized boolean zza(zzvq zzvq) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzr.zzkv();
        if (zzj.zzbc(this.zzham) && zzvq.zzcip == null) {
            zzd.zzex("Failed to load the ad because app ID is missing.");
            this.zzhia.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, (String) null, (zzvh) null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzhhy = new AtomicBoolean();
            return this.zzhjb.zza(zzvq, this.zzbvf, new zzdky(this), new zzdkx(this));
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzbmz zzbmz) {
        zzbmz.zza(this);
    }

    public final void zza(zzl zzl) {
        int i = zzdla.zzhjg[zzl.ordinal()];
        if (i == 1) {
            zzej(zzbmf.zzfwc);
        } else if (i == 2) {
            zzej(zzbmf.zzfwb);
        } else if (i == 3) {
            zzej(zzbmf.zzfwd);
        } else if (i == 4) {
            zzej(zzbmf.zzfwf);
        }
    }

    public final synchronized void onUserLeaveHint() {
        if (this.zzhjd != null) {
            this.zzhjd.zzb(zzr.zzlc().elapsedRealtime() - this.zzhjc, zzbmf.zzfwa);
        }
    }

    public final void zzmz() {
        zzej(zzbmf.zzfwc);
    }

    public final synchronized void zzvz() {
        if (this.zzhjd != null) {
            this.zzhjc = zzr.zzlc().elapsedRealtime();
            int zzakb = this.zzhjd.zzakb();
            if (zzakb > 0) {
                zzblz zzblz = new zzblz(this.zzgxu.zzafw(), zzr.zzlc());
                this.zzhic = zzblz;
                zzblz.zza(zzakb, new zzdkv(this));
            }
        }
    }

    private final synchronized void zzej(int i) {
        if (this.zzhhy.compareAndSet(false, true)) {
            this.zzhia.onAdClosed();
            if (this.zzhic != null) {
                zzr.zzky().zzb(this.zzhic);
            }
            if (this.zzhjd != null) {
                long j = -1;
                if (this.zzhjc != -1) {
                    j = zzr.zzlc().elapsedRealtime() - this.zzhjc;
                }
                this.zzhjd.zzb(j, i);
            }
            destroy();
        }
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhjd != null) {
            this.zzhjd.destroy();
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zza(zzsq zzsq) {
        this.zzhia.zzb(zzsq);
    }

    public final synchronized void zza(zzvt zzvt) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final synchronized boolean isLoading() {
        return this.zzhjb.isLoading();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbvf;
    }

    public final synchronized zzzc zzkm() {
        return null;
    }

    public final synchronized zzvt zzkk() {
        return null;
    }

    public final synchronized void showInterstitial() {
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized String zzkl() {
        return null;
    }

    public final synchronized void zzkj() {
    }

    public final synchronized void zza(zzye zzye) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    public final synchronized zzzd getVideoController() {
        return null;
    }

    public final synchronized void zza(zzaaz zzaaz) {
    }

    public final synchronized void zza(zzacm zzacm) {
    }

    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavf() {
        this.zzgxu.zzafv().execute(new zzdkw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavg() {
        zzej(zzbmf.zzfwe);
    }
}
