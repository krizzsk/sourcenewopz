package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcam implements zzbwy {
    private final zzbfi zzewn;

    zzcam(zzbfi zzbfi) {
        this.zzewn = zzbfi;
    }

    public final void zzakz() {
        zzbfi zzbfi = this.zzewn;
        if (zzbfi.zzaeb() != null) {
            zzbfi.zzaeb().close();
        }
    }
}
