package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzx;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcie implements zzx {
    private final zzbty zzglr;

    private zzcie(zzbty zzbty) {
        this.zzglr = zzbty;
    }

    static zzx zza(zzbty zzbty) {
        return new zzcie(zzbty);
    }

    public final void zzws() {
        this.zzglr.onAdLeftApplication();
    }
}
