package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcff implements zzaig {
    private final zzcfd zzgjb;
    private final WindowManager zzgjf;
    private final View zzgjg;

    zzcff(zzcfd zzcfd, WindowManager windowManager, View view) {
        this.zzgjb = zzcfd;
        this.zzgjf = windowManager;
        this.zzgjg = view;
    }

    public final void zza(Object obj, Map map) {
        this.zzgjb.zza(this.zzgjf, this.zzgjg, (zzbfi) obj, map);
    }
}
