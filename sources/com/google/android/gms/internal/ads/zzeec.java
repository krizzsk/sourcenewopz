package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeec extends zzecx<zzegn, zzegm> {
    private final /* synthetic */ zzeea zziga;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeec(zzeea zzeea, Class cls) {
        super(cls);
        this.zziga = zzeea;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        zzegn zzegn = (zzegn) zzeon;
        return (zzegm) ((zzena) zzegm.zzbdb().zzv(zzelq.zzt(zzekt.zzgb(zzegn.getKeySize()))).zzb(zzegn.zzbda()).zzfh(0).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzegn.zzj(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzegn zzegn = (zzegn) zzeon;
        zzeku.zzgc(zzegn.getKeySize());
        if (zzegn.zzbda().zzbcx() != 12 && zzegn.zzbda().zzbcx() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
