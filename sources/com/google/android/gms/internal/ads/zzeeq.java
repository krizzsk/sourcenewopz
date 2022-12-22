package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeeq extends zzecu<zzeis> {
    zzeeq() {
        super(zzeis.class, new zzeep(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.REMOTE;
    }

    public final zzecx<zzeiv, zzeis> zzbbn() {
        return new zzees(this, zzeiv.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzeku.zzab(((zzeis) zzeon).getVersion(), 0);
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzeis.zzx(zzelq, zzemn.zzbiv());
    }
}
