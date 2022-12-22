package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzlm {
    public final zzkh zzasz;
    public final zzlu zzbab = new zzlu();
    public zzls zzbac;
    public zzlg zzbad;
    public int zzbae;
    public int zzbaf;
    public int zzbag;
    public zzkk zzbah;
    public zzlr zzbai;

    public zzlm(zzkh zzkh) {
        this.zzasz = zzkh;
    }

    public final void zza(zzls zzls, zzlg zzlg) {
        this.zzbac = (zzls) zzpg.checkNotNull(zzls);
        this.zzbad = (zzlg) zzpg.checkNotNull(zzlg);
        this.zzasz.zze(zzls.zzaij);
        reset();
    }

    public final void reset() {
        zzlu zzlu = this.zzbab;
        zzlu.zzbbc = 0;
        zzlu.zzbbp = 0;
        zzlu.zzbbj = false;
        zzlu.zzbbo = false;
        zzlu.zzbbl = null;
        this.zzbae = 0;
        this.zzbag = 0;
        this.zzbaf = 0;
        this.zzbah = null;
        this.zzbai = null;
    }
}
