package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzatn implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzatl zzdvk;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdvl;

    zzatn(zzatl zzatl, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdvk = zzatl;
        this.zzdvl = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdvk.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdvl;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdvl;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
