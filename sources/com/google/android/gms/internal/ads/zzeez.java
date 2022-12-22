package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeez extends zzecu<zzehn> {
    public zzeez() {
        super(zzehn.class, new zzefc(zzecq.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzehn zzehn = (zzehn) zzeon;
        zzeku.zzab(zzehn.getVersion(), 0);
        zzefg.zza(zzehn.zzbds());
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzehn.zzs(zzelq, zzemn.zzbiv());
    }
}
