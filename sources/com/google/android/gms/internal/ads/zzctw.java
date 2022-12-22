package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzctw implements Runnable {
    private final zzbfi zzewn;

    private zzctw(zzbfi zzbfi) {
        this.zzewn = zzbfi;
    }

    static Runnable zze(zzbfi zzbfi) {
        return new zzctw(zzbfi);
    }

    public final void run() {
        this.zzewn.zzaes();
    }
}
