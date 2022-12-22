package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxu implements zzesa<Set<zzbzl<zzbtp>>> {
    private final zzbxr zzgdc;

    private zzbxu(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbxu zzh(zzbxr zzbxr) {
        return new zzbxu(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
