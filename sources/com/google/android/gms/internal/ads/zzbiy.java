package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbiy implements zzdli {
    private final /* synthetic */ zzbie zzfhy;
    private final Context zzfob;
    private final String zzfoc;
    private zzesn<Context> zzfop;
    private final zzvt zzfqd;
    private zzesn<zzvt> zzfqm;
    private zzesn<zzczm> zzfqn;
    private zzesn<zzdaj> zzfqo;
    private zzesn<zzdlc> zzfqp;

    private zzbiy(zzbie zzbie, Context context, String str, zzvt zzvt) {
        this.zzfhy = zzbie;
        this.zzfob = context;
        this.zzfqd = zzvt;
        this.zzfoc = str;
        this.zzfop = zzesd.zzbb(context);
        this.zzfqm = zzesd.zzbb(zzvt);
        this.zzfqn = zzesb.zzas(zzdae.zzaj(this.zzfhy.zzeze));
        this.zzfqo = zzesb.zzas(zzdai.zzath());
        this.zzfqp = zzesb.zzas(new zzdlf(this.zzfop, this.zzfhy.zzezf, this.zzfqm, this.zzfhy.zzeym, this.zzfqn, this.zzfqo, zzdpn.zzawc()));
    }

    public final zzczk zzaiq() {
        return new zzczk(this.zzfob, this.zzfqd, this.zzfoc, this.zzfqp.get(), this.zzfqn.get());
    }
}
