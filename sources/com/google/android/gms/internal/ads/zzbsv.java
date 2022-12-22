package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsv implements zzesa<zzbst> {
    private final zzesn<Set<zzbzl<zzve>>> zzfxl;

    private zzbsv(zzesn<Set<zzbzl<zzve>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbsv zzg(zzesn<Set<zzbzl<zzve>>> zzesn) {
        return new zzbsv(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbst(this.zzfxl.get());
    }
}
