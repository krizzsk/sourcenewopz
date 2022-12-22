package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzctn implements zzesa<zzctg> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzbmt> zzgvz;
    private final zzesn<zzail> zzgwa;

    public zzctn(zzesn<zzbmt> zzesn, zzesn<Context> zzesn2, zzesn<Executor> zzesn3, zzesn<zzcja> zzesn4, zzesn<zzdpm> zzesn5, zzesn<zzbar> zzesn6, zzesn<zzail> zzesn7) {
        this.zzgvz = zzesn;
        this.zzeyq = zzesn2;
        this.zzfxf = zzesn3;
        this.zzgiz = zzesn4;
        this.zzfxn = zzesn5;
        this.zzgbl = zzesn6;
        this.zzgwa = zzesn7;
    }

    public final /* synthetic */ Object get() {
        return new zzctg(this.zzgvz.get(), this.zzeyq.get(), this.zzfxf.get(), this.zzgiz.get(), this.zzfxn.get(), this.zzgbl.get(), this.zzgwa.get());
    }
}
