package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbya implements zzesa<Set<zzbzl<zzbtm>>> {
    private final zzbxr zzgdc;

    private zzbya(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbya zzn(zzbxr zzbxr) {
        return new zzbya(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamv());
    }
}
