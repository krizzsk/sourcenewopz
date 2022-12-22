package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbs implements zzesa<zzcbt> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzuh.zza.C22026zza> zzfvk;
    private final zzesn<zzbfi> zzfxc;
    private final zzesn<zzdot> zzfxz;

    private zzcbs(zzesn<Context> zzesn, zzesn<zzbfi> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzbar> zzesn4, zzesn<zzuh.zza.C22026zza> zzesn5) {
        this.zzeyq = zzesn;
        this.zzfxc = zzesn2;
        this.zzfxz = zzesn3;
        this.zzfsw = zzesn4;
        this.zzfvk = zzesn5;
    }

    public static zzcbs zzc(zzesn<Context> zzesn, zzesn<zzbfi> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzbar> zzesn4, zzesn<zzuh.zza.C22026zza> zzesn5) {
        return new zzcbs(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzcbt(this.zzeyq.get(), this.zzfxc.get(), this.zzfxz.get(), this.zzfsw.get(), this.zzfvk.get());
    }
}
