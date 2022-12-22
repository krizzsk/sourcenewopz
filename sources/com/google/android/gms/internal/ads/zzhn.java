package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzhn extends Handler {
    private final /* synthetic */ zzhk zzagr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzhn(zzhk zzhk, Looper looper) {
        super(looper);
        this.zzagr = zzhk;
    }

    public final void handleMessage(Message message) {
        this.zzagr.zza(message);
    }
}
