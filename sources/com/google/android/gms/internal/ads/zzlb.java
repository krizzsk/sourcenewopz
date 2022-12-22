package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzlb implements zzkz {
    private final zzpn zzaxd;
    private final int zzaxl = this.zzaxd.zzje();
    private final int zzaxm = this.zzaxd.zzje();

    public zzlb(zzky zzky) {
        zzpn zzpn = zzky.zzaxd;
        this.zzaxd = zzpn;
        zzpn.zzbl(12);
    }

    public final int zzhb() {
        return this.zzaxm;
    }

    public final int zzhc() {
        int i = this.zzaxl;
        return i == 0 ? this.zzaxd.zzje() : i;
    }

    public final boolean zzhd() {
        return this.zzaxl != 0;
    }
}
