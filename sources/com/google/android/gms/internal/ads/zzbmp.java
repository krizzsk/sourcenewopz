package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbmp extends zzbpc {
    private final View view;
    private final zzbfi zzdkm;
    private final zzdow zzfvv;
    private final int zzfvw;
    private final boolean zzfvx;
    private final boolean zzfvy;
    private zzsv zzfwk;
    private final zzbme zzfwl;

    zzbmp(zzbpf zzbpf, View view2, zzbfi zzbfi, zzdow zzdow, int i, boolean z, boolean z2, zzbme zzbme) {
        super(zzbpf);
        this.view = view2;
        this.zzdkm = zzbfi;
        this.zzfvv = zzdow;
        this.zzfvw = i;
        this.zzfvx = z;
        this.zzfvy = z2;
        this.zzfwl = zzbme;
    }

    public final zzdow zzakk() {
        return zzdpr.zza(this.zzeux.zzhmg, this.zzfvv);
    }

    public final View zzakl() {
        return this.view;
    }

    public final int zzakb() {
        return this.zzfvw;
    }

    public final boolean zzakc() {
        return this.zzfvx;
    }

    public final boolean zzakd() {
        return this.zzfvy;
    }

    public final boolean zzadm() {
        zzbfi zzbfi = this.zzdkm;
        return (zzbfi == null || zzbfi.zzaef() == null || !this.zzdkm.zzaef().zzadm()) ? false : true;
    }

    public final boolean zzakm() {
        zzbfi zzbfi = this.zzdkm;
        return zzbfi != null && zzbfi.zzaeh();
    }

    public final void zza(zzsi zzsi) {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            zzbfi.zza(zzsi);
        }
    }

    public final void zza(zzsv zzsv) {
        this.zzfwk = zzsv;
    }

    public final zzsv zzakn() {
        return this.zzfwk;
    }

    public final void zzb(long j, int i) {
        this.zzfwl.zzb(j, i);
    }
}
