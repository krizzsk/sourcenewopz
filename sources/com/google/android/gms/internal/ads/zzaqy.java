package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaqy implements View.OnClickListener {
    private final /* synthetic */ zzaqz zzdqs;

    zzaqy(zzaqz zzaqz) {
        this.zzdqs = zzaqz;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.zzdqs.zzag(true);
    }
}
