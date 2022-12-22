package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzhm implements Handler.Callback, zznb, zznd, zzok {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final zzhy[] zzaex;
    private final zzoh zzaey;
    private final Handler zzafa;
    private final zzie zzafd;
    private final zzif zzafe;
    private boolean zzafg;
    private boolean zzafk;
    private zzid zzafl;
    private zzhz zzafp;
    private zzho zzafq;
    private final zzib[] zzafu;
    private final zzhx zzafv;
    private final zzps zzafw;
    private final HandlerThread zzafx;
    private final zzhh zzafy;
    private zzhy zzafz;
    private zzpk zzaga;
    private zzne zzagb;
    private zzhy[] zzagc;
    private boolean zzagd;
    private boolean zzage;
    private int zzagf;
    private int zzagg;
    private long zzagh;
    private int zzagi;
    private zzhr zzagj;
    private long zzagk;
    private zzhp zzagl;
    private zzhp zzagm;
    private zzhp zzagn;
    private boolean zzago;
    private volatile int zzagp;
    private volatile int zzagq;

    public zzhm(zzhy[] zzhyArr, zzoh zzoh, zzhx zzhx, boolean z, int i, Handler handler2, zzho zzho, zzhh zzhh) {
        this.zzaex = zzhyArr;
        this.zzaey = zzoh;
        this.zzafv = zzhx;
        this.zzafg = z;
        this.zzafa = handler2;
        this.state = 1;
        this.zzafq = zzho;
        this.zzafy = zzhh;
        this.zzafu = new zzib[zzhyArr.length];
        for (int i2 = 0; i2 < zzhyArr.length; i2++) {
            zzhyArr[i2].setIndex(i2);
            this.zzafu[i2] = zzhyArr[i2].zzec();
        }
        this.zzafw = new zzps();
        this.zzagc = new zzhy[0];
        this.zzafd = new zzie();
        this.zzafe = new zzif();
        zzoh.zza(this);
        this.zzafp = zzhz.zzaik;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzafx = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.zzafx.getLooper(), this);
    }

    public final void zzer() {
        this.zzago = true;
    }

    public final void zza(zzne zzne, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzne).sendToTarget();
    }

    public final void zzh(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzid zzid, int i, long j) {
        this.handler.obtainMessage(3, new zzhr(zzid, i, j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzhi... zzhiArr) {
        if (this.zzagd) {
            SystemUtils.log(5, "ExoPlayerImplInternal", "Ignoring messages sent after release.", (Throwable) null, "com.google.android.gms.internal.ads.zzhm", 39);
            return;
        }
        this.zzagf++;
        this.handler.obtainMessage(11, zzhiArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0025, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzhi... r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzagd     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Ignoring messages sent after release."
            r1 = 5
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.internal.ads.zzhm"
            r6 = 45
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0037 }
            monitor-exit(r7)
            return
        L_0x0014:
            int r0 = r7.zzagf     // Catch:{ all -> 0x0037 }
            int r1 = r0 + 1
            r7.zzagf = r1     // Catch:{ all -> 0x0037 }
            android.os.Handler r1 = r7.handler     // Catch:{ all -> 0x0037 }
            r2 = 11
            android.os.Message r8 = r1.obtainMessage(r2, r8)     // Catch:{ all -> 0x0037 }
            r8.sendToTarget()     // Catch:{ all -> 0x0037 }
        L_0x0025:
            int r8 = r7.zzagg     // Catch:{ all -> 0x0037 }
            if (r8 > r0) goto L_0x0035
            r7.wait()     // Catch:{ InterruptedException -> 0x002d }
            goto L_0x0025
        L_0x002d:
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0037 }
            r8.interrupt()     // Catch:{ all -> 0x0037 }
            goto L_0x0025
        L_0x0035:
            monitor-exit(r7)
            return
        L_0x0037:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.zzb(com.google.android.gms.internal.ads.zzhi[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void release() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzagd     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.handler     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzagd     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzafx     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.release():void");
    }

    public final void zzb(zzid zzid, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzid, obj)).sendToTarget();
    }

    public final void zza(zznc zznc) {
        this.handler.obtainMessage(8, zznc).sendToTarget();
    }

    public final void zzet() {
        this.handler.sendEmptyMessage(10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0287 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x028a A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x028e A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0350 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0364 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x052f A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0536 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0550 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0553 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x058e A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x05a0 A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x05bc A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }, LOOP:8: B:329:0x05bc->B:333:0x05ce, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x071b A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x07ee A[Catch:{ all -> 0x0449, all -> 0x0382, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r38) {
        /*
            r37 = this;
            r8 = r37
            r1 = r38
            r10 = 1
            int r2 = r1.what     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0894;
                case 1: goto L_0x0867;
                case 2: goto L_0x0463;
                case 3: goto L_0x03ab;
                case 4: goto L_0x038a;
                case 5: goto L_0x0386;
                case 6: goto L_0x036f;
                case 7: goto L_0x0213;
                case 8: goto L_0x01df;
                case 9: goto L_0x01cc;
                case 10: goto L_0x00d9;
                case 11: goto L_0x009b;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.repeatMode = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0026:
            if (r2 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzhp r4 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != r4) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            com.google.android.gms.internal.ads.zzid r11 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r12 = r2.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r13 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzie r14 = r8.zzafd     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r11 = r11.zza((int) r12, (com.google.android.gms.internal.ads.zzif) r13, (com.google.android.gms.internal.ads.zzie) r14, (int) r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r12 = r2.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 == 0) goto L_0x0061
            if (r11 == r5) goto L_0x0061
            com.google.android.gms.internal.ads.zzhp r12 = r2.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r12 = r12.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 != r11) goto L_0x0061
            com.google.android.gms.internal.ads.zzhp r2 = r2.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r11 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != r11) goto L_0x0056
            r11 = 1
            goto L_0x0057
        L_0x0056:
            r11 = 0
        L_0x0057:
            r3 = r3 | r11
            com.google.android.gms.internal.ads.zzhp r11 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != r11) goto L_0x005e
            r11 = 1
            goto L_0x005f
        L_0x005e:
            r11 = 0
        L_0x005f:
            r4 = r4 | r11
            goto L_0x0036
        L_0x0061:
            com.google.android.gms.internal.ads.zzhp r5 = r2.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r5 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzhp r5 = r2.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            zza((com.google.android.gms.internal.ads.zzhp) r5)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zzahe = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x006c:
            int r5 = r2.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r5 = r8.zzx(r5)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zzahb = r5     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r4 != 0) goto L_0x0078
            r8.zzagl = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0078:
            if (r3 != 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r3.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r8.zzb((int) r2, (long) r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r5 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5.<init>(r2, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r5     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0091:
            int r2 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != r15) goto L_0x009a
            if (r1 == 0) goto L_0x009a
            r8.setState(r7)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x009a:
            return r10
        L_0x009b:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhi[] r1 = (com.google.android.gms.internal.ads.zzhi[]) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r1.length     // Catch:{ all -> 0x00c8 }
        L_0x00a0:
            if (r9 >= r2) goto L_0x00b0
            r3 = r1[r9]     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.internal.ads.zzhj r4 = r3.zzaeu     // Catch:{ all -> 0x00c8 }
            int r5 = r3.zzaev     // Catch:{ all -> 0x00c8 }
            java.lang.Object r3 = r3.zzaew     // Catch:{ all -> 0x00c8 }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00c8 }
            int r9 = r9 + 1
            goto L_0x00a0
        L_0x00b0:
            com.google.android.gms.internal.ads.zzne r1 = r8.zzagb     // Catch:{ all -> 0x00c8 }
            if (r1 == 0) goto L_0x00b9
            android.os.Handler r1 = r8.handler     // Catch:{ all -> 0x00c8 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c8 }
        L_0x00b9:
            monitor-enter(r37)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = r8.zzagg     // Catch:{ all -> 0x00c4 }
            int r1 = r1 + r10
            r8.zzagg = r1     // Catch:{ all -> 0x00c4 }
            r37.notifyAll()     // Catch:{ all -> 0x00c4 }
            monitor-exit(r37)     // Catch:{ all -> 0x00c4 }
            return r10
        L_0x00c4:
            r0 = move-exception
            r1 = r0
            monitor-exit(r37)     // Catch:{ all -> 0x00c4 }
            throw r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-enter(r37)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r8.zzagg     // Catch:{ all -> 0x00d5 }
            int r2 = r2 + r10
            r8.zzagg = r2     // Catch:{ all -> 0x00d5 }
            r37.notifyAll()     // Catch:{ all -> 0x00d5 }
            monitor-exit(r37)     // Catch:{ all -> 0x00d5 }
            throw r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x00d5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r37)     // Catch:{ all -> 0x00d5 }
            throw r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x00d9:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = 1
        L_0x00e0:
            if (r1 == 0) goto L_0x01cb
            boolean r3 = r1.zzahc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 != 0) goto L_0x00e8
            goto L_0x01cb
        L_0x00e8:
            boolean r3 = r1.zzfc()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 != 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != r3) goto L_0x00f3
            r2 = 0
        L_0x00f3:
            com.google.android.gms.internal.ads.zzhp r1 = r1.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x00e0
        L_0x00f6:
            if (r2 == 0) goto L_0x0194
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == r3) goto L_0x0100
            r2 = 1
            goto L_0x0101
        L_0x0100:
            r2 = 0
        L_0x0101:
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            zza((com.google.android.gms.internal.ads.zzhp) r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzahe = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagl = r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagm = r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r3 = r3.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean[] r3 = new boolean[r3]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r4 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r5 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r5.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r4 = r4.zza(r11, r2, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r2.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zzagu = r4     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzdq(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0132:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r4 = 0
            r5 = 0
        L_0x0139:
            com.google.android.gms.internal.ads.zzhy[] r11 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r11 = r11.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r4 >= r11) goto L_0x0185
            com.google.android.gms.internal.ads.zzhy[] r11 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11 = r11[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r12 = r11.getState()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 == 0) goto L_0x014a
            r12 = 1
            goto L_0x014b
        L_0x014a:
            r12 = 0
        L_0x014b:
            r2[r4] = r12     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r12 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznn[] r12 = r12.zzagy     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r12 = r12[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 == 0) goto L_0x0157
            int r5 = r5 + 1
        L_0x0157:
            boolean r13 = r2[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r13 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zznn r13 = r11.zzee()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 == r13) goto L_0x0179
            com.google.android.gms.internal.ads.zzhy r13 = r8.zzafz     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r11 != r13) goto L_0x0172
            if (r12 != 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzps r12 = r8.zzafw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzpk r13 = r8.zzaga     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r12.zza(r13)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x016e:
            r8.zzaga = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafz = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0172:
            zza((com.google.android.gms.internal.ads.zzhy) r11)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11.disable()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0182
        L_0x0179:
            boolean r12 = r3[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 == 0) goto L_0x0182
            long r12 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11.zzdm(r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0182:
            int r4 = r4 + 1
            goto L_0x0139
        L_0x0185:
            android.os.Handler r3 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzoj r1 = r1.zzahf     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zza((boolean[]) r2, (int) r5)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x01c0
        L_0x0194:
            r8.zzagl = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r1.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0198:
            if (r1 == 0) goto L_0x01a0
            r1.release()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r1.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0198
        L_0x01a0:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzahe = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r1 = r1.zzahc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x01c0
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r1 = r1.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r4 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r3.zzfa()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzb(r1, r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x01c0:
            r37.zzez()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r37.zzew()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendEmptyMessage(r7)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x01cb:
            return r10
        L_0x01cc:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r1 = (com.google.android.gms.internal.ads.zznc) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x01de
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r2 = r2.zzagw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == r1) goto L_0x01db
            goto L_0x01de
        L_0x01db:
            r37.zzez()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x01de:
            return r10
        L_0x01df:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r1 = (com.google.android.gms.internal.ads.zznc) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x0212
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r2 = r2.zzagw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == r1) goto L_0x01ee
            goto L_0x0212
        L_0x01ee:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzahc = r10     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzfc()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = r1.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = r1.zzb(r2, r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzagt = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != 0) goto L_0x020f
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagm = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r1 = r1.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzdq(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzb((com.google.android.gms.internal.ads.zzhp) r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x020f:
            r37.zzez()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0212:
            return r10
        L_0x0213:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r3 = r1.first     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r3 = (com.google.android.gms.internal.ads.zzid) r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafl = r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r1 = r1.second     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x0282
            int r3 = r8.zzagi     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 <= 0) goto L_0x0252
            com.google.android.gms.internal.ads.zzhr r3 = r8.zzagj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.util.Pair r3 = r8.zza((com.google.android.gms.internal.ads.zzhr) r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r4 = r8.zzagi     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagi = r9     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagj = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 != 0) goto L_0x023a
            r8.zza((java.lang.Object) r1, (int) r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x036e
        L_0x023a:
            com.google.android.gms.internal.ads.zzho r7 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r11 = r3.first     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r11 = r11.intValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r3 = r3.second     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r14 = r3.longValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r7.<init>(r11, r14)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r7     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0283
        L_0x0252:
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r3.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x0282
            com.google.android.gms.internal.ads.zzid r3 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r3 = r3.isEmpty()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 == 0) goto L_0x0267
            r8.zza((java.lang.Object) r1, (int) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x036e
        L_0x0267:
            android.util.Pair r3 = r8.zzc(r9, r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r4 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r7 = r3.first     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r7 = r7.intValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r3 = r3.second     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r14 = r3.longValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r4.<init>(r7, r14)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r4     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0282:
            r4 = 0
        L_0x0283:
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 == 0) goto L_0x028a
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x028c
        L_0x028a:
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x028c:
            if (r3 == 0) goto L_0x036b
            com.google.android.gms.internal.ads.zzid r7 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r11 = r3.zzagx     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r7 = r7.zzc(r11)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 != r5) goto L_0x02f0
            int r6 = r3.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r7 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r8.zza((int) r6, (com.google.android.gms.internal.ads.zzid) r2, (com.google.android.gms.internal.ads.zzid) r7)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != r5) goto L_0x02a7
            r8.zza((java.lang.Object) r1, (int) r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x036e
        L_0x02a7:
            com.google.android.gms.internal.ads.zzid r6 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r7 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r6.zza((int) r2, (com.google.android.gms.internal.ads.zzif) r7, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.util.Pair r2 = r8.zzc(r9, r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r6 = r2.first     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r6 = r6.intValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r2 = r2.second     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r2.longValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r7 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zza((int) r6, (com.google.android.gms.internal.ads.zzif) r7, (boolean) r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r2 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r2 = r2.zzagx     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzags = r5     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x02cf:
            com.google.android.gms.internal.ads.zzhp r7 = r3.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == 0) goto L_0x02e3
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r7 = r3.zzagx     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r7 = r7.equals(r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == 0) goto L_0x02df
            r7 = r6
            goto L_0x02e0
        L_0x02df:
            r7 = -1
        L_0x02e0:
            r3.zzags = r7     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x02cf
        L_0x02e3:
            long r2 = r8.zzb((int) r6, (long) r11)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r5 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5.<init>(r6, r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r5     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x036b
        L_0x02f0:
            boolean r2 = r8.zzx(r7)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzc(r7, r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 != r2) goto L_0x02fd
            r2 = 1
            goto L_0x02fe
        L_0x02fd:
            r2 = 0
        L_0x02fe:
            com.google.android.gms.internal.ads.zzho r11 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r11 = r11.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == r11) goto L_0x0317
            com.google.android.gms.internal.ads.zzho r11 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r12 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r13 = r11.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r12.<init>(r7, r13)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r13 = r11.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r12.zzagu = r13     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r13 = r11.zzagv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r12.zzagv = r13     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r12     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0317:
            com.google.android.gms.internal.ads.zzhp r11 = r3.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r11 == 0) goto L_0x036b
            com.google.android.gms.internal.ads.zzhp r11 = r3.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r12 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r13 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzie r14 = r8.zzafd     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r15 = r8.repeatMode     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r7 = r12.zza((int) r7, (com.google.android.gms.internal.ads.zzif) r13, (com.google.android.gms.internal.ads.zzie) r14, (int) r15)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == r5) goto L_0x034e
            java.lang.Object r12 = r11.zzagx     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r13 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r14 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r13 = r13.zza((int) r7, (com.google.android.gms.internal.ads.zzif) r14, (boolean) r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r13 = r13.zzagx     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r12 = r12.equals(r13)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r12 == 0) goto L_0x034e
            boolean r3 = r8.zzx(r7)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11.zzc(r7, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r11 != r3) goto L_0x034a
            r3 = 1
            goto L_0x034b
        L_0x034a:
            r3 = 0
        L_0x034b:
            r2 = r2 | r3
            r3 = r11
            goto L_0x0317
        L_0x034e:
            if (r2 != 0) goto L_0x0364
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r5 = r3.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r5 = r8.zzb((int) r2, (long) r5)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r3 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.<init>(r2, r5)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x036b
        L_0x0364:
            r8.zzagl = r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzahe = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            zza((com.google.android.gms.internal.ads.zzhp) r11)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x036b:
            r8.zzb((java.lang.Object) r1, (int) r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x036e:
            return r10
        L_0x036f:
            r8.zzj(r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhx r1 = r8.zzafv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzfg()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.setState(r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            monitor-enter(r37)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagd = r10     // Catch:{ all -> 0x0382 }
            r37.notifyAll()     // Catch:{ all -> 0x0382 }
            monitor-exit(r37)     // Catch:{ all -> 0x0382 }
            return r10
        L_0x0382:
            r0 = move-exception
            r1 = r0
            monitor-exit(r37)     // Catch:{ all -> 0x0382 }
            throw r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0386:
            r37.zzex()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            return r10
        L_0x038a:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhz r1 = (com.google.android.gms.internal.ads.zzhz) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzpk r2 = r8.zzaga     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x0399
            com.google.android.gms.internal.ads.zzpk r2 = r8.zzaga     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhz r1 = r2.zzb(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x039f
        L_0x0399:
            com.google.android.gms.internal.ads.zzps r2 = r8.zzafw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhz r1 = r2.zzb(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x039f:
            r8.zzafp = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r2 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            return r10
        L_0x03ab:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhr r1 = (com.google.android.gms.internal.ads.zzhr) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x03bc
            int r2 = r8.zzagi     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2 + r10
            r8.zzagi = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagj = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0448
        L_0x03bc:
            android.util.Pair r2 = r8.zza((com.google.android.gms.internal.ads.zzhr) r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x03e0
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.<init>(r9, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r2 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.<init>(r9, r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.setState(r15)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzj(r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0448
        L_0x03e0:
            long r3 = r1.zzahj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03e8
            r1 = 1
            goto L_0x03e9
        L_0x03e8:
            r1 = 0
        L_0x03e9:
            java.lang.Object r3 = r2.first     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r3 = r3.intValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r2 = r2.second     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r4 = r2.longValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafq     // Catch:{ all -> 0x0449 }
            int r2 = r2.zzags     // Catch:{ all -> 0x0449 }
            if (r3 != r2) goto L_0x0425
            r16 = 1000(0x3e8, double:4.94E-321)
            long r6 = r4 / r16
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafq     // Catch:{ all -> 0x0449 }
            long r11 = r2.zzagu     // Catch:{ all -> 0x0449 }
            long r11 = r11 / r16
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0425
            com.google.android.gms.internal.ads.zzho r2 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.<init>(r3, r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r2 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x041a
            r1 = 1
            goto L_0x041b
        L_0x041a:
            r1 = 0
        L_0x041b:
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0448
        L_0x0425:
            long r6 = r8.zzb((int) r3, (long) r4)     // Catch:{ all -> 0x0449 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x042f
            r2 = 1
            goto L_0x0430
        L_0x042f:
            r2 = 0
        L_0x0430:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzho r2 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.<init>(r3, r6)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r2 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x043e
            r1 = 1
            goto L_0x043f
        L_0x043e:
            r1 = 0
        L_0x043f:
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0448:
            return r10
        L_0x0449:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzho r6 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r6.<init>(r3, r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r6     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r3 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x0458
            r1 = 1
            goto L_0x0459
        L_0x0458:
            r1 = 0
        L_0x0459:
            com.google.android.gms.internal.ads.zzho r4 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            throw r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0463:
            r16 = 1000(0x3e8, double:4.94E-321)
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r1 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != 0) goto L_0x0475
            com.google.android.gms.internal.ads.zzne r1 = r8.zzagb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzid()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r14 = r5
            goto L_0x06cc
        L_0x0475:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != 0) goto L_0x047e
            com.google.android.gms.internal.ads.zzho r1 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = r1.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x04bc
        L_0x047e:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = r1.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r2 = r2.zzahb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x04c9
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r2 = r2.zzfb()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x04c9
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r7 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r2 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzif) r7, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r14 = r2.zzaiz     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x049f
            goto L_0x04c9
        L_0x049f:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x04b0
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.index     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r7 = r7.index     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04c9
        L_0x04b0:
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r7 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzie r14 = r8.zzafd     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r15 = r8.repeatMode     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzif) r7, (com.google.android.gms.internal.ads.zzie) r14, (int) r15)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x04bc:
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.zzfk()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 < r2) goto L_0x04cc
            com.google.android.gms.internal.ads.zzne r1 = r8.zzagb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzid()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x04c9:
            r14 = r5
            goto L_0x059c
        L_0x04cc:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x04d6
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r2.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x04d4:
            r14 = r5
            goto L_0x052b
        L_0x04d6:
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r7 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzif) r7, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzie r7 = r8.zzafd     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zza((int) r9, (com.google.android.gms.internal.ads.zzie) r7, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x04e7
            goto L_0x04d4
        L_0x04e7:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r1 = r1.zzfa()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r7 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r14 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r14 = r14.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r15 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r7 = r7.zza((int) r14, (com.google.android.gms.internal.ads.zzif) r15, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r14 = r7.zzaiz     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r1 = r1 + r14
            long r14 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzid r7 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r14 = 0
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r21 = java.lang.Math.max(r3, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1 = r37
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r19
            r6 = r21
            android.util.Pair r1 = r1.zza(r2, r3, r4, r6)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x059c
            java.lang.Object r2 = r1.first     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.intValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r1 = r1.second     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r1.longValue()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1 = r2
        L_0x052b:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x0536
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x0533:
            r26 = r5
            goto L_0x054c
        L_0x0536:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r5 = r2.zzfa()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r7 = r7.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r11 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r2 = r2.zza((int) r7, (com.google.android.gms.internal.ads.zzif) r11, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r12 = r2.zzaiz     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r5 = r5 + r12
            goto L_0x0533
        L_0x054c:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x0553
            r32 = 0
            goto L_0x055a
        L_0x0553:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.index     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2 + r10
            r32 = r2
        L_0x055a:
            boolean r34 = r8.zzx(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r5 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzif) r5, (boolean) r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = new com.google.android.gms.internal.ads.zzhp     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzib[] r6 = r8.zzafu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzoh r7 = r8.zzaey     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhx r11 = r8.zzafv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzne r12 = r8.zzagb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r13 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            java.lang.Object r13 = r13.zzagx     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r23 = r2
            r24 = r5
            r25 = r6
            r28 = r7
            r29 = r11
            r30 = r12
            r31 = r13
            r33 = r1
            r35 = r3
            r23.<init>(r24, r25, r26, r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x0592
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzahe = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0592:
            r8.zzagl = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r1 = r2.zzagw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zza(r8, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzi(r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x059c:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x05b5
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r1 = r1.zzfb()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x05a9
            goto L_0x05b5
        L_0x05a9:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x05b8
            boolean r1 = r8.zzafk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != 0) goto L_0x05b8
            r37.zzez()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x05b8
        L_0x05b5:
            r8.zzi(r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x05b8:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x06cc
        L_0x05bc:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == r2) goto L_0x05f9
            long r1 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r3.zzaha     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x05f9
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.release()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r1.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzb((com.google.android.gms.internal.ads.zzhp) r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r3.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.<init>(r2, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r37.zzew()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r1 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = 5
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x05bc
        L_0x05f9:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r1 = r1.zzahb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x0623
            r1 = 0
        L_0x0600:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 >= r2) goto L_0x06cc
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = r2[r1]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznn[] r3 = r3.zzagy     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3 = r3[r1]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 == 0) goto L_0x0620
            com.google.android.gms.internal.ads.zznn r4 = r2.zzee()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r4 != r3) goto L_0x0620
            boolean r3 = r2.zzef()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 == 0) goto L_0x0620
            r2.zzeg()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0620:
            int r1 = r1 + 1
            goto L_0x0600
        L_0x0623:
            r1 = 0
        L_0x0624:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 >= r2) goto L_0x0646
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = r2[r1]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznn[] r3 = r3.zzagy     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3 = r3[r1]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznn r4 = r2.zzee()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r4 != r3) goto L_0x06cc
            if (r3 == 0) goto L_0x0643
            boolean r2 = r2.zzef()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x0643
            goto L_0x06cc
        L_0x0643:
            int r1 = r1 + 1
            goto L_0x0624
        L_0x0646:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r1.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x06cc
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r1.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r1 = r1.zzahc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x06cc
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzoj r1 = r1.zzahf     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r2.zzahe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzagm = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzoj r2 = r2.zzahf     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r3 = r3.zzagw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r3.zzhu()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0673
            r3 = 1
            goto L_0x0674
        L_0x0673:
            r3 = 0
        L_0x0674:
            r4 = 0
        L_0x0675:
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r5 = r5.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r4 >= r5) goto L_0x06cc
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.zzaex     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5 = r5[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzoi r6 = r1.zzbii     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzog r6 = r6.zzbh(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r6 == 0) goto L_0x06c9
            if (r3 != 0) goto L_0x06c6
            boolean r6 = r5.zzeh()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r6 != 0) goto L_0x06c9
            com.google.android.gms.internal.ads.zzoi r6 = r2.zzbii     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzog r6 = r6.zzbh(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzia[] r7 = r1.zzbik     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r7 = r7[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzia[] r11 = r2.zzbik     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11 = r11[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r6 == 0) goto L_0x06c6
            boolean r7 = r11.equals(r7)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == 0) goto L_0x06c6
            int r7 = r6.length()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzht[] r11 = new com.google.android.gms.internal.ads.zzht[r7]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r12 = 0
        L_0x06ab:
            if (r12 >= r7) goto L_0x06b6
            com.google.android.gms.internal.ads.zzht r13 = r6.zzbe(r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11[r12] = r13     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r12 = r12 + 1
            goto L_0x06ab
        L_0x06b6:
            com.google.android.gms.internal.ads.zzhp r6 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznn[] r6 = r6.zzagy     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r6 = r6[r4]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzagm     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r12 = r7.zzfa()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5.zza(r11, r6, r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x06c9
        L_0x06c6:
            r5.zzeg()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x06c9:
            int r4 = r4 + 1
            goto L_0x0675
        L_0x06cc:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = 10
            if (r1 != 0) goto L_0x06da
            r37.zzey()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zza((long) r14, (long) r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0866
        L_0x06da:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzpu.beginSection(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r37.zzew()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r1 = r1.zzagw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r4 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r4 = r4.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.zzef(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.zzagc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r4 = r1.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x06f3:
            if (r5 >= r4) goto L_0x072a
            r11 = r1[r5]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r12 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = r8.zzagh     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r11.zzb(r12, r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == 0) goto L_0x0708
            boolean r2 = r11.zzfi()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x0708
            r7 = 1
            goto L_0x0709
        L_0x0708:
            r7 = 0
        L_0x0709:
            boolean r2 = r11.isReady()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x0718
            boolean r2 = r11.zzfi()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x0716
            goto L_0x0718
        L_0x0716:
            r2 = 0
            goto L_0x0719
        L_0x0718:
            r2 = 1
        L_0x0719:
            if (r2 != 0) goto L_0x071e
            r11.zzei()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x071e:
            if (r6 == 0) goto L_0x0724
            if (r2 == 0) goto L_0x0724
            r6 = 1
            goto L_0x0725
        L_0x0724:
            r6 = 0
        L_0x0725:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x06f3
        L_0x072a:
            if (r6 != 0) goto L_0x072f
            r37.zzey()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x072f:
            com.google.android.gms.internal.ads.zzpk r1 = r8.zzaga     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x0754
            com.google.android.gms.internal.ads.zzpk r1 = r8.zzaga     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhz r1 = r1.zzfw()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafp     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r2 = r1.equals(r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x0754
            r8.zzafp = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzps r2 = r8.zzafw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzpk r3 = r8.zzaga     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zza(r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r2 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0754:
            com.google.android.gms.internal.ads.zzid r1 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r2.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r3 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzif) r3, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r1 = r1.zzaiz     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r7 == 0) goto L_0x0785
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0775
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r3 = r3.zzagu     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0785
        L_0x0775:
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagn     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r3 = r3.zzahb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 == 0) goto L_0x0785
            r3 = 4
            r8.setState(r3)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r37.zzev()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r4 = 2
            goto L_0x081f
        L_0x0785:
            int r3 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r4 = 2
            if (r3 != r4) goto L_0x0804
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.zzagc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r3 = r3.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 <= 0) goto L_0x07f2
            if (r6 == 0) goto L_0x07f0
            boolean r1 = r8.zzage     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r2 = r2.zzahc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 != 0) goto L_0x079e
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = r2.zzagt     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x07a6
        L_0x079e:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zznc r2 = r2.zzagw     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = r2.zzhv()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x07a6:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x07c2
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r2 = r2.zzahb     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r2 == 0) goto L_0x07b4
            r1 = 1
            goto L_0x07ec
        L_0x07b4:
            com.google.android.gms.internal.ads.zzid r2 = r8.zzafl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r3 = r3.zzags     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r5 = r8.zzafe     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzif r2 = r2.zza((int) r3, (com.google.android.gms.internal.ads.zzif) r5, (boolean) r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = r2.zzaiz     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x07c2:
            boolean r5 = r8.zzago     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r5 == 0) goto L_0x07dc
            com.google.android.gms.internal.ads.zzhx r2 = r8.zzafv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r5 = r3.zzagv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r3 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r18 = r3.zzfa()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r11 - r18
            long r5 = r5 - r11
            boolean r1 = r2.zzc(r5, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x07ec
        L_0x07dc:
            com.google.android.gms.internal.ads.zzhx r5 = r8.zzafv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhp r6 = r8.zzagl     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r8.zzagk     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r6 = r6.zzfa()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzc(r2, r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x07ec:
            if (r1 == 0) goto L_0x07f0
            r1 = 1
            goto L_0x07f6
        L_0x07f0:
            r1 = 0
            goto L_0x07f6
        L_0x07f2:
            boolean r1 = r8.zzdr(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x07f6:
            if (r1 == 0) goto L_0x081f
            r1 = 3
            r8.setState(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            boolean r1 = r8.zzafg     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x081f
            r37.zzeu()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x081f
        L_0x0804:
            int r3 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5 = 3
            if (r3 != r5) goto L_0x081f
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.zzagc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r3 = r3.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r3 <= 0) goto L_0x080f
            goto L_0x0813
        L_0x080f:
            boolean r6 = r8.zzdr(r1)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0813:
            if (r6 != 0) goto L_0x081f
            boolean r1 = r8.zzafg     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzage = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.setState(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r37.zzev()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x081f:
            int r1 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != r4) goto L_0x0830
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.zzagc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r2 = r1.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0826:
            if (r9 >= r2) goto L_0x0830
            r3 = r1[r9]     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzei()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r9 = r9 + 1
            goto L_0x0826
        L_0x0830:
            boolean r1 = r8.zzafg     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x0839
            int r1 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = 3
            if (r1 == r2) goto L_0x083d
        L_0x0839:
            int r1 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != r4) goto L_0x084b
        L_0x083d:
            int r1 = r8.zzagp     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 <= 0) goto L_0x0845
            int r1 = r8.zzagp     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r2 = (long) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0847
        L_0x0845:
            r2 = 10
        L_0x0847:
            r8.zza((long) r14, (long) r2)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0863
        L_0x084b:
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.zzagc     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = r1.length     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x085e
            int r1 = r8.zzagq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 <= 0) goto L_0x0858
            int r1 = r8.zzagq     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            long r12 = (long) r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x085a
        L_0x0858:
            r12 = r16
        L_0x085a:
            r8.zza((long) r14, (long) r12)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0863
        L_0x085e:
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.removeMessages(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0863:
            com.google.android.gms.internal.ads.zzpu.endSection()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0866:
            return r10
        L_0x0867:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x086e
            r1 = 1
            goto L_0x086f
        L_0x086e:
            r1 = 0
        L_0x086f:
            r8.zzage = r9     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafg = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != 0) goto L_0x087c
            r37.zzev()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r37.zzew()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0893
        L_0x087c:
            int r1 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2 = 3
            if (r1 != r2) goto L_0x088a
            r37.zzeu()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            goto L_0x0893
        L_0x088a:
            int r1 = r8.state     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 != r4) goto L_0x0893
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x0893:
            return r10
        L_0x0894:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzne r2 = (com.google.android.gms.internal.ads.zzne) r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x089f
            r1 = 1
            goto L_0x08a0
        L_0x089f:
            r1 = 0
        L_0x08a0:
            android.os.Handler r3 = r8.zzafa     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.sendEmptyMessage(r9)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzj(r10)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhx r3 = r8.zzafv     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r3.zzff()     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            if (r1 == 0) goto L_0x08bb
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.zzafq = r1     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
        L_0x08bb:
            r8.zzagb = r2     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            com.google.android.gms.internal.ads.zzhh r1 = r8.zzafy     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r2.zza(r1, r10, r8)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r8.setState(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x090f, IOException -> 0x08ed, RuntimeException -> 0x08cb }
            return r10
        L_0x08cb:
            r0 = move-exception
            r1 = r0
            java.lang.String r12 = "ExoPlayerImplInternal"
            java.lang.String r13 = "Internal runtime error."
            r11 = 6
            java.lang.String r15 = "com.google.android.gms.internal.ads.zzhm"
            r16 = 552(0x228, float:7.74E-43)
            r14 = r1
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)
            android.os.Handler r2 = r8.zzafa
            com.google.android.gms.internal.ads.zzhe r1 = com.google.android.gms.internal.ads.zzhe.zza((java.lang.RuntimeException) r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r37.zzex()
            return r10
        L_0x08ed:
            r0 = move-exception
            r1 = r0
            java.lang.String r3 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            r2 = 6
            java.lang.String r6 = "com.google.android.gms.internal.ads.zzhm"
            r7 = 547(0x223, float:7.67E-43)
            r5 = r1
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            android.os.Handler r2 = r8.zzafa
            com.google.android.gms.internal.ads.zzhe r1 = com.google.android.gms.internal.ads.zzhe.zza((java.io.IOException) r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r37.zzex()
            return r10
        L_0x090f:
            r0 = move-exception
            r1 = r0
            java.lang.String r3 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            r2 = 6
            java.lang.String r6 = "com.google.android.gms.internal.ads.zzhm"
            r7 = 542(0x21e, float:7.6E-43)
            r5 = r1
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            android.os.Handler r2 = r8.zzafa
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r37.zzex()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.handleMessage(android.os.Message):boolean");
    }

    public final void zzv(int i) {
        this.zzagp = i;
    }

    public final void zzw(int i) {
        this.zzagq = i;
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzafa.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        if (this.zzafk != z) {
            this.zzafk = z;
            this.zzafa.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzeu() throws zzhe {
        this.zzage = false;
        this.zzafw.start();
        for (zzhy start : this.zzagc) {
            start.start();
        }
    }

    private final void zzev() throws zzhe {
        this.zzafw.stop();
        for (zzhy zza : this.zzagc) {
            zza(zza);
        }
    }

    private final void zzew() throws zzhe {
        long j;
        zzhp zzhp = this.zzagn;
        if (zzhp != null) {
            long zzhu = zzhp.zzagw.zzhu();
            if (zzhu != -9223372036854775807L) {
                zzdq(zzhu);
            } else {
                zzhy zzhy = this.zzafz;
                if (zzhy == null || zzhy.zzfi()) {
                    this.zzagk = this.zzafw.zzgg();
                } else {
                    long zzgg = this.zzaga.zzgg();
                    this.zzagk = zzgg;
                    this.zzafw.zzel(zzgg);
                }
                zzhu = this.zzagk - this.zzagn.zzfa();
            }
            this.zzafq.zzagu = zzhu;
            this.zzagh = SystemClock.elapsedRealtime() * 1000;
            if (this.zzagc.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzagn.zzagw.zzhv();
            }
            zzho zzho = this.zzafq;
            if (j == Long.MIN_VALUE) {
                j = this.zzafl.zza(this.zzagn.zzags, this.zzafe, false).zzaiz;
            }
            zzho.zzagv = j;
        }
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zzb(int i, long j) throws zzhe {
        zzhp zzhp;
        zzev();
        this.zzage = false;
        setState(2);
        zzhp zzhp2 = this.zzagn;
        if (zzhp2 == null) {
            zzhp zzhp3 = this.zzagl;
            if (zzhp3 != null) {
                zzhp3.release();
            }
            zzhp = null;
        } else {
            zzhp = null;
            while (zzhp2 != null) {
                if (zzhp2.zzags != i || !zzhp2.zzahc) {
                    zzhp2.release();
                } else {
                    zzhp = zzhp2;
                }
                zzhp2 = zzhp2.zzahe;
            }
        }
        zzhp zzhp4 = this.zzagn;
        if (!(zzhp4 == zzhp && zzhp4 == this.zzagm)) {
            for (zzhy disable : this.zzagc) {
                disable.disable();
            }
            this.zzagc = new zzhy[0];
            this.zzaga = null;
            this.zzafz = null;
            this.zzagn = null;
        }
        if (zzhp != null) {
            zzhp.zzahe = null;
            this.zzagl = zzhp;
            this.zzagm = zzhp;
            zzb(zzhp);
            if (this.zzagn.zzahd) {
                j = this.zzagn.zzagw.zzeg(j);
            }
            zzdq(j);
            zzez();
        } else {
            this.zzagl = null;
            this.zzagm = null;
            this.zzagn = null;
            zzdq(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final void zzdq(long j) throws zzhe {
        long j2;
        zzhp zzhp = this.zzagn;
        if (zzhp == null) {
            j2 = 60000000;
        } else {
            j2 = zzhp.zzfa();
        }
        long j3 = j + j2;
        this.zzagk = j3;
        this.zzafw.zzel(j3);
        for (zzhy zzdm : this.zzagc) {
            zzdm.zzdm(this.zzagk);
        }
    }

    private final void zzex() {
        zzj(true);
        this.zzafv.onStopped();
        setState(1);
    }

    private final void zzj(boolean z) {
        this.handler.removeMessages(2);
        this.zzage = false;
        this.zzafw.stop();
        this.zzaga = null;
        this.zzafz = null;
        this.zzagk = 60000000;
        for (zzhy zzhy : this.zzagc) {
            try {
                zza(zzhy);
                zzhy.disable();
            } catch (zzhe | RuntimeException e) {
                SystemUtils.log(6, "ExoPlayerImplInternal", "Stop failed.", e, "com.google.android.gms.internal.ads.zzhm", 671);
            }
        }
        this.zzagc = new zzhy[0];
        zzhp zzhp = this.zzagn;
        if (zzhp == null) {
            zzhp = this.zzagl;
        }
        zza(zzhp);
        this.zzagl = null;
        this.zzagm = null;
        this.zzagn = null;
        zzi(false);
        if (z) {
            zzne zzne = this.zzagb;
            if (zzne != null) {
                zzne.zzie();
                this.zzagb = null;
            }
            this.zzafl = null;
        }
    }

    private static void zza(zzhy zzhy) throws zzhe {
        if (zzhy.getState() == 2) {
            zzhy.stop();
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzafq.zzagu < j) {
            return true;
        }
        return this.zzagn.zzahe != null && this.zzagn.zzahe.zzahc;
    }

    private final void zzey() throws IOException {
        zzhp zzhp = this.zzagl;
        if (zzhp != null && !zzhp.zzahc) {
            zzhp zzhp2 = this.zzagm;
            if (zzhp2 == null || zzhp2.zzahe == this.zzagl) {
                zzhy[] zzhyArr = this.zzagc;
                int length = zzhyArr.length;
                int i = 0;
                while (i < length) {
                    if (zzhyArr[i].zzef()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzagl.zzagw.zzhs();
            }
        }
    }

    private final void zza(Object obj, int i) {
        this.zzafq = new zzho(0, 0);
        zzb(obj, i);
        this.zzafq = new zzho(0, -9223372036854775807L);
        setState(4);
        zzj(false);
    }

    private final void zzb(Object obj, int i) {
        this.zzafa.obtainMessage(6, new zzhq(this.zzafl, obj, this.zzafq, i)).sendToTarget();
    }

    private final int zza(int i, zzid zzid, zzid zzid2) {
        int zzfk = zzid.zzfk();
        int i2 = -1;
        for (int i3 = 0; i3 < zzfk && i2 == -1; i3++) {
            i = zzid.zza(i, this.zzafe, this.zzafd, this.repeatMode);
            i2 = zzid2.zzc(zzid.zza(i, this.zzafe, true).zzagx);
        }
        return i2;
    }

    private final boolean zzx(int i) {
        this.zzafl.zza(i, this.zzafe, false);
        this.zzafl.zza(0, this.zzafd, false);
        if (this.zzafl.zza(i, this.zzafe, this.zzafd, this.repeatMode) == -1) {
            return true;
        }
        return false;
    }

    private final Pair<Integer, Long> zza(zzhr zzhr) {
        zzid zzid = zzhr.zzafl;
        if (zzid.isEmpty()) {
            zzid = this.zzafl;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzid, zzhr.zzahi, zzhr.zzahj);
            zzid zzid2 = this.zzafl;
            if (zzid2 == zzid) {
                return zzb;
            }
            int zzc = zzid2.zzc(zzid.zza(((Integer) zzb.first).intValue(), this.zzafe, true).zzagx);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzid, this.zzafl);
            if (zza == -1) {
                return null;
            }
            this.zzafl.zza(zza, this.zzafe, false);
            return zzc(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhu(this.zzafl, zzhr.zzahi, zzhr.zzahj);
        }
    }

    private final Pair<Integer, Long> zzc(int i, long j) {
        return zzb(this.zzafl, 0, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzid zzid, int i, long j) {
        return zza(zzid, i, j, 0);
    }

    private final Pair<Integer, Long> zza(zzid zzid, int i, long j, long j2) {
        zzpg.zzc(i, 0, zzid.zzfj());
        zzid.zza(i, this.zzafd, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = j + 0;
        long j4 = zzid.zza(0, this.zzafe, false).zzaiz;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void zzez() {
        long j;
        if (!this.zzagl.zzahc) {
            j = 0;
        } else {
            j = this.zzagl.zzagw.zzhr();
        }
        if (j == Long.MIN_VALUE) {
            zzi(false);
            return;
        }
        long zzfa = this.zzagk - this.zzagl.zzfa();
        boolean zzdt = this.zzafv.zzdt(j - zzfa);
        zzi(zzdt);
        if (zzdt) {
            this.zzagl.zzagw.zzee(zzfa);
        }
    }

    private static void zza(zzhp zzhp) {
        while (zzhp != null) {
            zzhp.release();
            zzhp = zzhp.zzahe;
        }
    }

    private final void zzb(zzhp zzhp) throws zzhe {
        if (this.zzagn != zzhp) {
            boolean[] zArr = new boolean[this.zzaex.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzhy[] zzhyArr = this.zzaex;
                if (i < zzhyArr.length) {
                    zzhy zzhy = zzhyArr[i];
                    zArr[i] = zzhy.getState() != 0;
                    zzog zzbh = zzhp.zzahf.zzbii.zzbh(i);
                    if (zzbh != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzbh == null || (zzhy.zzeh() && zzhy.zzee() == this.zzagn.zzagy[i]))) {
                        if (zzhy == this.zzafz) {
                            this.zzafw.zza(this.zzaga);
                            this.zzaga = null;
                            this.zzafz = null;
                        }
                        zza(zzhy);
                        zzhy.disable();
                    }
                    i++;
                } else {
                    this.zzagn = zzhp;
                    this.zzafa.obtainMessage(3, zzhp.zzahf).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzhe {
        this.zzagc = new zzhy[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhy[] zzhyArr = this.zzaex;
            if (i2 < zzhyArr.length) {
                zzhy zzhy = zzhyArr[i2];
                zzog zzbh = this.zzagn.zzahf.zzbii.zzbh(i2);
                if (zzbh != null) {
                    int i4 = i3 + 1;
                    this.zzagc[i3] = zzhy;
                    if (zzhy.getState() == 0) {
                        zzia zzia = this.zzagn.zzahf.zzbik[i2];
                        boolean z = this.zzafg && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        int length = zzbh.length();
                        zzht[] zzhtArr = new zzht[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            zzhtArr[i5] = zzbh.zzbe(i5);
                        }
                        zzhy.zza(zzia, zzhtArr, this.zzagn.zzagy[i2], this.zzagk, z2, this.zzagn.zzfa());
                        zzpk zzed = zzhy.zzed();
                        if (zzed != null) {
                            if (this.zzaga == null) {
                                this.zzaga = zzed;
                                this.zzafz = zzhy;
                                zzed.zzb(this.zzafp);
                            } else {
                                throw zzhe.zza((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzhy.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public final /* synthetic */ void zza(zznq zznq) {
        this.handler.obtainMessage(9, (zznc) zznq).sendToTarget();
    }
}
