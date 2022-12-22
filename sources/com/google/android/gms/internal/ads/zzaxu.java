package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaxu implements zzesa<zzaxv> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<zzf> zzeck;

    public zzaxu(zzesn<zzf> zzesn, zzesn<zzayd> zzesn2) {
        this.zzeck = zzesn;
        this.zzecg = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzaxv(this.zzeck.get(), this.zzecg.get());
    }
}
