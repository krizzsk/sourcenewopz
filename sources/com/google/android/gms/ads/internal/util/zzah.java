package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzah implements DialogInterface.OnClickListener {
    static final DialogInterface.OnClickListener zzehk = new zzah();

    private zzah() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
    }
}
