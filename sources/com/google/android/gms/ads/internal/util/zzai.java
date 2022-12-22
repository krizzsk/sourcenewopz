package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzai implements DialogInterface.OnClickListener {
    private final String zzdkl;
    private final zzad zzehg;

    zzai(zzad zzad, String str) {
        this.zzehg = zzad;
        this.zzdkl = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzehg.zza(this.zzdkl, dialogInterface, i);
    }
}
