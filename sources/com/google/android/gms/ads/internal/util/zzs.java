package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzs extends BroadcastReceiver {
    private final /* synthetic */ zzj zzegw;

    private zzs(zzj zzj) {
        this.zzegw = zzj;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.zzegw.zzza = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.zzegw.zzza = false;
        }
    }

    /* synthetic */ zzs(zzj zzj, zzl zzl) {
        this(zzj);
    }
}
