package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzefo extends zzecx<zzehy, zzehu> {
    private final /* synthetic */ zzefm zzigz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzefo(zzefm zzefm, Class cls) {
        super(cls);
        this.zzigz = zzefm;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        zzehy zzehy = (zzehy) zzeon;
        return (zzehu) ((zzena) zzehu.zzben().zzfq(0).zzd(zzehy.zzbem()).zzae(zzelq.zzt(zzekt.zzgb(zzehy.getKeySize()))).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzehy.zzu(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzehy zzehy = (zzehy) zzeon;
        if (zzehy.getKeySize() >= 16) {
            zzefm.zza(zzehy.zzbem());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
