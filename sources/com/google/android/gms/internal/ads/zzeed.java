package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeed extends zzecx<zzegu, zzegr> {
    private final /* synthetic */ zzeeb zzigb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeed(zzeeb zzeeb, Class cls) {
        super(cls);
        this.zzigb = zzeeb;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        return (zzegr) ((zzena) zzegr.zzbdg().zzw(zzelq.zzt(zzekt.zzgb(((zzegu) zzeon).getKeySize()))).zzfi(0).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzegu.zzl(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzeku.zzgc(((zzegu) zzeon).getKeySize());
    }
}
