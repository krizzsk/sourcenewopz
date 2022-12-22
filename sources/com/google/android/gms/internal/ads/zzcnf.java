package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnf implements Runnable {
    private final zzcna zzgpl;
    private final zzbbe zzgpn;

    zzcnf(zzcna zzcna, zzbbe zzbbe) {
        this.zzgpl = zzcna;
        this.zzgpn = zzbbe;
    }

    public final void run() {
        this.zzgpl.zza(this.zzgpn);
    }
}
