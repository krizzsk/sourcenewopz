package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeem extends zzecu<zzeio> {
    zzeem() {
        super(zzeio.class, new zzeel(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.REMOTE;
    }

    public final zzecx<zzeir, zzeio> zzbbn() {
        return new zzeeo(this, zzeir.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzeku.zzab(((zzeio) zzeon).getVersion(), 0);
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzeio.zzv(zzelq, zzemn.zzbiv());
    }
}
