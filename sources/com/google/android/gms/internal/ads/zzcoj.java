package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcoj implements zzesa<zzcoz> {
    private final zzesn<Context> zzeyq;

    private zzcoj(zzesn<Context> zzesn) {
        this.zzeyq = zzesn;
    }

    public static zzcoj zzad(zzesn<Context> zzesn) {
        return new zzcoj(zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzcoz) zzesg.zzbd(new zzcoz(this.zzeyq.get()));
    }
}
