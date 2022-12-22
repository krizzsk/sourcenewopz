package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzao implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzal zzehs;

    zzao(zzal zzal) {
        this.zzehs = zzal;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        zzr.zzkv();
        zzj.zzb(this.zzehs.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
