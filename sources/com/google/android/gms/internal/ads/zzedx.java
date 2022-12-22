package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedx extends zzecx<zzegi, zzegf> {
    private final /* synthetic */ zzedv zzifz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzedx(zzedv zzedv, Class cls) {
        super(cls);
        this.zzifz = zzedv;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        zzegi zzegi = (zzegi) zzeon;
        return (zzegf) ((zzena) zzegf.zzbcs().zzc(zzegi.zzbcr()).zzu(zzelq.zzt(zzekt.zzgb(zzegi.getKeySize()))).zzfg(0).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzegi.zzh(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzegi zzegi = (zzegi) zzeon;
        zzeku.zzgc(zzegi.getKeySize());
        zzedv.zza(zzegi.zzbcr());
    }
}
