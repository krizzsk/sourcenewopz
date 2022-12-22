package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import com.google.android.gms.internal.ads.zzegf;
import com.google.android.gms.internal.ads.zzegr;
import com.google.android.gms.internal.ads.zzehu;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzefi implements zzejq {
    private final String zzigr;
    private final int zzigs;
    private zzegr zzigt;
    private zzegb zzigu;
    private int zzigv;

    zzefi(zzeif zzeif) throws GeneralSecurityException {
        String zzbev = zzeif.zzbev();
        this.zzigr = zzbev;
        if (zzbev.equals(zzedr.zzifn)) {
            try {
                zzegu zzl = zzegu.zzl(zzeif.zzbew(), zzemn.zzbiv());
                this.zzigt = (zzegr) zzedl.zzb(zzeif);
                this.zzigs = zzl.getKeySize();
            } catch (zzenn e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zzigr.equals(zzedr.zzifm)) {
            try {
                zzege zzf = zzege.zzf(zzeif.zzbew(), zzemn.zzbiv());
                this.zzigu = (zzegb) zzedl.zzb(zzeif);
                this.zzigv = zzf.zzbco().getKeySize();
                this.zzigs = this.zzigv + zzf.zzbcp().getKeySize();
            } catch (zzenn e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(this.zzigr);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zzbcb() {
        return this.zzigs;
    }

    public final zzecn zzm(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzigs) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zzigr.equals(zzedr.zzifn)) {
            return (zzecn) zzedl.zza(this.zzigr, (zzeon) (zzegr) ((zzena) ((zzegr.zza) zzegr.zzbdg().zza(this.zzigt)).zzw(zzelq.zzi(bArr, 0, this.zzigs)).zzbjv()), zzecn.class);
        } else if (this.zzigr.equals(zzedr.zzifm)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzigv);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzigv, this.zzigs);
            zzegb.zza zzc = zzegb.zzbcm().zzff(this.zzigu.getVersion()).zzc((zzegf) ((zzena) ((zzegf.zza) zzegf.zzbcs().zza(this.zzigu.zzbck())).zzu(zzelq.zzt(copyOfRange)).zzbjv()));
            return (zzecn) zzedl.zza(this.zzigr, (zzeon) (zzegb) ((zzena) zzc.zzc((zzehu) ((zzena) ((zzehu.zza) zzehu.zzben().zza(this.zzigu.zzbcl())).zzae(zzelq.zzt(copyOfRange2)).zzbjv())).zzbjv()), zzecn.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
