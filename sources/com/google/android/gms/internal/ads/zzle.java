package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzle implements zzkz {
    private final zzpn zzaxd;
    private final int zzaxm = this.zzaxd.zzje();
    private final int zzaxp = (this.zzaxd.zzje() & 255);
    private int zzaxq;
    private int zzaxr;

    public zzle(zzky zzky) {
        zzpn zzpn = zzky.zzaxd;
        this.zzaxd = zzpn;
        zzpn.zzbl(12);
    }

    public final boolean zzhd() {
        return false;
    }

    public final int zzhb() {
        return this.zzaxm;
    }

    public final int zzhc() {
        int i = this.zzaxp;
        if (i == 8) {
            return this.zzaxd.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzaxd.readUnsignedShort();
        }
        int i2 = this.zzaxq;
        this.zzaxq = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzaxr & 15;
        }
        int readUnsignedByte = this.zzaxd.readUnsignedByte();
        this.zzaxr = readUnsignedByte;
        return (readUnsignedByte & 240) >> 4;
    }
}
