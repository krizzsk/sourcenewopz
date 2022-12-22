package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzakn extends zzakj {
    private final InstreamAd.InstreamAdLoadCallback zzdkj;

    public zzakn(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdkj = instreamAdLoadCallback;
    }

    public final void zza(zzaka zzaka) {
        this.zzdkj.onInstreamAdLoaded(new zzakl(zzaka));
    }

    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdkj.onInstreamAdFailedToLoad(i);
    }

    public final void zze(zzvh zzvh) {
        this.zzdkj.onInstreamAdFailedToLoad(zzvh.zzqi());
    }
}
