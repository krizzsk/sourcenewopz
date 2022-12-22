package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdls<R> implements zzdrx {
    public final Executor executor;
    public final String zzbvf;
    public final zzvq zzdvn;
    public final zzwc zzhdy;
    public final zzdmj<R> zzhkh;
    public final zzdmm zzhki;
    @Nullable
    private final zzdri zzhkj;

    public zzdls(zzdmj<R> zzdmj, zzdmm zzdmm, zzvq zzvq, String str, Executor executor2, zzwc zzwc, @Nullable zzdri zzdri) {
        this.zzhkh = zzdmj;
        this.zzhki = zzdmm;
        this.zzdvn = zzvq;
        this.zzbvf = str;
        this.executor = executor2;
        this.zzhdy = zzwc;
        this.zzhkj = zzdri;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    @Nullable
    public final zzdri zzavp() {
        return this.zzhkj;
    }

    public final zzdrx zzavq() {
        return new zzdls(this.zzhkh, this.zzhki, this.zzdvn, this.zzbvf, this.executor, this.zzhdy, this.zzhkj);
    }
}
