package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxy implements zzesa<Set<zzbzl<zzve>>> {
    private final zzbxr zzgdc;

    private zzbxy(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbxy zzl(zzbxr zzbxr) {
        return new zzbxy(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamy());
    }
}
