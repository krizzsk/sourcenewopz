package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzsl extends zzst {
    private final AppOpenAd.AppOpenAdLoadCallback zzbve;
    private final String zzbvf;

    public zzsl(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zzbve = appOpenAdLoadCallback;
        this.zzbvf = str;
    }

    public final void zza(zzsp zzsp) {
        if (this.zzbve != null) {
            zzsn zzsn = new zzsn(zzsp, this.zzbvf);
            this.zzbve.onAppOpenAdLoaded(zzsn);
            this.zzbve.onAdLoaded(zzsn);
        }
    }

    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbve;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }

    public final void zza(zzvh zzvh) {
        if (this.zzbve != null) {
            LoadAdError zzqi = zzvh.zzqi();
            this.zzbve.onAppOpenAdFailedToLoad(zzqi);
            this.zzbve.onAdFailedToLoad(zzqi);
        }
    }
}
