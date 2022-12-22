package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzyp extends zzyn {
    private final MuteThisAdListener zzcki;

    public zzyp(MuteThisAdListener muteThisAdListener) {
        this.zzcki = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.zzcki.onAdMuted();
    }
}
