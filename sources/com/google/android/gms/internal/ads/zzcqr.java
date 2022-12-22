package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqr implements zzesa<zzcqb> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzauw> zzgsn;
    private final zzesn<zzbki> zzgso;
    private final zzesn<zzaux> zzgsp;
    private final zzesn<HashMap<String, zzcqm>> zzgsq;

    private zzcqr(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzauw> zzesn3, zzesn<zzbki> zzesn4, zzesn<zzaux> zzesn5, zzesn<HashMap<String, zzcqm>> zzesn6) {
        this.zzeyq = zzesn;
        this.zzfxf = zzesn2;
        this.zzgsn = zzesn3;
        this.zzgso = zzesn4;
        this.zzgsp = zzesn5;
        this.zzgsq = zzesn6;
    }

    public static zzcqr zzb(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzauw> zzesn3, zzesn<zzbki> zzesn4, zzesn<zzaux> zzesn5, zzesn<HashMap<String, zzcqm>> zzesn6) {
        return new zzcqr(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6);
    }

    public final /* synthetic */ Object get() {
        return new zzcqb(this.zzeyq.get(), this.zzfxf.get(), this.zzgsn.get(), this.zzgso.get(), this.zzgsp.get(), this.zzgsq.get());
    }
}
