package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdar {
    private final zzczm zzgcc;
    private final zzcdy zzhbw;
    private final zzbsz zzhbx;

    public zzdar(zzcdy zzcdy, zzdtw zzdtw) {
        this.zzhbw = zzcdy;
        zzczm zzczm = new zzczm(zzdtw);
        this.zzgcc = zzczm;
        this.zzhbx = new zzdaq(zzczm, this.zzhbw.zzaph());
    }

    public final void zzd(zzxc zzxc) {
        this.zzgcc.zzc(zzxc);
    }

    public final zzccb zzatk() {
        return new zzccb(this.zzhbw, this.zzgcc.zzate());
    }

    public final zzczm zzatl() {
        return this.zzgcc;
    }

    public final zzbuj zzatm() {
        return this.zzgcc;
    }

    public final zzbsz zzatn() {
        return this.zzhbx;
    }
}
