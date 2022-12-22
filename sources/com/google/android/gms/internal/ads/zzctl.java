package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzctl implements zzbtq {
    private final zzbfi zzewn;

    zzctl(zzbfi zzbfi) {
        this.zzewn = zzbfi;
    }

    public final void onAdImpression() {
        zzbfi zzbfi = this.zzewn;
        if (zzbfi.zzaef() != null) {
            zzbfi.zzaef().zzads();
        }
    }
}
