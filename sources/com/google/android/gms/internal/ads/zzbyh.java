package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyh implements zzesa<Set<zzbzl<zzbus>>> {
    private final zzbxr zzgdc;

    private zzbyh(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyh zzv(zzbxr zzbxr) {
        return new zzbyh(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzana());
    }
}
