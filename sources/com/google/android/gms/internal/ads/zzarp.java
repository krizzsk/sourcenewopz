package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzarp {
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zzdrz;
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomClickListener zzdsa;
    private NativeCustomFormatAd zzdsb;

    public zzarp(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zzdrz = onCustomFormatAdLoadedListener;
        this.zzdsa = onCustomClickListener;
    }

    public final zzagd zzwd() {
        return new zzarq(this);
    }

    public final zzafy zzug() {
        if (this.zzdsa == null) {
            return null;
        }
        return new zzarr(this);
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzc(zzafo zzafo) {
        if (this.zzdsb != null) {
            return this.zzdsb;
        }
        zzart zzart = new zzart(zzafo);
        this.zzdsb = zzart;
        return zzart;
    }
}
