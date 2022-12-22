package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbow implements zzesa<zzbox> {
    private final zzesn<zzdot> zzfua;
    private final zzesn<zzbtl> zzfyc;
    private final zzesn<zzbun> zzfyd;

    private zzbow(zzesn<zzdot> zzesn, zzesn<zzbtl> zzesn2, zzesn<zzbun> zzesn3) {
        this.zzfua = zzesn;
        this.zzfyc = zzesn2;
        this.zzfyd = zzesn3;
    }

    public static zzbow zzf(zzesn<zzdot> zzesn, zzesn<zzbtl> zzesn2, zzesn<zzbun> zzesn3) {
        return new zzbow(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzbox(this.zzfua.get(), this.zzfyc.get(), this.zzfyd.get());
    }
}
