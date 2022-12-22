package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaqx implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqu zzdqr;

    zzaqx(zzaqu zzaqu) {
        this.zzdqr = zzaqu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        Intent createIntent = this.zzdqr.createIntent();
        zzr.zzkv();
        zzj.zza(this.zzdqr.context, createIntent);
    }
}
