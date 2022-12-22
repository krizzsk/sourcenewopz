package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzayh implements zzayd.zza {
    private final String zzdmo;
    private final Bundle zzedl;

    zzayh(String str, Bundle bundle) {
        this.zzdmo = str;
        this.zzedl = bundle;
    }

    public final void zza(zzbha zzbha) {
        zzbha.logEvent("am", this.zzdmo, this.zzedl);
    }
}
