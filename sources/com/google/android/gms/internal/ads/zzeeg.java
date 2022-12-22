package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeeg extends zzecu<zzegv> {
    zzeeg() {
        super(zzegv.class, new zzeef(zzecn.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public final zzecx<zzegy, zzegv> zzbbn() {
        return new zzeei(this, zzegy.class);
    }

    private static boolean zzbbz() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void zzbv(boolean z) throws GeneralSecurityException {
        if (zzbbz()) {
            zzedl.zza(new zzeeg(), true);
        }
    }

    public final /* synthetic */ void zzc(zzeon zzeon) throws GeneralSecurityException {
        zzegv zzegv = (zzegv) zzeon;
        zzeku.zzab(zzegv.getVersion(), 0);
        zzeku.zzgc(zzegv.zzbcc().size());
    }

    public final /* synthetic */ zzeon zzp(zzelq zzelq) throws zzenn {
        return zzegv.zzm(zzelq, zzemn.zzbiv());
    }
}
