package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzczx implements zzdma {
    private final Pair zzhbe;

    zzczx(Pair pair) {
        this.zzhbe = pair;
    }

    public final void zzp(Object obj) {
        Pair pair = this.zzhbe;
        ((zzxy) obj).onAppEvent((String) pair.first, (String) pair.second);
    }
}
