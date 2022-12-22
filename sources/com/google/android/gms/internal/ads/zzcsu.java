package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import com.google.android.gms.ads.internal.overlay.zze;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcsu extends TimerTask {
    private final /* synthetic */ AlertDialog zzgvb;
    private final /* synthetic */ Timer zzgvc;
    private final /* synthetic */ zze zzgvd;

    zzcsu(AlertDialog alertDialog, Timer timer, zze zze) {
        this.zzgvb = alertDialog;
        this.zzgvc = timer;
        this.zzgvd = zze;
    }

    public final void run() {
        this.zzgvb.dismiss();
        this.zzgvc.cancel();
        zze zze = this.zzgvd;
        if (zze != null) {
            zze.close();
        }
    }
}
