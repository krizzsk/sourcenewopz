package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzpa {
    /* access modifiers changed from: private */
    public final ExecutorService zzbjs;
    /* access modifiers changed from: private */
    public zzpc<? extends zzpb> zzbjt;
    /* access modifiers changed from: private */
    public IOException zzbju;

    public zzpa(String str) {
        this.zzbjs = zzpt.zzbf(str);
    }

    public final <T extends zzpb> long zza(T t, zzoz<T> zzoz, int i) {
        Looper myLooper = Looper.myLooper();
        zzpg.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzpc(this, myLooper, t, zzoz, i, elapsedRealtime).zzek(0);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.zzbjt != null;
    }

    public final void zzix() {
        this.zzbjt.zzm(false);
    }

    public final void zza(Runnable runnable) {
        zzpc<? extends zzpb> zzpc = this.zzbjt;
        if (zzpc != null) {
            zzpc.zzm(true);
        }
        this.zzbjs.execute(runnable);
        this.zzbjs.shutdown();
    }

    public final void zzbj(int i) throws IOException {
        IOException iOException = this.zzbju;
        if (iOException == null) {
            zzpc<? extends zzpb> zzpc = this.zzbjt;
            if (zzpc != null) {
                zzpc.zzbj(zzpc.zzbjx);
                return;
            }
            return;
        }
        throw iOException;
    }
}
