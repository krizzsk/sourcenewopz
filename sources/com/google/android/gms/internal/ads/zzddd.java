package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.didi.raven.config.RavenConfigKey;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddd implements zzdhb<Bundle> {
    private final zzbar zzdvi;
    private final zzwc zzhdy;

    public zzddd(zzwc zzwc, zzbar zzbar) {
        this.zzhdy = zzwc;
        this.zzdvi = zzbar;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        int intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcws)).intValue();
        zzbar zzbar = this.zzdvi;
        if (zzbar != null && zzbar.zzekb >= intValue) {
            bundle.putString("app_open_version", "2");
        }
        zzwc zzwc = this.zzhdy;
        if (zzwc == null) {
            return;
        }
        if (zzwc.orientation == 1) {
            bundle.putString("avo", RavenConfigKey.PHONE);
        } else if (this.zzhdy.orientation == 2) {
            bundle.putString("avo", "l");
        }
    }
}
