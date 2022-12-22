package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
class zzeft implements zzedg<zzeda, zzeda> {
    private static final Logger logger = Logger.getLogger(zzeft.class.getName());

    zzeft() {
    }

    public final Class<zzeda> zzbbh() {
        return zzeda.class;
    }

    public final Class<zzeda> zzbbu() {
        return zzeda.class;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private static class zza implements zzeda {
        private final zzedc<zzeda> zzigq;
        private final byte[] zzihb;

        private zza(zzedc<zzeda> zzedc) {
            this.zzihb = new byte[]{0};
            this.zzigq = zzedc;
        }

        public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
            if (this.zzigq.zzbbp().zzbbs().equals(zzeiw.LEGACY)) {
                return zzejn.zza(this.zzigq.zzbbp().zzbbt(), this.zzigq.zzbbp().zzbbq().zzk(zzejn.zza(bArr, this.zzihb)));
            }
            return zzejn.zza(this.zzigq.zzbbp().zzbbt(), this.zzigq.zzbbp().zzbbq().zzk(bArr));
        }
    }

    public final /* synthetic */ Object zza(zzedc zzedc) throws GeneralSecurityException {
        return new zza(zzedc);
    }
}
