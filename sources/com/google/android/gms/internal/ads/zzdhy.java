package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhy implements zzdhe<zzdhv> {
    private final Executor executor;
    private final PackageInfo zzdvo;
    private final int zzgsm;
    private final zzazo zzhgy;
    private final String zzhhc;

    public zzdhy(zzazo zzazo, Executor executor2, String str, PackageInfo packageInfo, int i) {
        this.zzhgy = zzazo;
        this.executor = executor2;
        this.zzhhc = str;
        this.zzdvo = packageInfo;
        this.zzgsm = i;
    }

    public final zzebt<zzdhv> zzatu() {
        return zzebh.zzb(zzebh.zzb(this.zzhgy.zza(this.zzhhc, this.zzdvo, this.zzgsm), zzdhx.zzebv, this.executor), Throwable.class, new zzdia(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzg(Throwable th) throws Exception {
        return zzebh.zzag(new zzdhv(this.zzhhc));
    }
}
