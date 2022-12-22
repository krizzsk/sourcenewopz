package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvc implements zzesa<zzcux> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzcbj> zzgvz;
    private final zzesn<zzail> zzgwa;

    public zzcvc(zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdpm> zzesn3, zzesn<Executor> zzesn4, zzesn<zzcbj> zzesn5, zzesn<zzcja> zzesn6, zzesn<zzail> zzesn7) {
        this.zzeyq = zzesn;
        this.zzfvj = zzesn2;
        this.zzfxn = zzesn3;
        this.zzfxf = zzesn4;
        this.zzgvz = zzesn5;
        this.zzgiz = zzesn6;
        this.zzgwa = zzesn7;
    }

    public final /* synthetic */ Object get() {
        return new zzcux(this.zzeyq.get(), this.zzfvj.get(), this.zzfxn.get(), this.zzfxf.get(), this.zzgvz.get(), this.zzgiz.get(), this.zzgwa.get());
    }
}
