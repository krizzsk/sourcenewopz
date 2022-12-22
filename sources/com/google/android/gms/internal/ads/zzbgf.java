package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbgf implements zzbgh {
    private final zzbfi zzewn;

    zzbgf(zzbfi zzbfi) {
        this.zzewn = zzbfi;
    }

    public final void zzj(Uri uri) {
        zzbgu zzaef = this.zzewn.zzaef();
        if (zzaef == null) {
            zzd.zzex("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaef.zzj(uri);
        }
    }
}
