package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbxv implements zzesa<zzbsx> {
    private final zzbxr zzgdc;
    private final zzesn<Set<zzbzl<zzbsz>>> zzgdd;

    private zzbxv(zzbxr zzbxr, zzesn<Set<zzbzl<zzbsz>>> zzesn) {
        this.zzgdc = zzbxr;
        this.zzgdd = zzesn;
    }

    public static zzbxv zza(zzbxr zzbxr, zzesn<Set<zzbzl<zzbsz>>> zzesn) {
        return new zzbxv(zzbxr, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbsx) zzesg.zzbd(this.zzgdc.zzc(this.zzgdd.get()));
    }
}
