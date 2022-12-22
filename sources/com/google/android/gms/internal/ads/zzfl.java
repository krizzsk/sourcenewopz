package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzfl extends BroadcastReceiver {
    private final /* synthetic */ zzfj zzaaw;

    zzfl(zzfj zzfj) {
        this.zzaaw = zzfj;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzaaw.zzcw();
    }
}
