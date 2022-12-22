package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcfz implements zzdxw<zzz, Bitmap> {
    private final /* synthetic */ double zzgju;
    private final /* synthetic */ boolean zzgjv;
    private final /* synthetic */ zzcfw zzgjw;

    zzcfz(zzcfw zzcfw, double d, boolean z) {
        this.zzgjw = zzcfw;
        this.zzgju = d;
        this.zzgjv = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.zzgjw.zza(((zzz) obj).data, this.zzgju, this.zzgjv);
    }
}
