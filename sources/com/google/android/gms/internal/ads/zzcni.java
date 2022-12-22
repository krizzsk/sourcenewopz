package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcni implements Runnable {
    private final zzcna zzgpl;
    private final zzbbe zzgpn;

    zzcni(zzcna zzcna, zzbbe zzbbe) {
        this.zzgpl = zzcna;
        this.zzgpn = zzbbe;
    }

    public final void run() {
        zzbbe zzbbe = this.zzgpn;
        String zzyr = zzr.zzkz().zzyl().zzzg().zzyr();
        if (!TextUtils.isEmpty(zzyr)) {
            zzbbe.set(zzyr);
        } else {
            zzbbe.setException(new Exception());
        }
    }
}
