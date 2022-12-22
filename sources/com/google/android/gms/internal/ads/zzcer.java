package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcer implements zzesa<zzcen> {
    private final zzesn<zzf> zzeck;
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcdv> zzfkp;
    private final zzesn<zzcev> zzfkq;
    private final zzesn<zzcfd> zzfkr;
    private final zzesn<zzcdm> zzfkt;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcdr> zzgff;

    private zzcer(zzesn<zzf> zzesn, zzesn<zzdpm> zzesn2, zzesn<zzcdv> zzesn3, zzesn<zzcdr> zzesn4, zzesn<zzcev> zzesn5, zzesn<zzcfd> zzesn6, zzesn<Executor> zzesn7, zzesn<Executor> zzesn8, zzesn<zzcdm> zzesn9) {
        this.zzeck = zzesn;
        this.zzfxn = zzesn2;
        this.zzfkp = zzesn3;
        this.zzgff = zzesn4;
        this.zzfkq = zzesn5;
        this.zzfkr = zzesn6;
        this.zzfxf = zzesn7;
        this.zzeyl = zzesn8;
        this.zzfkt = zzesn9;
    }

    public static zzcer zza(zzesn<zzf> zzesn, zzesn<zzdpm> zzesn2, zzesn<zzcdv> zzesn3, zzesn<zzcdr> zzesn4, zzesn<zzcev> zzesn5, zzesn<zzcfd> zzesn6, zzesn<Executor> zzesn7, zzesn<Executor> zzesn8, zzesn<zzcdm> zzesn9) {
        return new zzcer(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7, zzesn8, zzesn9);
    }

    public final /* synthetic */ Object get() {
        return new zzcen(this.zzeck.get(), this.zzfxn.get(), this.zzfkp.get(), this.zzgff.get(), this.zzfkq.get(), this.zzfkr.get(), this.zzfxf.get(), this.zzeyl.get(), this.zzfkt.get());
    }
}
