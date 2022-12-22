package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.internal.base.zau;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
final class zabc extends zau {
    final /* synthetic */ zabe zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zabc(zabe zabe, Looper looper) {
        super(looper);
        this.zaa = zabe;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            zabe.zaj(this.zaa);
        } else if (i != 2) {
            int i2 = message.what;
            SystemUtils.log(5, "GoogleApiClientImpl", "Unknown message id: " + i2, (Throwable) null, "com.google.android.gms.common.api.internal.zabc", 4);
        } else {
            zabe.zai(this.zaa);
        }
    }
}
