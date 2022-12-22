package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyd implements zzesa<Set<zzbzl<zzbtq>>> {
    private final zzbxr zzgdc;

    private zzbyd(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyd zzq(zzbxr zzbxr) {
        return new zzbyd(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamz());
    }
}
