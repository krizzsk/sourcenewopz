package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzala implements Predicate {
    private final zzaig zzdkn;

    zzala(zzaig zzaig) {
        this.zzdkn = zzaig;
    }

    public final boolean apply(Object obj) {
        zzaig zzaig = (zzaig) obj;
        return (zzaig instanceof zzalc) && ((zzalc) zzaig).zzdko.equals(this.zzdkn);
    }
}
