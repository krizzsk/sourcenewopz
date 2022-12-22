package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzsn extends AppOpenAd {
    private final String zzbvf;
    private final zzsp zzbvh;
    private final zzsm zzbvi = new zzsm();
    private FullScreenContentCallback zzbvj;
    private OnPaidEventListener zzbvk;

    public zzsn(zzsp zzsp, String str) {
        this.zzbvh = zzsp;
        this.zzbvf = str;
    }

    public final void show(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
        this.zzbvi.setFullScreenContentCallback(fullScreenContentCallback);
        if (activity == null) {
            zzbao.zzez("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzbvh.zza(ObjectWrapper.wrap(activity), this.zzbvi);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity) {
        try {
            this.zzbvh.zza(ObjectWrapper.wrap(activity), this.zzbvi);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzzc zzzc;
        try {
            zzzc = this.zzbvh.zzkm();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            zzzc = null;
        }
        return ResponseInfo.zza(zzzc);
    }

    public final String getAdUnitId() {
        return this.zzbvf;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
        this.zzbvi.setFullScreenContentCallback(fullScreenContentCallback);
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbvj;
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbvh.setImmersiveMode(z);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final zzxq zzea() {
        try {
            return this.zzbvh.zzea();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzsv zzsv) {
        try {
            this.zzbvh.zza(zzsv);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzbvk = onPaidEventListener;
        try {
            this.zzbvh.zza((zzyx) new zzaaq(onPaidEventListener));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzbvk;
    }
}
