package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzrm {
    private final Object zzbtg = new Object();
    private zzrp zzbth = null;
    private boolean zzbti = false;

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzbtg
            monitor-enter(r0)
            boolean r1 = r4.zzbti     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0032
            r1 = 0
            android.content.Context r2 = r5.getApplicationContext()     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x000f
            r2 = r5
        L_0x000f:
            boolean r3 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0016
            r1 = r2
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x0034 }
        L_0x0016:
            if (r1 != 0) goto L_0x001f
            java.lang.String r5 = "Can not cast Context to Application"
            com.google.android.gms.ads.internal.util.zzd.zzez(r5)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x001f:
            com.google.android.gms.internal.ads.zzrp r2 = r4.zzbth     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzrp r2 = new com.google.android.gms.internal.ads.zzrp     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            r4.zzbth = r2     // Catch:{ all -> 0x0034 }
        L_0x002a:
            com.google.android.gms.internal.ads.zzrp r2 = r4.zzbth     // Catch:{ all -> 0x0034 }
            r2.zza((android.app.Application) r1, (android.content.Context) r5)     // Catch:{ all -> 0x0034 }
            r5 = 1
            r4.zzbti = r5     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.initialize(android.content.Context):void");
    }

    public final void zza(zzrr zzrr) {
        synchronized (this.zzbtg) {
            if (this.zzbth == null) {
                this.zzbth = new zzrp();
            }
            this.zzbth.zza(zzrr);
        }
    }

    public final void zzb(zzrr zzrr) {
        synchronized (this.zzbtg) {
            if (this.zzbth != null) {
                this.zzbth.zzb(zzrr);
            }
        }
    }

    public final Activity getActivity() {
        synchronized (this.zzbtg) {
            if (this.zzbth == null) {
                return null;
            }
            Activity activity = this.zzbth.getActivity();
            return activity;
        }
    }

    public final Context getContext() {
        synchronized (this.zzbtg) {
            if (this.zzbth == null) {
                return null;
            }
            Context context = this.zzbth.getContext();
            return context;
        }
    }
}
