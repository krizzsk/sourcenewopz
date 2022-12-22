package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyb implements zzesa<Set<zzbzl<zzbsz>>> {
    private final zzbxr zzgdc;

    private zzbyb(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyb zzo(zzbxr zzbxr) {
        return new zzbyb(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamu());
    }
}
