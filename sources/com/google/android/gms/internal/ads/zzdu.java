package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdu implements zzdwv {
    private final /* synthetic */ zzduu zzwf;

    zzdu(zzds zzds, zzduu zzduu) {
        this.zzwf = zzduu;
    }

    public final boolean zzb(File file) {
        try {
            return this.zzwf.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
