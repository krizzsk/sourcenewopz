package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcun implements zzear {
    private final zzdpi zzgvu;
    private final zzcuk zzgwr;
    private final Uri zzgws;
    private final zzdot zzgwt;

    zzcun(zzcuk zzcuk, Uri uri, zzdpi zzdpi, zzdot zzdot) {
        this.zzgwr = zzcuk;
        this.zzgws = uri;
        this.zzgvu = zzdpi;
        this.zzgwt = zzdot;
    }

    public final zzebt zzf(Object obj) {
        return this.zzgwr.zza(this.zzgws, this.zzgvu, this.zzgwt, obj);
    }
}
