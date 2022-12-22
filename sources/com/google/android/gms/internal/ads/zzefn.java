package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzefn extends zzecx<zzefx, zzefw> {
    zzefn(zzefl zzefl, Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        zzefx zzefx = (zzefx) zzeon;
        return (zzefw) ((zzena) zzefw.zzbce().zzfe(0).zzt(zzelq.zzt(zzekt.zzgb(zzefx.getKeySize()))).zzd(zzefx.zzbcd()).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzefx.zzd(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzefx zzefx = (zzefx) zzeon;
        zzefl.zza(zzefx.zzbcd());
        zzefl.zzfc(zzefx.getKeySize());
    }
}
