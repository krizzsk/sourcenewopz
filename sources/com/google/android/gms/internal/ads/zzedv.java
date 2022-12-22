package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedv extends zzecu<zzegf> {
    zzedv() {
        super(zzegf.class, new zzedy(zzekn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public static void zza(zzegf zzegf) throws GeneralSecurityException {
        zzeku.zzab(zzegf.getVersion(), 0);
        zzeku.zzgc(zzegf.zzbcc().size());
        zza(zzegf.zzbcr());
    }

    public final zzecx<zzegi, zzegf> zzbbn() {
        return new zzedx(this, zzegi.class);
    }

    /* access modifiers changed from: private */
    public static void zza(zzegj zzegj) throws GeneralSecurityException {
        if (zzegj.zzbcx() < 12 || zzegj.zzbcx() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zza((zzegf) zzeon);
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzegf.zzg(zzelq, zzemn.zzbiv());
    }
}
