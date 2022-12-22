package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeei extends zzecx<zzegy, zzegv> {
    private final /* synthetic */ zzeeg zzigc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeei(zzeeg zzeeg, Class cls) {
        super(cls);
        this.zzigc = zzeeg;
    }

    public final /* synthetic */ Object zze(zzeon zzeon) throws GeneralSecurityException {
        return (zzegv) ((zzena) zzegv.zzbdj().zzx(zzelq.zzt(zzekt.zzgb(((zzegy) zzeon).getKeySize()))).zzfj(0).zzbjv());
    }

    public final /* synthetic */ zzeon zzr(zzelq zzelq) throws zzenn {
        return zzegy.zzn(zzelq, zzemn.zzbiv());
    }

    public final /* synthetic */ void zzd(zzeon zzeon) throws GeneralSecurityException {
        zzeku.zzgc(((zzegy) zzeon).getKeySize());
    }
}
