package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzby extends BroadcastReceiver {
    private final /* synthetic */ zzbv zzejh;

    zzby(zzbv zzbv) {
        this.zzejh = zzbv;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzejh.zzc(context, intent);
    }
}
