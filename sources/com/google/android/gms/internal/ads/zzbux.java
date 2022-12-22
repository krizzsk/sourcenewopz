package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbux implements zzesa<zzbur> {
    private final zzesn<Set<zzbzl<zzp>>> zzfxl;

    private zzbux(zzesn<Set<zzbzl<zzp>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbux zzo(zzesn<Set<zzbzl<zzp>>> zzesn) {
        return new zzbux(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbur(this.zzfxl.get());
    }
}
