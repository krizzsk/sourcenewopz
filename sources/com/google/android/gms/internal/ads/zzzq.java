package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzzq extends zzwv {
    private final /* synthetic */ zzzn zzclf;

    zzzq(zzzn zzzn) {
        this.zzclf = zzzn;
    }

    public final void onAdLoaded() {
        this.zzclf.zzcks.zza(this.zzclf.zzdz());
        super.onAdLoaded();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzclf.zzcks.zza(this.zzclf.zzdz());
        super.onAdFailedToLoad(i);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzclf.zzcks.zza(this.zzclf.zzdz());
        super.onAdFailedToLoad(loadAdError);
    }
}
