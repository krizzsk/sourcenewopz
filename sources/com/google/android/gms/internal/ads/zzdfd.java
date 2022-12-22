package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfd implements zzdhb<Bundle> {
    private final zzdor zzfti;

    public zzdfd(zzdor zzdor) {
        this.zzfti = zzdor;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdor zzdor = this.zzfti;
        if (zzdor != null) {
            bundle.putBoolean("render_in_browser", zzdor.zzavw());
            bundle.putBoolean("disable_ml", this.zzfti.zzavx());
        }
    }
}
