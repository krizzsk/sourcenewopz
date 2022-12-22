package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdp implements zzesa<zzcdm> {
    private final zzesn<zzcdd> zzggr;

    private zzcdp(zzesn<zzcdd> zzesn) {
        this.zzggr = zzesn;
    }

    public static zzcdp zzz(zzesn<zzcdd> zzesn) {
        return new zzcdp(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcdm(this.zzggr.get());
    }
}
