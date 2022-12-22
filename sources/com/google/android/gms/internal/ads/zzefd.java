package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzefd implements zzedg<zzecr, zzecr> {
    private static final Logger logger = Logger.getLogger(zzefd.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private static class zza implements zzecr {
        private final zzedc<zzecr> zzigq;

        public zza(zzedc<zzecr> zzedc) {
            this.zzigq = zzedc;
        }
    }

    zzefd() {
    }

    public final Class<zzecr> zzbbh() {
        return zzecr.class;
    }

    public final Class<zzecr> zzbbu() {
        return zzecr.class;
    }

    public final /* synthetic */ Object zza(zzedc zzedc) throws GeneralSecurityException {
        return new zza(zzedc);
    }
}
