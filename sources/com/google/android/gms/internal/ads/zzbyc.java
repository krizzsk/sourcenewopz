package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyc implements zzesa<Set<zzbzl<zzbsy>>> {
    private final zzbxr zzgdc;

    private zzbyc(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyc zzp(zzbxr zzbxr) {
        return new zzbyc(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzams());
    }
}
