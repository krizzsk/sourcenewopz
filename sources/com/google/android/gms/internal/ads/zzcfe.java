package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcfe implements zzaig {
    private final zzcfd zzgjb;
    private final View zzgjd;
    private final WindowManager zzgje;

    zzcfe(zzcfd zzcfd, View view, WindowManager windowManager) {
        this.zzgjb = zzcfd;
        this.zzgjd = view;
        this.zzgje = windowManager;
    }

    public final void zza(Object obj, Map map) {
        this.zzgjb.zza(this.zzgjd, this.zzgje, (zzbfi) obj, map);
    }
}
