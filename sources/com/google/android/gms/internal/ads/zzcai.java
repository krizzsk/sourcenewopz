package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcai implements Runnable {
    private final zzbfi zzewn;

    private zzcai(zzbfi zzbfi) {
        this.zzewn = zzbfi;
    }

    static Runnable zze(zzbfi zzbfi) {
        return new zzcai(zzbfi);
    }

    public final void run() {
        this.zzewn.destroy();
    }
}
