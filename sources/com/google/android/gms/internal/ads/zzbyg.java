package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyg implements zzesa<Set<zzbzl<zzbvb>>> {
    private final zzbxr zzgdc;

    private zzbyg(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyg zzu(zzbxr zzbxr) {
        return new zzbyg(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzanb());
    }
}
