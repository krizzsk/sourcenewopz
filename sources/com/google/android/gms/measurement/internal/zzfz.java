package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzfz implements Callable<List<zzks>> {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgm zzd;

    zzfz(zzgm zzgm, String str, String str2, String str3) {
        this.zzd = zzgm;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzG();
        return this.zzd.zza.zzi().zzm(this.zza, this.zzb, this.zzc);
    }
}
