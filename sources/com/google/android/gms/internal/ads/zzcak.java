package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzcak {
    private final zzbfi zzdkm;
    private final zzcbr zzgdq;

    public zzcak(zzcbr zzcbr) {
        this(zzcbr, (zzbfi) null);
    }

    public zzcak(zzcbr zzcbr, zzbfi zzbfi) {
        this.zzgdq = zzcbr;
        this.zzdkm = zzbfi;
    }

    public final zzcbr zzann() {
        return this.zzgdq;
    }

    public final zzbfi zzajy() {
        return this.zzdkm;
    }

    public final View zzano() {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            return zzbfi.getWebView();
        }
        return null;
    }

    public final View zzanp() {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi == null) {
            return null;
        }
        return zzbfi.getWebView();
    }

    public Set<zzbzl<zzbsy>> zzb(zzbrx zzbrx) {
        return Collections.singleton(zzbzl.zzb(zzbrx, zzbat.zzekj));
    }

    public Set<zzbzl<zzbza>> zzc(zzbrx zzbrx) {
        return Collections.singleton(zzbzl.zzb(zzbrx, zzbat.zzekj));
    }

    public final zzbzl<zzbwy> zzb(Executor executor) {
        return new zzbzl<>(new zzcam(this.zzdkm), executor);
    }
}
