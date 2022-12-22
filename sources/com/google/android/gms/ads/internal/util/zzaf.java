package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzaf implements DialogInterface.OnClickListener {
    private final zzad zzehg;
    private final int zzehh;
    private final int zzehi;
    private final int zzehj;

    zzaf(zzad zzad, int i, int i2, int i3) {
        this.zzehg = zzad;
        this.zzehh = i;
        this.zzehi = i2;
        this.zzehj = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzehg.zza(this.zzehh, this.zzehi, this.zzehj, dialogInterface, i);
    }
}
