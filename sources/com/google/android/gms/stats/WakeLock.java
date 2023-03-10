package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class WakeLock {
    private static ScheduledExecutorService zzn;
    private static volatile zza zzo = new zza();
    private final Object zza;
    private final PowerManager.WakeLock zzb;
    private WorkSource zzc;
    private final int zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final Context zzh;
    private boolean zzi;
    private final Map<String, Integer[]> zzj;
    private final Set<Future<?>> zzk;
    private int zzl;
    private AtomicInteger zzm;

    public interface zza {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    private WakeLock(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, (String) null, str3, (String) null);
    }

    private WakeLock(Context context, int i, String str, String str2, String str3, String str4) {
        this.zza = this;
        this.zzi = true;
        this.zzj = new HashMap();
        this.zzk = Collections.synchronizedSet(new HashSet());
        this.zzm = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.zzd = i;
        this.zzf = null;
        this.zzg = null;
        this.zzh = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.zze = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.zze = str;
        }
        this.zzb = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            WorkSource fromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3);
            this.zzc = fromPackage;
            if (fromPackage != null && WorkSourceUtil.hasWorkSourcePermission(this.zzh)) {
                WorkSource workSource = this.zzc;
                if (workSource != null) {
                    workSource.add(fromPackage);
                } else {
                    this.zzc = fromPackage;
                }
                try {
                    this.zzb.setWorkSource(this.zzc);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (zzn == null) {
            zzn = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    private final List<String> zza() {
        return WorkSourceUtil.getNames(this.zzc);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r2 == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r13.zzl == 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r13.zzh, com.google.android.gms.common.stats.StatsUtils.getEventKey(r13.zzb, r6), 7, r13.zze, r6, (java.lang.String) null, r13.zzd, zza(), r14);
        r13.zzl++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void acquire(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.zzm
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.zza((java.lang.String) r0)
            java.lang.Object r0 = r13.zza
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0096 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0096 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            int r1 = r13.zzl     // Catch:{ all -> 0x0096 }
            if (r1 <= 0) goto L_0x0029
        L_0x001a:
            android.os.PowerManager$WakeLock r1 = r13.zzb     // Catch:{ all -> 0x0096 }
            boolean r1 = r1.isHeld()     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0029
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0096 }
            r1.clear()     // Catch:{ all -> 0x0096 }
            r13.zzl = r2     // Catch:{ all -> 0x0096 }
        L_0x0029:
            boolean r1 = r13.zzi     // Catch:{ all -> 0x0096 }
            r12 = 1
            if (r1 == 0) goto L_0x0056
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0096 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0096 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0047
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0096 }
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch:{ all -> 0x0096 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0096 }
            r3[r2] = r4     // Catch:{ all -> 0x0096 }
            r1.put(r6, r3)     // Catch:{ all -> 0x0096 }
            r2 = 1
            goto L_0x0054
        L_0x0047:
            r3 = r1[r2]     // Catch:{ all -> 0x0096 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0096 }
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0096 }
            r1[r2] = r3     // Catch:{ all -> 0x0096 }
        L_0x0054:
            if (r2 != 0) goto L_0x005e
        L_0x0056:
            boolean r1 = r13.zzi     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x007d
            int r1 = r13.zzl     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x007d
        L_0x005e:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x0096 }
            android.content.Context r2 = r13.zzh     // Catch:{ all -> 0x0096 }
            android.os.PowerManager$WakeLock r3 = r13.zzb     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey(r3, r6)     // Catch:{ all -> 0x0096 }
            r4 = 7
            java.lang.String r5 = r13.zze     // Catch:{ all -> 0x0096 }
            r7 = 0
            int r8 = r13.zzd     // Catch:{ all -> 0x0096 }
            java.util.List r9 = r13.zza()     // Catch:{ all -> 0x0096 }
            r10 = r14
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0096 }
            int r1 = r13.zzl     // Catch:{ all -> 0x0096 }
            int r1 = r1 + r12
            r13.zzl = r1     // Catch:{ all -> 0x0096 }
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            android.os.PowerManager$WakeLock r0 = r13.zzb
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0095
            java.util.concurrent.ScheduledExecutorService r0 = zzn
            com.google.android.gms.stats.zzb r1 = new com.google.android.gms.stats.zzb
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L_0x0095:
            return
        L_0x0096:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.acquire(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        if (r1 != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (r12.zzl == 1) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.zzh, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.zzb, r6), 8, r12.zze, r6, (java.lang.String) null, r12.zzd, zza());
        r12.zzl--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.zzm
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L_0x001f
            java.lang.String r2 = "WakeLock"
            java.lang.String r0 = r12.zze
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = " release without a matched acquire!"
            java.lang.String r3 = r0.concat(r1)
            r1 = 6
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.stats.WakeLock"
            r6 = 79
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x001f:
            r0 = 0
            java.lang.String r6 = r12.zza((java.lang.String) r0)
            java.lang.Object r0 = r12.zza
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0084 }
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L_0x0058
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.zzj     // Catch:{ all -> 0x0084 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0084 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0084 }
            if (r1 != 0) goto L_0x0039
        L_0x0037:
            r1 = 0
            goto L_0x0056
        L_0x0039:
            r2 = r1[r11]     // Catch:{ all -> 0x0084 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0084 }
            if (r2 != r10) goto L_0x0048
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.zzj     // Catch:{ all -> 0x0084 }
            r1.remove(r6)     // Catch:{ all -> 0x0084 }
            r1 = 1
            goto L_0x0056
        L_0x0048:
            r2 = r1[r11]     // Catch:{ all -> 0x0084 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0084 }
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0084 }
            r1[r11] = r2     // Catch:{ all -> 0x0084 }
            goto L_0x0037
        L_0x0056:
            if (r1 != 0) goto L_0x0060
        L_0x0058:
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0084 }
            if (r1 != 0) goto L_0x007f
            int r1 = r12.zzl     // Catch:{ all -> 0x0084 }
            if (r1 != r10) goto L_0x007f
        L_0x0060:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x0084 }
            android.content.Context r2 = r12.zzh     // Catch:{ all -> 0x0084 }
            android.os.PowerManager$WakeLock r3 = r12.zzb     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey(r3, r6)     // Catch:{ all -> 0x0084 }
            r4 = 8
            java.lang.String r5 = r12.zze     // Catch:{ all -> 0x0084 }
            r7 = 0
            int r8 = r12.zzd     // Catch:{ all -> 0x0084 }
            java.util.List r9 = r12.zza()     // Catch:{ all -> 0x0084 }
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0084 }
            int r1 = r12.zzl     // Catch:{ all -> 0x0084 }
            int r1 = r1 - r10
            r12.zzl = r1     // Catch:{ all -> 0x0084 }
        L_0x007f:
            monitor-exit(r0)     // Catch:{ all -> 0x0084 }
            r12.zza((int) r11)
            return
        L_0x0084:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0084 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.release():void");
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        if (this.zzb.isHeld()) {
            try {
                this.zzb.release();
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                if (runtimeException.getClass().equals(RuntimeException.class)) {
                    SystemUtils.log(6, "WakeLock", String.valueOf(this.zze).concat(" was already released!"), runtimeException, "com.google.android.gms.stats.WakeLock", 108);
                } else {
                    throw runtimeException;
                }
            }
            this.zzb.isHeld();
        }
    }

    private final String zza(String str) {
        if (this.zzi) {
            return !TextUtils.isEmpty(str) ? str : this.zzf;
        }
        return this.zzf;
    }

    public void setReferenceCounted(boolean z) {
        this.zzb.setReferenceCounted(z);
        this.zzi = z;
    }

    public boolean isHeld() {
        return this.zzb.isHeld();
    }
}
