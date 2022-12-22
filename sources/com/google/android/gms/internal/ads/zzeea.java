package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeea extends zzecu<zzegm> {
    zzeea() {
        super(zzegm.class, new zzedz(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public final zzecx<zzegn, zzegm> zzbbn() {
        return new zzeec(this, zzegn.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzegm zzegm = (zzegm) zzeon;
        zzeku.zzab(zzegm.getVersion(), 0);
        zzeku.zzgc(zzegm.zzbcc().size());
        if (zzegm.zzbda().zzbcx() != 12 && zzegm.zzbda().zzbcx() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzegm.zzi(zzelq, zzemn.zzbiv());
    }
}
