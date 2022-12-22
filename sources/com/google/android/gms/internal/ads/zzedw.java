package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzedw extends zzecx<zzege, zzegb> {
    private final /* synthetic */ zzedu zzify;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzedw(zzedu zzedu, Class cls) {
        super(cls);
        this.zzify = zzedu;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        zzege zzege = (zzege) zzeon;
        return (zzegb) ((zzena) zzegb.zzbcm().zzc((zzegf) new zzedv().zzbbn().zze(zzege.zzbco())).zzc((zzehu) new zzefm().zzbbn().zze(zzege.zzbcp())).zzff(0).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzege.zzf(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzege zzege = (zzege) zzeon;
        new zzedv().zzbbn().zzd(zzege.zzbco());
        new zzefm().zzbbn().zzd(zzege.zzbcp());
        zzeku.zzgc(zzege.zzbco().getKeySize());
    }
}
