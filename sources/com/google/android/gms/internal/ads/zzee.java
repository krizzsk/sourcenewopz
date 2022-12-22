package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzee implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxq;
    private final /* synthetic */ View zzxr;
    private final /* synthetic */ String zzxu;

    zzee(zzea zzea, Context context, String str, View view, Activity activity) {
        this.zzxq = context;
        this.zzxu = str;
        this.zzxr = view;
        this.val$activity = activity;
    }

    public final void run() {
        try {
            zzea.zzxf.zza(this.zzxq, this.zzxu, this.zzxr, this.val$activity);
        } catch (Exception e) {
            zzea.zzxh.zza(2021, -1, e);
        }
    }
}
