package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrf implements zzesa<zzcrd> {
    private final zzesn<Set<zzcrc>> zzgoo;
    private final zzesn<zzdtx> zzgst;

    private zzcrf(zzesn<Set<zzcrc>> zzesn, zzesn<zzdtx> zzesn2) {
        this.zzgoo = zzesn;
        this.zzgst = zzesn2;
    }

    public static zzcrf zzan(zzesn<Set<zzcrc>> zzesn, zzesn<zzdtx> zzesn2) {
        return new zzcrf(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrd(this.zzgoo.get(), this.zzgst.get());
    }
}
