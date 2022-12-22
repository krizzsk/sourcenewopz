package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcps implements zzear {
    private final zzauj zzgca;

    zzcps(zzauj zzauj) {
        this.zzgca = zzauj;
    }

    public final zzebt zzf(Object obj) {
        zzauj zzauj = this.zzgca;
        zzauj.zzdyv = new String(zzdzz.toByteArray((InputStream) obj), zzdxu.UTF_8);
        return zzebh.zzag(zzauj);
    }
}
