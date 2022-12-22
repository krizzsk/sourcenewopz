package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpi {
    public final List<? extends zzebt<? extends zzbpc>> zzfys;

    public zzbpi(List<? extends zzebt<? extends zzbpc>> list) {
        this.zzfys = list;
    }

    public zzbpi(zzbpc zzbpc) {
        this.zzfys = Collections.singletonList(zzebh.zzag(zzbpc));
    }

    public static zzcsz<zzbpi> zza(zzcvm<? extends zzbpc> zzcvm) {
        return new zzcsy(zzcvm, zzbpl.zzebv);
    }

    public static zzcsz<zzbpi> zza(zzcsz<? extends zzbpc> zzcsz) {
        return new zzcsy(zzcsz, zzbpk.zzebv);
    }
}
