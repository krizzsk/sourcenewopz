package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczg extends zzxp {
    private final Context context;
    private final ViewGroup zzfwu;
    private final zzdpm zzfzg;
    private final zzxc zzgef;
    private final zzbne zzhah;

    public zzczg(Context context2, zzxc zzxc, zzdpm zzdpm, zzbne zzbne) {
        this.context = context2;
        this.zzgef = zzxc;
        this.zzfzg = zzdpm;
        this.zzhah = zzbne;
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzhah.zzakl(), zzr.zzkx().zzzw());
        frameLayout.setMinimumHeight(zzkk().heightPixels);
        frameLayout.setMinimumWidth(zzkk().widthPixels);
        this.zzfwu = frameLayout;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void showInterstitial() throws RemoteException {
    }

    public final void stopLoading() throws RemoteException {
    }

    public final void zza(zzasr zzasr) throws RemoteException {
    }

    public final void zza(zzasx zzasx, String str) throws RemoteException {
    }

    public final void zza(zzavn zzavn) throws RemoteException {
    }

    public final void zza(zzsq zzsq) throws RemoteException {
    }

    public final void zza(zzvq zzvq, zzxd zzxd) {
    }

    public final void zza(zzwc zzwc) throws RemoteException {
    }

    public final void zza(zzyg zzyg) {
    }

    public final void zza(zzzj zzzj) throws RemoteException {
    }

    public final void zzbl(String str) throws RemoteException {
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final IObjectWrapper zzki() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfwu);
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzhah.destroy();
    }

    public final boolean zza(zzvq zzvq) throws RemoteException {
        zzd.zzey("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzhah.zzalk().zzce((Context) null);
    }

    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzhah.zzalk().zzcf((Context) null);
    }

    public final void zzkj() throws RemoteException {
        this.zzhah.zzkj();
    }

    public final zzvt zzkk() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdpr.zzb(this.context, Collections.singletonList(this.zzhah.zzakk()));
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        if (this.zzhah.zzall() != null) {
            return this.zzhah.zzall().getMediationAdapterClassName();
        }
        return null;
    }

    public final zzzd getVideoController() throws RemoteException {
        return this.zzhah.getVideoController();
    }

    public final String getAdUnitId() throws RemoteException {
        return this.zzfzg.zzhny;
    }

    public final zzxy zzkn() throws RemoteException {
        return this.zzfzg.zzhoe;
    }

    public final zzxc zzko() throws RemoteException {
        return this.zzgef;
    }

    public final String zzkl() throws RemoteException {
        if (this.zzhah.zzall() != null) {
            return this.zzhah.zzall().getMediationAdapterClassName();
        }
        return null;
    }

    public final zzzc zzkm() {
        return this.zzhah.zzall();
    }

    public final void zza(zzaaz zzaaz) throws RemoteException {
        zzd.zzey("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzvt zzvt) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbne zzbne = this.zzhah;
        if (zzbne != null) {
            zzbne.zza(this.zzfwu, zzvt);
        }
    }

    public final void zza(zzacm zzacm) throws RemoteException {
        zzd.zzey("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzwx zzwx) throws RemoteException {
        zzd.zzey("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzye zzye) throws RemoteException {
        zzd.zzey("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzd.zzey("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxc zzxc) throws RemoteException {
        zzd.zzey("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxy zzxy) throws RemoteException {
        zzd.zzey("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxt zzxt) throws RemoteException {
        zzd.zzey("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final Bundle getAdMetadata() throws RemoteException {
        zzd.zzey("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    public final void zza(zzyx zzyx) {
        zzd.zzey("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
