package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcyx implements zzg {
    private final /* synthetic */ zzcal zzhac;

    zzcyx(zzcys zzcys, zzcal zzcal) {
        this.zzhac = zzcal;
    }

    public final void zzh(View view) {
    }

    public final void zzkg() {
        this.zzhac.zzahj().onAdClicked();
    }

    public final void zzkh() {
        this.zzhac.zzahk().onAdImpression();
        this.zzhac.zzahl().zzanl();
    }
}
