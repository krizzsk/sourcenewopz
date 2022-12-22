package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzefa extends zzecx<zzehi, zzehm> {
    private final /* synthetic */ zzeey zzign;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzefa(zzeey zzeey, Class cls) {
        super(cls);
        this.zzign = zzeey;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        zzehi zzehi = (zzehi) zzeon;
        KeyPair zza = zzejw.zza(zzejw.zza(zzefg.zza(zzehi.zzbds().zzbdu().zzbeh())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzehm) ((zzena) zzehm.zzbea().zzfm(0).zzb((zzehn) ((zzena) zzehn.zzbee().zzfn(0).zzc(zzehi.zzbds()).zzac(zzelq.zzt(w.getAffineX().toByteArray())).zzad(zzelq.zzt(w.getAffineY().toByteArray())).zzbjv())).zzab(zzelq.zzt(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzehi.zzq(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzefg.zza(((zzehi) zzeon).zzbds());
    }
}
