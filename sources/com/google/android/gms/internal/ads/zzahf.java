package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzahf implements Runnable {
    private final /* synthetic */ AdManagerAdView zzdhu;
    private final /* synthetic */ zzxq zzdhv;
    private final /* synthetic */ zzahc zzdhw;

    zzahf(zzahc zzahc, AdManagerAdView adManagerAdView, zzxq zzxq) {
        this.zzdhw = zzahc;
        this.zzdhu = adManagerAdView;
        this.zzdhv = zzxq;
    }

    public final void run() {
        if (this.zzdhu.zza(this.zzdhv)) {
            this.zzdhw.zzdhs.onAdManagerAdViewLoaded(this.zzdhu);
        } else {
            zzbao.zzez("Could not bind.");
        }
    }
}
