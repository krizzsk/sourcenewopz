package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvm<AdT> extends zzxg {
    private final AdLoadCallback<AdT> zzchx;
    private final AdT zzchy;

    public zzvm(AdLoadCallback<AdT> adLoadCallback, AdT adt) {
        this.zzchx = adLoadCallback;
        this.zzchy = adt;
    }

    public final void onAdLoaded() {
        AdT adt;
        AdLoadCallback<AdT> adLoadCallback = this.zzchx;
        if (adLoadCallback != null && (adt = this.zzchy) != null) {
            adLoadCallback.onAdLoaded(adt);
        }
    }

    public final void zzd(zzvh zzvh) {
        AdLoadCallback<AdT> adLoadCallback = this.zzchx;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzvh.zzqi());
        }
    }
}
