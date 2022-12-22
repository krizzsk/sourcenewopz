package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdgi implements zzeas {
    private final String zzdkl;
    private final zzdgg zzhfq;
    private final List zzhfs;
    private final Bundle zzhft;

    zzdgi(zzdgg zzdgg, String str, List list, Bundle bundle) {
        this.zzhfq = zzdgg;
        this.zzdkl = str;
        this.zzhfs = list;
        this.zzhft = bundle;
    }

    public final zzebt zzauk() {
        return this.zzhfq.zza(this.zzdkl, this.zzhfs, this.zzhft);
    }
}
