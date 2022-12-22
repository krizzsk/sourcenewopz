package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzta {
    private Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Runnable zzbvl = new zztd(this);
    /* access modifiers changed from: private */
    public zztj zzbvm;
    /* access modifiers changed from: private */
    public zztn zzbvn;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.Context r1 = r2.context     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.context = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabq.zzcuw     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabq.zzcuv     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zztc r3 = new com.google.android.gms.internal.ads.zztc     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzrm r1 = com.google.android.gms.ads.internal.zzr.zzky()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzta.initialize(android.content.Context):void");
    }

    public final void zzna() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcux)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzj.zzegq.removeCallbacks(this.zzbvl);
                zzj.zzegq.postDelayed(this.zzbvl, ((Long) zzww.zzra().zzd(zzabq.zzcuy)).longValue());
            }
        }
    }

    public final zzth zza(zzti zzti) {
        synchronized (this.lock) {
            if (this.zzbvn == null) {
                zzth zzth = new zzth();
                return zzth;
            }
            try {
                if (this.zzbvm.zznk()) {
                    zzth zzc = this.zzbvn.zzc(zzti);
                    return zzc;
                }
                zzth zza = this.zzbvn.zza(zzti);
                return zza;
            } catch (RemoteException e) {
                zzd.zzc("Unable to call into cache service.", e);
                return new zzth();
            }
        }
    }

    public final long zzb(zzti zzti) {
        synchronized (this.lock) {
            if (this.zzbvn == null) {
                return -2;
            }
            if (this.zzbvm.zznk()) {
                try {
                    long zzb = this.zzbvn.zzb(zzti);
                    return zzb;
                } catch (RemoteException e) {
                    zzd.zzc("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zztj r1 = r3.zzbvm     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zztf r1 = new com.google.android.gms.internal.ads.zztf     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzte r2 = new com.google.android.gms.internal.ads.zzte     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zztj r1 = r3.zza((com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks) r1, (com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener) r2)     // Catch:{ all -> 0x0023 }
            r3.zzbvm = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzta.connect():void");
    }

    private final synchronized zztj zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztj(this.context, zzr.zzlj().zzaai(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbvm != null) {
                if (this.zzbvm.isConnected() || this.zzbvm.isConnecting()) {
                    this.zzbvm.disconnect();
                }
                this.zzbvm = null;
                this.zzbvn = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
