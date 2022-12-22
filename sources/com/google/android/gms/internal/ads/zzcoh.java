package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcoh implements zzesa<PackageInfo> {
    private final zzesn<Context> zzeyq;
    private final zzesn<ApplicationInfo> zzgqp;

    private zzcoh(zzesn<Context> zzesn, zzesn<ApplicationInfo> zzesn2) {
        this.zzeyq = zzesn;
        this.zzgqp = zzesn2;
    }

    public static zzcoh zzak(zzesn<Context> zzesn, zzesn<ApplicationInfo> zzesn2) {
        return new zzcoh(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return zzcnv.zza(this.zzeyq.get(), this.zzgqp.get());
    }
}
