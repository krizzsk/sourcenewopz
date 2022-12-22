package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcj implements zzesa<zzdck> {
    private final zzesn<zzdpm> zzfxn;

    private zzdcj(zzesn<zzdpm> zzesn) {
        this.zzfxn = zzesn;
    }

    public static zzdcj zzak(zzesn<zzdpm> zzesn) {
        return new zzdcj(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzdck(this.zzfxn.get());
    }
}
