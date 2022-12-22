package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzarc implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzara zzdri;

    zzarc(zzara zzara) {
        this.zzdri = zzara;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzdri.zzdt("User canceled the download.");
    }
}
