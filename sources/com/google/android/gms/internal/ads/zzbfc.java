package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfc implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzest;

    zzbfc(JsResult jsResult) {
        this.zzest = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzest.cancel();
    }
}
