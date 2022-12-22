package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzs extends zze {
    public zzs(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        zzd.zzed("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdtk = zzl.OTHER;
        this.zzaax.finish();
    }
}
