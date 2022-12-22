package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcgh implements zzdxw {
    private final String zzdmo;
    private final int zzehi;
    private final int zzehj;
    private final double zzgkq;

    zzcgh(String str, double d, int i, int i2) {
        this.zzdmo = str;
        this.zzgkq = d;
        this.zzehi = i;
        this.zzehj = i2;
    }

    public final Object apply(Object obj) {
        String str = this.zzdmo;
        return new zzaee(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzgkq, this.zzehi, this.zzehj);
    }
}
