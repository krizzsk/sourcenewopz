package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdbl implements zzdxw {
    private final Uri zzgws;
    private final zzdbf zzhch;

    zzdbl(zzdbf zzdbf, Uri uri) {
        this.zzhch = zzdbf;
        this.zzgws = uri;
    }

    public final Object apply(Object obj) {
        return zzdbf.zzc(this.zzgws, (String) obj);
    }
}
