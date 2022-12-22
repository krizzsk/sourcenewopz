package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedu extends zzecu<zzegb> {
    zzedu() {
        super(zzegb.class, new zzedt(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public final zzecx<zzege, zzegb> zzbbn() {
        return new zzedw(this, zzege.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzegb zzegb = (zzegb) zzeon;
        zzeku.zzab(zzegb.getVersion(), 0);
        new zzedv();
        zzedv.zza(zzegb.zzbck());
        new zzefm();
        zzefm.zza(zzegb.zzbcl());
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzegb.zze(zzelq, zzemn.zzbiv());
    }
}
