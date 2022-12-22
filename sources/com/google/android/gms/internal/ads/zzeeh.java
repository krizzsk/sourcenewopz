package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeeh extends zzecu<zzegz> {
    zzeeh() {
        super(zzegz.class, new zzeek(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public final zzecx<zzehc, zzegz> zzbbn() {
        return new zzeej(this, zzehc.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzegz zzegz = (zzegz) zzeon;
        zzeku.zzab(zzegz.getVersion(), 0);
        if (zzegz.zzbcc().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzegz.zzo(zzelq, zzemn.zzbiv());
    }
}
