package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyf implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzbxr zzgdc;

    private zzbyf(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyf zzs(zzbxr zzbxr) {
        return new zzbyf(zzbxr);
    }

    public static Set<zzbzl<zzbuj>> zzt(zzbxr zzbxr) {
        return (Set) zzesg.zzbd(zzbxr.zzamt());
    }

    public final /* synthetic */ Object get() {
        return zzt(this.zzgdc);
    }
}
