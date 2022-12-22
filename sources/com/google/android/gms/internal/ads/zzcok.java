package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcok implements zzesa<zzdtx> {
    private final zzesn<String> zzgno;

    private zzcok(zzesn<String> zzesn) {
        this.zzgno = zzesn;
    }

    public static zzcok zzae(zzesn<String> zzesn) {
        return new zzcok(zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzdtx) zzesg.zzbd(zzdtx.zzgz(this.zzgno.get()));
    }
}
