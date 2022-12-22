package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbis implements zzdjv {
    private final /* synthetic */ zzbie zzfhy;
    private zzesn<Context> zzfop;
    private zzesn<String> zzfoq;
    private zzesn<zzdmh<zzbmg, zzbmp>> zzfor;
    private zzesn<zzdkd> zzfos;
    private zzesn<zzdjn> zzfot;
    private zzesn<zzdjp> zzfou;
    private zzesn<zzdmh<zzbmt, zzbmz>> zzfov;
    private zzesn<zzdkr> zzfow;
    private zzesn<zzdkt> zzfox;

    private zzbis(zzbie zzbie, Context context, String str) {
        this.zzfhy = zzbie;
        this.zzfop = zzesd.zzbb(context);
        this.zzfoq = zzesd.zzbb(str);
        this.zzfor = new zzdmn(this.zzfop, this.zzfhy.zzfba, this.zzfhy.zzfbb);
        this.zzfos = zzesb.zzas(new zzdks(this.zzfhy.zzfba));
        this.zzfot = zzesb.zzas(new zzdjq(this.zzfop, this.zzfhy.zzezf, this.zzfhy.zzeym, this.zzfor, this.zzfos, zzdpn.zzawc()));
        this.zzfou = zzesb.zzas(new zzdjw(this.zzfhy.zzeym, this.zzfop, this.zzfoq, this.zzfot, this.zzfos, this.zzfhy.zzeyy));
        this.zzfov = new zzdmo(this.zzfop, this.zzfhy.zzfba, this.zzfhy.zzfbb);
        this.zzfow = zzesb.zzas(new zzdku(this.zzfop, this.zzfhy.zzezf, this.zzfhy.zzeym, this.zzfov, this.zzfos, zzdpn.zzawc()));
        this.zzfox = zzesb.zzas(new zzdkz(this.zzfhy.zzeym, this.zzfop, this.zzfoq, this.zzfow, this.zzfos));
    }

    public final zzdjp zzaif() {
        return this.zzfou.get();
    }

    public final zzdkt zzaig() {
        return this.zzfox.get();
    }
}
