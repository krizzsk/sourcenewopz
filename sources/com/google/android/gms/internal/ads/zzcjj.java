package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcjj implements View.OnClickListener {
    private final zzcjc zzgmm;

    zzcjj(zzcjc zzcjc) {
        this.zzgmm = zzcjc;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.zzgmm.zzae(view);
    }
}
