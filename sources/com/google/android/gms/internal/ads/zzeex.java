package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeex extends zzecw<zzecr, zzehm> {
    zzeex(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) throws GeneralSecurityException {
        zzehm zzehm = (zzehm) obj;
        zzehj zzbds = zzehm.zzbdz().zzbds();
        zzehq zzbdu = zzbds.zzbdu();
        zzejy zza = zzefg.zza(zzbdu.zzbeh());
        byte[] byteArray = zzehm.zzbcc().toByteArray();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, byteArray), zzejw.zza(zza));
        return new zzejt((ECPrivateKey) zzekd.zzinp.zzhx("EC").generatePrivate(eCPrivateKeySpec), zzbdu.zzbej().toByteArray(), zzefg.zza(zzbdu.zzbei()), zzefg.zza(zzbds.zzbdw()), new zzefi(zzbds.zzbdv().zzbdp()));
    }
}
