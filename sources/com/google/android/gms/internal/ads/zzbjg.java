package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbjg implements zzdol {
    private final /* synthetic */ zzbie zzfhy;
    private zzesn<Context> zzfop;
    private zzesn<String> zzfoq;
    private zzesn<zzdnb> zzfre;
    private zzesn<zzdmh<zzcis, zzcip>> zzfrh;
    private zzesn<zzdph> zzfri;
    private zzesn<zzdnz> zzfrj;
    private zzesn<zzdon> zzfrk;
    private zzesn<zzdoh> zzfrl;

    private zzbjg(zzbie zzbie, Context context, String str) {
        this.zzfhy = zzbie;
        zzesa zzbb = zzesd.zzbb(context);
        this.zzfop = zzbb;
        this.zzfrh = new zzdmq(zzbb, this.zzfhy.zzfba, this.zzfhy.zzfbb);
        this.zzfre = zzesb.zzas(zzdnx.zzaq(this.zzfhy.zzfba));
        this.zzfri = zzesb.zzas(zzdpk.zzawa());
        zzesn<zzdnz> zzas = zzesb.zzas(new zzdoi(this.zzfop, this.zzfhy.zzezf, this.zzfhy.zzeym, this.zzfrh, this.zzfre, zzdpn.zzawc(), this.zzfri));
        this.zzfrj = zzas;
        this.zzfrk = zzesb.zzas(new zzdos(zzas, this.zzfre, this.zzfri));
        zzesa zzbc = zzesd.zzbc(str);
        this.zzfoq = zzbc;
        this.zzfrl = zzesb.zzas(new zzdom(zzbc, this.zzfrj, this.zzfop, this.zzfre, this.zzfri));
    }

    public final zzdon zzaiy() {
        return this.zzfrk.get();
    }

    public final zzdoh zzaiz() {
        return this.zzfrl.get();
    }
}
