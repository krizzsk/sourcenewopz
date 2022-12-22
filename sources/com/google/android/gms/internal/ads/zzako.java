package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzako<AdT> extends AdManagerInterstitialAd {
    private final Context context;
    private final zzvr zzacy = zzvr.zzciq;
    private AppEventListener zzbtf;
    private final String zzbvf;
    private FullScreenContentCallback zzbvj;
    private OnPaidEventListener zzbvk;
    private final zzxq zzbvo;

    public zzako(Context context2, String str) {
        this.context = context2;
        this.zzbvf = str;
        this.zzbvo = zzww.zzqx().zzb(context2, new zzvt(), str, new zzank());
    }

    public final String getAdUnitId() {
        return this.zzbvf;
    }

    public final void zza(zzzl zzzl, AdLoadCallback<AdT> adLoadCallback) {
        try {
            this.zzbvo.zza(zzvr.zza(this.context, zzzl), (zzxd) new zzvm(adLoadCallback, this));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzzc zzzc = null;
        try {
            if (this.zzbvo != null) {
                zzzc = this.zzbvo.zzkm();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzzc);
    }

    public final void show(Activity activity) {
        if (activity == null) {
            zzbao.zzez("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzbvo.zze(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbvo.setImmersiveMode(z);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzbvk = onPaidEventListener;
            this.zzbvo.zza((zzyx) new zzaaq(onPaidEventListener));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzbvk;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzbvj = fullScreenContentCallback;
            this.zzbvo.zza((zzyg) new zzwy(fullScreenContentCallback));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbvj;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbtf;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbtf = appEventListener;
            this.zzbvo.zza((zzxy) appEventListener != null ? new zzrl(appEventListener) : null);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
