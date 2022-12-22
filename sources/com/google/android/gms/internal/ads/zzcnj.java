package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnj implements Runnable {
    private final String zzetx;
    private final zzcna zzgpl;
    private final zzdqd zzgpq;
    private final zzajo zzgpr;
    private final List zzgps;

    zzcnj(zzcna zzcna, zzdqd zzdqd, zzajo zzajo, List list, String str) {
        this.zzgpl = zzcna;
        this.zzgpq = zzdqd;
        this.zzgpr = zzajo;
        this.zzgps = list;
        this.zzetx = str;
    }

    public final void run() {
        this.zzgpl.zza(this.zzgpq, this.zzgpr, this.zzgps, this.zzetx);
    }
}
