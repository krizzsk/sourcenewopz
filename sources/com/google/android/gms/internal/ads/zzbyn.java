package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyn implements zzesa<Set<zzbzl<zzbzq>>> {
    private final zzbxr zzgdc;

    private zzbyn(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyn zzab(zzbxr zzbxr) {
        return new zzbyn(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
