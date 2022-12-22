package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzebu implements Executor {
    private final /* synthetic */ Executor zzidv;
    private final /* synthetic */ zzeah zzidw;

    zzebu(Executor executor, zzeah zzeah) {
        this.zzidv = executor;
        this.zzidw = zzeah;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zzidv.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzidw.setException(e);
        }
    }
}
