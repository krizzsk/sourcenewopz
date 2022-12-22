package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxx implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzbxr zzgdc;

    private zzbxx(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbxx zzj(zzbxr zzbxr) {
        return new zzbxx(zzbxr);
    }

    public static Set<zzbzl<zzbuj>> zzk(zzbxr zzbxr) {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }

    public final /* synthetic */ Object get() {
        return zzk(this.zzgdc);
    }
}
