package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrz implements zzesa<zzcru> {
    private final zzesn<zzf> zzecf;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcrr> zzfci;
    private final zzesn<zzcrl> zzfex;
    private final zzesn<zzbsc> zzgub;

    private zzcrz(zzesn<Context> zzesn, zzesn<zzbsc> zzesn2, zzesn<zzcrr> zzesn3, zzesn<zzcrl> zzesn4, zzesn<zzf> zzesn5) {
        this.zzeyq = zzesn;
        this.zzgub = zzesn2;
        this.zzfci = zzesn3;
        this.zzfex = zzesn4;
        this.zzecf = zzesn5;
    }

    public static zzcrz zzg(zzesn<Context> zzesn, zzesn<zzbsc> zzesn2, zzesn<zzcrr> zzesn3, zzesn<zzcrl> zzesn4, zzesn<zzf> zzesn5) {
        return new zzcrz(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzcru(this.zzeyq.get(), this.zzgub.get(), this.zzfci.get(), this.zzfex.get(), this.zzecf.get());
    }
}
