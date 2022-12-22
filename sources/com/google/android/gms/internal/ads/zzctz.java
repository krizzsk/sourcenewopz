package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzctz implements Runnable {
    private final zzbfi zzgji;
    private final zzcts zzgwg;

    zzctz(zzcts zzcts, zzbfi zzbfi) {
        this.zzgwg = zzcts;
        this.zzgji = zzbfi;
    }

    public final void run() {
        this.zzgwg.zzl(this.zzgji);
    }
}
