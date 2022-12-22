package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeer extends zzecu<zzejb> {
    zzeer() {
        super(zzejb.class, new zzeeu(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public final zzecx<zzejc, zzejb> zzbbn() {
        return new zzeet(this, zzejc.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzejb zzejb = (zzejb) zzeon;
        zzeku.zzab(zzejb.getVersion(), 0);
        if (zzejb.zzbcc().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzejb.zzz(zzelq, zzemn.zzbiv());
    }
}
