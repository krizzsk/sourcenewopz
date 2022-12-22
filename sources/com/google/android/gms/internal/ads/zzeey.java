package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeey extends zzedi<zzehm, zzehn> {
    private static final byte[] zzigm = new byte[0];

    zzeey() {
        super(zzehm.class, zzehn.class, new zzeex(zzecr.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.ASYMMETRIC_PRIVATE;
    }

    public final zzecx<zzehi, zzehm> zzbbn() {
        return new zzefa(this, zzehi.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzehm zzehm = (zzehm) zzeon;
        if (!zzehm.zzbcc().isEmpty()) {
            zzeku.zzab(zzehm.getVersion(), 0);
            zzefg.zza(zzehm.zzbdz().zzbds());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzehm.zzr(zzelq, zzemn.zzbiv());
    }
}
