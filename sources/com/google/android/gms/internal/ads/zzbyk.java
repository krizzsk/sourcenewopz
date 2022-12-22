package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyk implements zzesa<Set<zzbzl<zzqw>>> {
    private final zzbxr zzgdc;

    private zzbyk(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyk zzy(zzbxr zzbxr) {
        return new zzbyk(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
