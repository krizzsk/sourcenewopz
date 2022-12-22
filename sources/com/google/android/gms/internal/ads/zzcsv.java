package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zze;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsv implements DialogInterface.OnCancelListener {
    private final zze zzdsz;

    zzcsv(zze zze) {
        this.zzdsz = zze;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zze zze = this.zzdsz;
        if (zze != null) {
            zze.close();
        }
    }
}
