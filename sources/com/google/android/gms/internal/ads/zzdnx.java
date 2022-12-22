package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdnx implements zzesa<zzdnb> {
    private final zzesn<zzdqs> zzhja;

    private zzdnx(zzesn<zzdqs> zzesn) {
        this.zzhja = zzesn;
    }

    public static zzdnx zzaq(zzesn<zzdqs> zzesn) {
        return new zzdnx(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzdnb(this.zzhja.get());
    }
}
