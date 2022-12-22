package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeb implements Runnable {
    private final /* synthetic */ Context zzxq;
    private final /* synthetic */ View zzxr;
    private final /* synthetic */ Activity zzxs;

    zzeb(zzea zzea, Context context, View view, Activity activity) {
        this.zzxq = context;
        this.zzxr = view;
        this.zzxs = activity;
    }

    public final void run() {
        try {
            zzea.zzxf.zza(this.zzxq, this.zzxr, this.zzxs);
        } catch (Exception e) {
            zzea.zzxh.zza(2020, -1, e);
        }
    }
}
