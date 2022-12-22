package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfz implements zzesa<zzdfx> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Bundle> zzhfl;

    private zzdfz(zzesn<zzebs> zzesn, zzesn<Bundle> zzesn2) {
        this.zzeyl = zzesn;
        this.zzhfl = zzesn2;
    }

    public static zzdfz zzaz(zzesn<zzebs> zzesn, zzesn<Bundle> zzesn2) {
        return new zzdfz(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzdfx(this.zzeyl.get(), this.zzhfl.get());
    }
}
