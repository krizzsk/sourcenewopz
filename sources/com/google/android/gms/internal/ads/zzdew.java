package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdew implements zzesa<zzdeu> {
    private final zzesn<zzebs> zzeyl;

    private zzdew(zzesn<zzebs> zzesn) {
        this.zzeyl = zzesn;
    }

    public static zzdew zzan(zzesn<zzebs> zzesn) {
        return new zzdew(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzdeu(this.zzeyl.get());
    }
}
