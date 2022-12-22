package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdjp extends zzxp implements zzab, zzbus, zzsi {
    /* access modifiers changed from: private */
    public final zzbar zzbpj;
    private final String zzbvf;
    /* access modifiers changed from: private */
    public final ViewGroup zzfwu;
    private final zzbhh zzgxu;
    private final Context zzham;
    private AtomicBoolean zzhhy = new AtomicBoolean();
    private final zzdjn zzhhz;
    /* access modifiers changed from: private */
    public final zzdkd zzhia;
    private long zzhib = -1;
    private zzblz zzhic;
    protected zzbmp zzhid;

    public zzdjp(zzbhh zzbhh, Context context, String str, zzdjn zzdjn, zzdkd zzdkd, zzbar zzbar) {
        this.zzfwu = new FrameLayout(context);
        this.zzgxu = zzbhh;
        this.zzham = context;
        this.zzbvf = str;
        this.zzhhz = zzdjn;
        this.zzhia = zzdkd;
        zzdkd.zza((zzbus) this);
        this.zzbpj = zzbar;
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

    public final zzxy zzkn() {
        return null;
    }

    public final zzxc zzko() {
        return null;
    }

    public final IObjectWrapper zzki() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfwu);
    }

    public final void zza(zzwc zzwc) {
        this.zzhhz.zza(zzwc);
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
            return this.zzhhz.zza(zzvq, this.zzbvf, new zzdju(this), new zzdjt(this));
        }
    }

    /* access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.overlay.zzr zza(zzbmp zzbmp) {
        boolean zzadm = zzbmp.zzadm();
        int intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcwa)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = zzadm ? intValue : 0;
        zzq.paddingRight = zzadm ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        return new com.google.android.gms.ads.internal.overlay.zzr(this.zzham, zzq, this);
    }

    /* access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbmp zzbmp) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbmp.zzadm() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzbmp zzbmp) {
        zzbmp.zza((zzsi) this);
    }

    public final void zzwg() {
        zzej(zzbmf.zzfwd);
    }

    public final void zzmz() {
        zzej(zzbmf.zzfwc);
    }

    public final void zzamk() {
        if (this.zzhid != null) {
            this.zzhib = zzr.zzlc().elapsedRealtime();
            int zzakb = this.zzhid.zzakb();
            if (zzakb > 0) {
                zzblz zzblz = new zzblz(this.zzgxu.zzafw(), zzr.zzlc());
                this.zzhic = zzblz;
                zzblz.zza(zzakb, new zzdjr(this));
            }
        }
    }

    private final synchronized void zzej(int i) {
        if (this.zzhhy.compareAndSet(false, true)) {
            if (!(this.zzhid == null || this.zzhid.zzakn() == null)) {
                this.zzhia.zzb(this.zzhid.zzakn());
            }
            this.zzhia.onAdClosed();
            this.zzfwu.removeAllViews();
            if (this.zzhic != null) {
                zzr.zzky().zzb(this.zzhic);
            }
            if (this.zzhid != null) {
                long j = -1;
                if (this.zzhib != -1) {
                    j = zzr.zzlc().elapsedRealtime() - this.zzhib;
                }
                this.zzhid.zzb(j, i);
            }
            destroy();
        }
    }

    /* access modifiers changed from: private */
    public final zzvt zzavb() {
        return zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhid.zzakk()));
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhid != null) {
            this.zzhid.destroy();
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

    public final synchronized zzvt zzkk() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzhid == null) {
            return null;
        }
        return zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhid.zzakk()));
    }

    public final synchronized void zza(zzvt zzvt) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized String zzkl() {
        return null;
    }

    public final synchronized zzzc zzkm() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.zzhhz.isLoading();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbvf;
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
    public final /* synthetic */ void zzavc() {
        zzww.zzqw();
        if (zzbae.zzaaq()) {
            zzej(zzbmf.zzfwe);
        } else {
            this.zzgxu.zzafv().execute(new zzdjs(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavd() {
        zzej(zzbmf.zzfwe);
    }
}
