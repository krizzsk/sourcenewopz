package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaxz extends zzayt {
    private zzesn<Context> zzece;
    private zzesn<zzayd> zzecg;
    private zzesn<zzf> zzeco;
    private zzesn<zzaxt> zzecp;
    private zzesn<zzaxv> zzecq;
    private zzesn<zzaxx> zzecr;
    private zzesn<zzayu> zzecs;

    private zzaxz(Context context, zzf zzf, zzayd zzayd) {
        this.zzece = zzesd.zzbb(context);
        this.zzeco = zzesd.zzbb(zzf);
        zzesa zzbb = zzesd.zzbb(zzayd);
        this.zzecg = zzbb;
        this.zzecp = zzesb.zzas(new zzaxs(this.zzece, this.zzeco, zzbb));
        zzesn<zzaxv> zzas = zzesb.zzas(new zzaxu(this.zzeco, this.zzecg));
        this.zzecq = zzas;
        zzaxw zzaxw = new zzaxw(zzas);
        this.zzecr = zzaxw;
        this.zzecs = zzesb.zzas(new zzayy(this.zzece, zzaxw));
    }

    /* access modifiers changed from: package-private */
    public final zzaxt zzxr() {
        return this.zzecp.get();
    }

    /* access modifiers changed from: package-private */
    public final zzaxx zzxs() {
        return new zzaxx(this.zzecq.get());
    }

    /* access modifiers changed from: package-private */
    public final zzayu zzxt() {
        return this.zzecs.get();
    }
}
