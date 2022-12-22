package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaxs implements zzesa<zzaxt> {
    private final zzesn<Context> zzece;
    private final zzesn<zzf> zzecf;
    private final zzesn<zzayd> zzecg;

    public zzaxs(zzesn<Context> zzesn, zzesn<zzf> zzesn2, zzesn<zzayd> zzesn3) {
        this.zzece = zzesn;
        this.zzecf = zzesn2;
        this.zzecg = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzaxt(this.zzece.get(), this.zzecf.get(), this.zzecg.get());
    }
}
