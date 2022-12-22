package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzedq implements zzedg<zzecn, zzecn> {
    private static final Logger logger = Logger.getLogger(zzedq.class.getName());

    zzedq() {
    }

    public final Class<zzecn> zzbbh() {
        return zzecn.class;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private static class zza implements zzecn {
        private final zzedc<zzecn> zzifx;

        private zza(zzedc<zzecn> zzedc) {
            this.zzifx = zzedc;
        }

        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzejn.zza(this.zzifx.zzbbp().zzbbt(), this.zzifx.zzbbp().zzbbq().zzc(bArr, bArr2));
        }
    }

    public final Class<zzecn> zzbbu() {
        return zzecn.class;
    }

    public final /* synthetic */ Object zza(zzedc zzedc) throws GeneralSecurityException {
        return new zza(zzedc);
    }
}
