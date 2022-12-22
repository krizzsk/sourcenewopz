package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzab implements View.OnApplyWindowInsetsListener {
    private final zzac zzeha;
    private final Activity zzehb;

    zzab(zzac zzac, Activity activity) {
        this.zzeha = zzac;
        this.zzehb = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzac.zza(this.zzehb, view, windowInsets);
    }
}
