package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzefb {
    @Deprecated
    public static final zzeix zzifu = zzeix.zzbgi();
    @Deprecated
    private static final zzeix zzifv = zzeix.zzbgi();
    @Deprecated
    private static final zzeix zzifw = zzeix.zzbgi();
    private static final String zzigo = new zzeez().getKeyType();
    private static final String zzigp = new zzeey().getKeyType();

    static {
        try {
            zzedr.zzbby();
            zzedl.zza(new zzeey(), new zzeez(), true);
            zzedl.zza(new zzefd());
            zzedl.zza(new zzefe());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
