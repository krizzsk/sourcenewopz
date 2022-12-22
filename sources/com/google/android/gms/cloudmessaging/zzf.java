package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final class zzf implements ServiceConnection {
    int zza;
    final Messenger zzb;
    zzo zzc;
    final Queue<zzq<?>> zzd;
    final SparseArray<zzq<?>> zze;
    final /* synthetic */ zze zzf;

    private zzf(zze zze2) {
        this.zzf = zze2;
        this.zza = 0;
        this.zzb = new Messenger(new zze(Looper.getMainLooper(), new zzi(this)));
        this.zzd = new ArrayDeque();
        this.zze = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.cloudmessaging.zzq<?> r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.zza     // Catch:{ all -> 0x009d }
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0041
            if (r0 == r3) goto L_0x003a
            if (r0 == r1) goto L_0x0030
            r11 = 3
            if (r0 == r11) goto L_0x002e
            r11 = 4
            if (r0 != r11) goto L_0x0013
            goto L_0x002e
        L_0x0013:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x009d }
            int r0 = r10.zza     // Catch:{ all -> 0x009d }
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
            r2.<init>(r1)     // Catch:{ all -> 0x009d }
            java.lang.String r1 = "Unknown state: "
            r2.append(r1)     // Catch:{ all -> 0x009d }
            r2.append(r0)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x009d }
            r11.<init>(r0)     // Catch:{ all -> 0x009d }
            throw r11     // Catch:{ all -> 0x009d }
        L_0x002e:
            monitor-exit(r10)
            return r2
        L_0x0030:
            java.util.Queue<com.google.android.gms.cloudmessaging.zzq<?>> r0 = r10.zzd     // Catch:{ all -> 0x009d }
            r0.add(r11)     // Catch:{ all -> 0x009d }
            r10.zza()     // Catch:{ all -> 0x009d }
            monitor-exit(r10)
            return r3
        L_0x003a:
            java.util.Queue<com.google.android.gms.cloudmessaging.zzq<?>> r0 = r10.zzd     // Catch:{ all -> 0x009d }
            r0.add(r11)     // Catch:{ all -> 0x009d }
            monitor-exit(r10)
            return r3
        L_0x0041:
            java.util.Queue<com.google.android.gms.cloudmessaging.zzq<?>> r0 = r10.zzd     // Catch:{ all -> 0x009d }
            r0.add(r11)     // Catch:{ all -> 0x009d }
            int r11 = r10.zza     // Catch:{ all -> 0x009d }
            if (r11 != 0) goto L_0x004c
            r11 = 1
            goto L_0x004d
        L_0x004c:
            r11 = 0
        L_0x004d:
            com.google.android.gms.common.internal.Preconditions.checkState(r11)     // Catch:{ all -> 0x009d }
            java.lang.String r11 = "MessengerIpcClient"
            boolean r11 = android.util.Log.isLoggable(r11, r1)     // Catch:{ all -> 0x009d }
            if (r11 == 0) goto L_0x0065
            java.lang.String r5 = "MessengerIpcClient"
            java.lang.String r6 = "Starting bind to GmsCore"
            r4 = 2
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.cloudmessaging.zzf"
            r9 = 12
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x009d }
        L_0x0065:
            r10.zza = r3     // Catch:{ all -> 0x009d }
            android.content.Intent r11 = new android.content.Intent     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r11.<init>(r0)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "com.google.android.gms"
            r11.setPackage(r0)     // Catch:{ all -> 0x009d }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x009d }
            com.google.android.gms.cloudmessaging.zze r1 = r10.zzf     // Catch:{ all -> 0x009d }
            android.content.Context r1 = r1.zzb     // Catch:{ all -> 0x009d }
            boolean r11 = r0.bindService(r1, r11, r10, r3)     // Catch:{ all -> 0x009d }
            if (r11 != 0) goto L_0x0089
            java.lang.String r11 = "Unable to bind to service"
            r10.zza(r2, r11)     // Catch:{ all -> 0x009d }
            goto L_0x009b
        L_0x0089:
            com.google.android.gms.cloudmessaging.zze r11 = r10.zzf     // Catch:{ all -> 0x009d }
            java.util.concurrent.ScheduledExecutorService r11 = r11.zzc     // Catch:{ all -> 0x009d }
            com.google.android.gms.cloudmessaging.zzh r0 = new com.google.android.gms.cloudmessaging.zzh     // Catch:{ all -> 0x009d }
            r0.<init>(r10)     // Catch:{ all -> 0x009d }
            r1 = 30
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x009d }
            r11.schedule(r0, r1, r4)     // Catch:{ all -> 0x009d }
        L_0x009b:
            monitor-exit(r10)
            return r3
        L_0x009d:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzf.zza(com.google.android.gms.cloudmessaging.zzq):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        r10 = r10.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0069, code lost:
        if (r10.getBoolean("unsupported", false) == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        r1.zza(new com.google.android.gms.cloudmessaging.zzp(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0077, code lost:
        r1.zza(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(android.os.Message r10) {
        /*
            r9 = this;
            int r0 = r10.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x0029
            java.lang.String r3 = "MessengerIpcClient"
            r1 = 41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Received response to request: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r4 = r2.toString()
            r2 = 3
            r5 = 0
            java.lang.String r6 = "com.google.android.gms.cloudmessaging.zzf"
            r7 = 32
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0029:
            monitor-enter(r9)
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzq<?>> r1 = r9.zze     // Catch:{ all -> 0x007b }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x007b }
            com.google.android.gms.cloudmessaging.zzq r1 = (com.google.android.gms.cloudmessaging.zzq) r1     // Catch:{ all -> 0x007b }
            r2 = 1
            if (r1 != 0) goto L_0x0055
            java.lang.String r4 = "MessengerIpcClient"
            r10 = 50
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r1.<init>(r10)     // Catch:{ all -> 0x007b }
            java.lang.String r10 = "Received response for unknown request: "
            r1.append(r10)     // Catch:{ all -> 0x007b }
            r1.append(r0)     // Catch:{ all -> 0x007b }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x007b }
            r3 = 5
            r6 = 0
            java.lang.String r7 = "com.google.android.gms.cloudmessaging.zzf"
            r8 = 36
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007b }
            monitor-exit(r9)     // Catch:{ all -> 0x007b }
            return r2
        L_0x0055:
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzq<?>> r3 = r9.zze     // Catch:{ all -> 0x007b }
            r3.remove(r0)     // Catch:{ all -> 0x007b }
            r9.zzb()     // Catch:{ all -> 0x007b }
            monitor-exit(r9)     // Catch:{ all -> 0x007b }
            android.os.Bundle r10 = r10.getData()
            java.lang.String r0 = "unsupported"
            r3 = 0
            boolean r0 = r10.getBoolean(r0, r3)
            if (r0 == 0) goto L_0x0077
            com.google.android.gms.cloudmessaging.zzp r10 = new com.google.android.gms.cloudmessaging.zzp
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r10.<init>(r0, r3)
            r1.zza((com.google.android.gms.cloudmessaging.zzp) r10)
            goto L_0x007a
        L_0x0077:
            r1.zza((android.os.Bundle) r10)
        L_0x007a:
            return r2
        L_0x007b:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x007b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzf.zza(android.os.Message):boolean");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            SystemUtils.log(2, "MessengerIpcClient", "Service connected", (Throwable) null, "com.google.android.gms.cloudmessaging.zzf", 48);
        }
        this.zzf.zzc.execute(new zzk(this, iBinder));
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzf.zzc.execute(new zzj(this));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            SystemUtils.log(2, "MessengerIpcClient", "Service disconnected", (Throwable) null, "com.google.android.gms.cloudmessaging.zzf", 54);
        }
        this.zzf.zzc.execute(new zzm(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            SystemUtils.log(3, "MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "), (Throwable) null, "com.google.android.gms.cloudmessaging.zzf", 58);
        }
        int i2 = this.zza;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                SystemUtils.log(2, "MessengerIpcClient", "Unbinding service", (Throwable) null, "com.google.android.gms.cloudmessaging.zzf", 62);
            }
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzp zzp = new zzp(i, str);
            for (zzq zza2 : this.zzd) {
                zza2.zza(zzp);
            }
            this.zzd.clear();
            for (int i3 = 0; i3 < this.zze.size(); i3++) {
                this.zze.valueAt(i3).zza(zzp);
            }
            this.zze.clear();
        } else if (i2 == 3) {
            this.zza = 4;
        } else if (i2 != 4) {
            int i4 = this.zza;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                SystemUtils.log(2, "MessengerIpcClient", "Finished handling requests, unbinding", (Throwable) null, "com.google.android.gms.cloudmessaging.zzf", 83);
            }
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i) {
        zzq zzq = this.zze.get(i);
        if (zzq != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            SystemUtils.log(5, "MessengerIpcClient", sb.toString(), (Throwable) null, "com.google.android.gms.cloudmessaging.zzf", 92);
            this.zze.remove(i);
            zzq.zza(new zzp(3, "Timed out waiting for response"));
            zzb();
        }
    }
}
