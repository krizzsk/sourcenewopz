package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzwv extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcjx;

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcjx = adListener;
        }
    }

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdFailedToLoad(loadAdError);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdLeftApplication();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdOpened();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdLoaded();
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.lock) {
            if (this.zzcjx != null) {
                this.zzcjx.onAdImpression();
            }
        }
    }
}
