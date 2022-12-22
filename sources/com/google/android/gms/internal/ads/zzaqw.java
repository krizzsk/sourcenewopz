package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaqw implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqu zzdqr;

    zzaqw(zzaqu zzaqu) {
        this.zzdqr = zzaqu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzdqr.zzdt("Operation denied by user.");
    }
}
