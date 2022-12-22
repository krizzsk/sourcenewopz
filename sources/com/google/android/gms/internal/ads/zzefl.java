package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzefl extends zzecu<zzefw> {
    zzefl() {
        super(zzefw.class, new zzefk(zzeda.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    /* access modifiers changed from: private */
    public static void zza(zzega zzega) throws GeneralSecurityException {
        if (zzega.zzbch() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzega.zzbch() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzfc(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zzecx<zzefx, zzefw> zzbbn() {
        return new zzefn(this, zzefx.class);
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzefw zzefw = (zzefw) zzeon;
        zzeku.zzab(zzefw.getVersion(), 0);
        zzfc(zzefw.zzbcc().size());
        zza(zzefw.zzbcd());
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzefw.zzc(zzelq, zzemn.zzbiv());
    }
}
