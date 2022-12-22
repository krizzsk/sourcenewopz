package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
final class zacz extends zau {
    final /* synthetic */ zada zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacz(zada zada, Looper looper) {
        super(looper);
        this.zaa = zada;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.zaa.zae) {
                zada zada = (zada) Preconditions.checkNotNull(this.zaa.zab);
                if (pendingResult == null) {
                    zada.zaj(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacp) {
                    zada.zaj(((zacp) pendingResult).zaa());
                } else {
                    zada.zai(pendingResult);
                }
            }
        } else if (i != 1) {
            int i2 = message.what;
            SystemUtils.log(6, "TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i2, (Throwable) null, "com.google.android.gms.common.api.internal.zacz", 13);
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            SystemUtils.log(6, "TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())), (Throwable) null, "com.google.android.gms.common.api.internal.zacz", 4);
            throw runtimeException;
        }
    }
}
