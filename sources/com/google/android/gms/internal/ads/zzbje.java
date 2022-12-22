package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbje implements zzdmz {
    private final /* synthetic */ zzbie zzfhy;
    private zzesn<Context> zzfop;
    private zzesn<String> zzfoq;
    private zzesn<zzvt> zzfqm;
    private zzesn<zzczm> zzfqn;
    private zzesn<zzdnb> zzfre;
    private zzesn<zzdmr> zzfrf;
    private zzesn<zzdak> zzfrg;

    private zzbje(zzbie zzbie, Context context, String str, zzvt zzvt) {
        this.zzfhy = zzbie;
        this.zzfop = zzesd.zzbb(context);
        this.zzfqm = zzesd.zzbb(zzvt);
        this.zzfoq = zzesd.zzbb(str);
        this.zzfqn = zzesb.zzas(zzdae.zzaj(this.zzfhy.zzeze));
        this.zzfre = zzesb.zzas(zzdnx.zzaq(this.zzfhy.zzfba));
        zzesn<zzdmr> zzas = zzesb.zzas(new zzdna(this.zzfop, this.zzfhy.zzezf, this.zzfhy.zzeym, this.zzfqn, this.zzfre, zzdpn.zzawc()));
        this.zzfrf = zzas;
        this.zzfrg = zzesb.zzas(new zzdam(this.zzfop, this.zzfqm, this.zzfoq, zzas, this.zzfqn, this.zzfre));
    }

    public final zzdak zzaiw() {
        return this.zzfrg.get();
    }
}
