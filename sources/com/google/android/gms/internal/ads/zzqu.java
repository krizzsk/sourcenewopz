package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqu extends BroadcastReceiver {
    private final /* synthetic */ zzqs zzbsc;

    zzqu(zzqs zzqs) {
        this.zzbsc = zzqs;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzbsc.zzbu(3);
    }
}
