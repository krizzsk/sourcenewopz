package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrm implements zzesa<zzcrl> {
    private final zzesn<zzcrj> zzfew;
    private final zzesn<zzebs> zzgtb;

    private zzcrm(zzesn<zzcrj> zzesn, zzesn<zzebs> zzesn2) {
        this.zzfew = zzesn;
        this.zzgtb = zzesn2;
    }

    public static zzcrm zzaq(zzesn<zzcrj> zzesn, zzesn<zzebs> zzesn2) {
        return new zzcrm(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrl(this.zzfew.get(), this.zzgtb.get());
    }
}
