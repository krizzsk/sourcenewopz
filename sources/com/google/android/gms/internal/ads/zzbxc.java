package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxc implements zzesa<zzbwx> {
    private final zzesn<Set<zzbzl<zzbxb>>> zzfxl;

    private zzbxc(zzesn<Set<zzbzl<zzbxb>>> zzesn) {
        this.zzfxl = zzesn;
    }

    public static zzbxc zzq(zzesn<Set<zzbzl<zzbxb>>> zzesn) {
        return new zzbxc(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbwx(this.zzfxl.get());
    }
}
