package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeeb extends zzecu<zzegr> {
    zzeeb() {
        super(zzegr.class, new zzeee(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public final zzecx<zzegu, zzegr> zzbbn() {
        return new zzeed(this, zzegu.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzegr zzegr = (zzegr) zzeon;
        zzeku.zzab(zzegr.getVersion(), 0);
        zzeku.zzgc(zzegr.zzbcc().size());
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzegr.zzk(zzelq, zzemn.zzbiv());
    }
}
