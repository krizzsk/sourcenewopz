package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdrz {
    private int zzhsg = 0;
    private final long zzhsh;
    private final zzdry zzhsi = new zzdry();
    private long zzhsj;
    private int zzhsk = 0;
    private int zzhsl = 0;

    public zzdrz() {
        long currentTimeMillis = zzr.zzlc().currentTimeMillis();
        this.zzhsh = currentTimeMillis;
        this.zzhsj = currentTimeMillis;
    }

    public final void zzaxm() {
        this.zzhsj = zzr.zzlc().currentTimeMillis();
        this.zzhsk++;
    }

    public final void zzaxn() {
        this.zzhsl++;
        this.zzhsi.zzhsf = true;
    }

    public final void zzaxo() {
        this.zzhsg++;
        this.zzhsi.zzhsg++;
    }

    public final long getCreationTimeMillis() {
        return this.zzhsh;
    }

    public final long zzawp() {
        return this.zzhsj;
    }

    public final int zzawq() {
        return this.zzhsk;
    }

    public final zzdry zzaxp() {
        zzdry zzdry = (zzdry) this.zzhsi.clone();
        zzdry zzdry2 = this.zzhsi;
        zzdry2.zzhsf = false;
        zzdry2.zzhsg = 0;
        return zzdry;
    }

    public final String zzaxc() {
        return "Created: " + this.zzhsh + " Last accessed: " + this.zzhsj + " Accesses: " + this.zzhsk + "\nEntries retrieved: Valid: " + this.zzhsl + " Stale: " + this.zzhsg;
    }
}
