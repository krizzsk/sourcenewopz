package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvj extends zzxb {
    private final AdListener zzchw;

    public zzvj(AdListener adListener) {
        this.zzchw = adListener;
    }

    public final void onAdClosed() {
        this.zzchw.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzchw.onAdFailedToLoad(i);
    }

    public final void zzc(zzvh zzvh) {
        this.zzchw.onAdFailedToLoad(zzvh.zzqi());
    }

    public final void onAdLeftApplication() {
        this.zzchw.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzchw.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzchw.onAdOpened();
    }

    public final void onAdClicked() {
        this.zzchw.onAdClicked();
    }

    public final void onAdImpression() {
        this.zzchw.onAdImpression();
    }

    public final AdListener getAdListener() {
        return this.zzchw;
    }
}
