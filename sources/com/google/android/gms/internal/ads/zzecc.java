package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzecc<V> implements Runnable {
    @NullableDecl
    private zzeca<V> zzied;

    zzecc(zzeca<V> zzeca) {
        this.zzied = zzeca;
    }

    public final void run() {
        zzebt zza;
        String str;
        zzeca<V> zzeca = this.zzied;
        if (zzeca != null && (zza = zzeca.zzieb) != null) {
            this.zzied = null;
            if (zza.isDone()) {
                zzeca.setFuture(zza);
                return;
            }
            try {
                ScheduledFuture zzb = zzeca.zziec;
                ScheduledFuture unused = zzeca.zziec = null;
                str = "Timed out";
                if (zzb != null) {
                    long abs = Math.abs(zzb.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        StringBuilder sb = new StringBuilder(str.length() + 66);
                        sb.append(str);
                        sb.append(" (timeout delayed by ");
                        sb.append(abs);
                        sb.append(" ms after scheduled time)");
                        str = sb.toString();
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                zzeca.setException(new zzecf(sb2.toString()));
                zza.cancel(true);
            } catch (Throwable th) {
                zza.cancel(true);
                throw th;
            }
        }
    }
}
