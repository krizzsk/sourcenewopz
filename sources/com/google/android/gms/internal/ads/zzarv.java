package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzarv extends zzagq {
    private final NativeAd.UnconfirmedClickListener zzdsg;

    public zzarv(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdsg = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.zzdsg.onUnconfirmedClickReceived(str);
    }

    public final void onUnconfirmedClickCancelled() {
        this.zzdsg.onUnconfirmedClickCancelled();
    }
}
