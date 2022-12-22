package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzla {
    public int index;
    public final int length;
    public int zzaxe;
    public long zzaxf;
    private final boolean zzaxg;
    private final zzpn zzaxh;
    private final zzpn zzaxi;
    private int zzaxj;
    private int zzaxk;

    public zzla(zzpn zzpn, zzpn zzpn2, boolean z) {
        this.zzaxi = zzpn;
        this.zzaxh = zzpn2;
        this.zzaxg = z;
        zzpn2.zzbl(12);
        this.length = zzpn2.zzje();
        zzpn.zzbl(12);
        this.zzaxk = zzpn.zzje();
        zzpg.checkState(zzpn.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzhe() {
        long j;
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        if (this.zzaxg) {
            j = this.zzaxh.zzjf();
        } else {
            j = this.zzaxh.zzjb();
        }
        this.zzaxf = j;
        if (this.index == this.zzaxj) {
            this.zzaxe = this.zzaxi.zzje();
            this.zzaxi.zzbm(4);
            int i2 = this.zzaxk - 1;
            this.zzaxk = i2;
            this.zzaxj = i2 > 0 ? this.zzaxi.zzje() - 1 : -1;
        }
        return true;
    }
}
