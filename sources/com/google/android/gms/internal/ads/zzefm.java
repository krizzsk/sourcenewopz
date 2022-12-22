package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzefm extends zzecu<zzehu> {
    public zzefm() {
        super(zzehu.class, new zzefp(zzeda.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public static void zza(zzehu zzehu) throws GeneralSecurityException {
        zzeku.zzab(zzehu.getVersion(), 0);
        if (zzehu.zzbcc().size() >= 16) {
            zza(zzehu.zzbem());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: private */
    public static void zza(zzehz zzehz) throws GeneralSecurityException {
        if (zzehz.zzbch() >= 10) {
            int i = zzefr.zzigw[zzehz.zzbes().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzehz.zzbch() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzehz.zzbch() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzehz.zzbch() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zzecx<zzehy, zzehu> zzbbn() {
        return new zzefo(this, zzehy.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zza((zzehu) zzeon);
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzehu.zzt(zzelq, zzemn.zzbiv());
    }
}
