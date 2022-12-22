package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcoa implements zzesa<ApplicationInfo> {
    private final zzesn<Context> zzeyq;

    private zzcoa(zzesn<Context> zzesn) {
        this.zzeyq = zzesn;
    }

    public static zzcoa zzab(zzesn<Context> zzesn) {
        return new zzcoa(zzesn);
    }

    public static ApplicationInfo zzcj(Context context) {
        return (ApplicationInfo) zzesg.zzbd(context.getApplicationInfo());
    }

    public final /* synthetic */ Object get() {
        return zzcj(this.zzeyq.get());
    }
}
