package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcog implements zzesa<String> {
    private final zzesn<Context> zzeyq;

    private zzcog(zzesn<Context> zzesn) {
        this.zzeyq = zzesn;
    }

    public static zzcog zzac(zzesn<Context> zzesn) {
        return new zzcog(zzesn);
    }

    public static String zzck(Context context) {
        return (String) zzesg.zzbd(context.getPackageName());
    }

    public final /* synthetic */ Object get() {
        return zzck(this.zzeyq.get());
    }
}
