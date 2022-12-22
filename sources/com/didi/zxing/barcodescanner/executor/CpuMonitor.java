package com.didi.zxing.barcodescanner.executor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.sdk.apm.SystemUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class CpuMonitor {

    /* renamed from: a */
    private static final String f45399a = "CpuMonitor";

    /* renamed from: b */
    private static final int f45400b = 5;

    /* renamed from: c */
    private static final int f45401c = 2000;

    /* renamed from: d */
    private static final int f45402d = 6000;

    /* renamed from: e */
    private final Context f45403e;

    /* renamed from: f */
    private final MovingAverage f45404f = new MovingAverage(5);

    /* renamed from: g */
    private final MovingAverage f45405g = new MovingAverage(5);

    /* renamed from: h */
    private final MovingAverage f45406h = new MovingAverage(5);

    /* renamed from: i */
    private final MovingAverage f45407i = new MovingAverage(5);

    /* renamed from: j */
    private ScheduledExecutorService f45408j;

    /* renamed from: k */
    private long f45409k = SystemClock.elapsedRealtime();

    /* renamed from: l */
    private long[] f45410l;

    /* renamed from: m */
    private int f45411m;

    /* renamed from: n */
    private int f45412n;

    /* renamed from: o */
    private boolean f45413o;

    /* renamed from: p */
    private boolean f45414p;

    /* renamed from: q */
    private String[] f45415q;

    /* renamed from: r */
    private String[] f45416r;

    /* renamed from: s */
    private double[] f45417s;

    /* renamed from: t */
    private ProcStat f45418t;

    /* renamed from: a */
    private int m32587a(double d) {
        return (int) ((d * 100.0d) + 0.5d);
    }

    private static class ProcStat {
        final long idleTime;
        final long systemTime;
        final long userTime;

        ProcStat(long j, long j2, long j3) {
            this.userTime = j;
            this.systemTime = j2;
            this.idleTime = j3;
        }
    }

    private static class MovingAverage {
        private double[] circBuffer;
        private int circBufferIndex;
        private double currentValue;
        private final int size;
        private double sum;

        public MovingAverage(int i) {
            if (i > 0) {
                this.size = i;
                this.circBuffer = new double[i];
                return;
            }
            throw new AssertionError("Size value in MovingAverage ctor should be positive.");
        }

        public void reset() {
            Arrays.fill(this.circBuffer, 0.0d);
            this.circBufferIndex = 0;
            this.sum = 0.0d;
            this.currentValue = 0.0d;
        }

        public void addValue(double d) {
            double d2 = this.sum;
            double[] dArr = this.circBuffer;
            int i = this.circBufferIndex;
            double d3 = d2 - dArr[i];
            this.sum = d3;
            int i2 = i + 1;
            this.circBufferIndex = i2;
            dArr[i] = d;
            this.currentValue = d;
            this.sum = d3 + d;
            if (i2 >= this.size) {
                this.circBufferIndex = 0;
            }
        }

        public double getCurrent() {
            return this.currentValue;
        }

        public double getAverage() {
            return this.sum / ((double) this.size);
        }
    }

    public CpuMonitor(Context context) {
        SystemUtils.log(3, f45399a, "CpuMonitor ctor.", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 156);
        this.f45403e = context.getApplicationContext();
        m32591g();
    }

    /* renamed from: a */
    public void mo113766a() {
        if (this.f45408j != null) {
            SystemUtils.log(3, f45399a, "pause", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 169);
            this.f45408j.shutdownNow();
        }
    }

    /* renamed from: b */
    public void mo113767b() {
        SystemUtils.log(3, f45399a, "resume", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 176);
        m32594j();
        m32591g();
    }

    /* renamed from: c */
    public synchronized void mo113768c() {
        if (this.f45408j != null) {
            SystemUtils.log(3, f45399a, "reset", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 183);
            m32594j();
            this.f45414p = false;
        }
    }

    /* renamed from: d */
    public synchronized int mo113769d() {
        return m32587a(this.f45404f.getCurrent() + this.f45405g.getCurrent());
    }

    /* renamed from: e */
    public synchronized int mo113770e() {
        return m32587a(this.f45404f.getAverage() + this.f45405g.getAverage());
    }

    /* renamed from: f */
    public synchronized int mo113771f() {
        return m32587a(this.f45407i.getAverage());
    }

    /* renamed from: g */
    private void m32591g() {
        ScheduledExecutorService scheduledExecutorService = this.f45408j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f45408j = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                CpuMonitor.this.m32592h();
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m32592h() {
        if (m32596l() && SystemClock.elapsedRealtime() - this.f45409k >= 6000) {
            this.f45409k = SystemClock.elapsedRealtime();
            SystemUtils.log(3, f45399a, m32597m(), (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 223);
        }
    }

    /* renamed from: i */
    private void m32593i() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/present");
            try {
                Scanner useDelimiter = new Scanner(new BufferedReader(fileReader)).useDelimiter("[-\n]");
                useDelimiter.nextInt();
                this.f45411m = useDelimiter.nextInt() + 1;
                useDelimiter.close();
            } catch (Exception unused) {
                SystemUtils.log(6, f45399a, "Cannot do CPU stats due to /sys/devices/system/cpu/present parsing problem", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 237);
            }
            fileReader.close();
        } catch (FileNotFoundException unused2) {
            SystemUtils.log(6, f45399a, "Cannot do CPU stats since /sys/devices/system/cpu/present is missing", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 242);
        } catch (IOException unused3) {
            SystemUtils.log(6, f45399a, "Error closing file", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 244);
        } catch (Throwable th) {
            fileReader.close();
            throw th;
        }
        int i = this.f45411m;
        this.f45410l = new long[i];
        this.f45415q = new String[i];
        this.f45416r = new String[i];
        this.f45417s = new double[i];
        for (int i2 = 0; i2 < this.f45411m; i2++) {
            this.f45410l[i2] = 0;
            this.f45417s[i2] = 0.0d;
            String[] strArr = this.f45415q;
            strArr[i2] = "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.f45416r;
            strArr2[i2] = "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/scaling_cur_freq";
        }
        this.f45418t = new ProcStat(0, 0, 0);
        m32594j();
        this.f45413o = true;
    }

    /* renamed from: j */
    private synchronized void m32594j() {
        this.f45404f.reset();
        this.f45405g.reset();
        this.f45406h.reset();
        this.f45407i.reset();
        this.f45409k = SystemClock.elapsedRealtime();
    }

    /* renamed from: k */
    private int m32595k() {
        Intent intent = null;
        try {
            intent = this.f45403e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        int intExtra = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 100);
        if (intExtra > 0) {
            return (int) ((((float) intent.getIntExtra("level", 0)) * 100.0f) / ((float) intExtra));
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0105, code lost:
        return false;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m32596l() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            boolean r0 = r1.f45413o     // Catch:{ all -> 0x0117 }
            if (r0 != 0) goto L_0x000a
            r21.m32593i()     // Catch:{ all -> 0x0117 }
        L_0x000a:
            int r0 = r1.f45411m     // Catch:{ all -> 0x0117 }
            r2 = 0
            if (r0 != 0) goto L_0x0011
            monitor-exit(r21)
            return r2
        L_0x0011:
            r1.f45412n = r2     // Catch:{ all -> 0x0117 }
            r3 = 0
            r5 = r3
            r7 = r5
            r9 = r7
            r0 = 0
        L_0x0019:
            int r11 = r1.f45411m     // Catch:{ all -> 0x0117 }
            r12 = 1
            r13 = 0
            if (r0 >= r11) goto L_0x0095
            double[] r11 = r1.f45417s     // Catch:{ all -> 0x0117 }
            r11[r0] = r13     // Catch:{ all -> 0x0117 }
            long[] r11 = r1.f45410l     // Catch:{ all -> 0x0117 }
            r13 = r11[r0]     // Catch:{ all -> 0x0117 }
            int r11 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r11 != 0) goto L_0x0068
            java.lang.String[] r11 = r1.f45415q     // Catch:{ all -> 0x0117 }
            r11 = r11[r0]     // Catch:{ all -> 0x0117 }
            long r13 = r1.m32588a((java.lang.String) r11)     // Catch:{ all -> 0x0117 }
            int r11 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r11 <= 0) goto L_0x006d
            java.lang.String r16 = "CpuMonitor"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            r9.<init>()     // Catch:{ all -> 0x0117 }
            java.lang.String r10 = "Core "
            r9.append(r10)     // Catch:{ all -> 0x0117 }
            r9.append(r0)     // Catch:{ all -> 0x0117 }
            java.lang.String r10 = ". Max frequency: "
            r9.append(r10)     // Catch:{ all -> 0x0117 }
            r9.append(r13)     // Catch:{ all -> 0x0117 }
            java.lang.String r17 = r9.toString()     // Catch:{ all -> 0x0117 }
            r15 = 3
            r18 = 0
            java.lang.String r19 = "com.didi.zxing.barcodescanner.executor.CpuMonitor"
            r20 = 319(0x13f, float:4.47E-43)
            com.didi.sdk.apm.SystemUtils.log(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0117 }
            long[] r9 = r1.f45410l     // Catch:{ all -> 0x0117 }
            r9[r0] = r13     // Catch:{ all -> 0x0117 }
            java.lang.String[] r9 = r1.f45415q     // Catch:{ all -> 0x0117 }
            r10 = 0
            r9[r0] = r10     // Catch:{ all -> 0x0117 }
            r9 = r13
            goto L_0x006d
        L_0x0068:
            long[] r9 = r1.f45410l     // Catch:{ all -> 0x0117 }
            r10 = r9[r0]     // Catch:{ all -> 0x0117 }
            r9 = r10
        L_0x006d:
            java.lang.String[] r11 = r1.f45416r     // Catch:{ all -> 0x0117 }
            r11 = r11[r0]     // Catch:{ all -> 0x0117 }
            long r13 = r1.m32588a((java.lang.String) r11)     // Catch:{ all -> 0x0117 }
            int r11 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r11 != 0) goto L_0x007e
            int r15 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x007e
            goto L_0x0092
        L_0x007e:
            if (r11 <= 0) goto L_0x0085
            int r11 = r1.f45412n     // Catch:{ all -> 0x0117 }
            int r11 = r11 + r12
            r1.f45412n = r11     // Catch:{ all -> 0x0117 }
        L_0x0085:
            long r5 = r5 + r13
            long r7 = r7 + r9
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 <= 0) goto L_0x0092
            double[] r11 = r1.f45417s     // Catch:{ all -> 0x0117 }
            double r12 = (double) r13     // Catch:{ all -> 0x0117 }
            double r14 = (double) r9     // Catch:{ all -> 0x0117 }
            double r12 = r12 / r14
            r11[r0] = r12     // Catch:{ all -> 0x0117 }
        L_0x0092:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x0095:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0107
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x009e
            goto L_0x0107
        L_0x009e:
            double r5 = (double) r5     // Catch:{ all -> 0x0117 }
            double r7 = (double) r7     // Catch:{ all -> 0x0117 }
            double r5 = r5 / r7
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r0 = r1.f45407i     // Catch:{ all -> 0x0117 }
            double r7 = r0.getCurrent()     // Catch:{ all -> 0x0117 }
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b6
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r0 = r1.f45407i     // Catch:{ all -> 0x0117 }
            double r7 = r0.getCurrent()     // Catch:{ all -> 0x0117 }
            double r7 = r7 + r5
            r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r5 = r5 * r7
        L_0x00b6:
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r0 = r21.m32598n()     // Catch:{ all -> 0x0117 }
            if (r0 != 0) goto L_0x00be
            monitor-exit(r21)
            return r2
        L_0x00be:
            long r7 = r0.userTime     // Catch:{ all -> 0x0117 }
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r9 = r1.f45418t     // Catch:{ all -> 0x0117 }
            long r9 = r9.userTime     // Catch:{ all -> 0x0117 }
            long r7 = r7 - r9
            long r9 = r0.systemTime     // Catch:{ all -> 0x0117 }
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r11 = r1.f45418t     // Catch:{ all -> 0x0117 }
            long r2 = r11.systemTime     // Catch:{ all -> 0x0117 }
            long r9 = r9 - r2
            long r2 = r0.idleTime     // Catch:{ all -> 0x0117 }
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r4 = r1.f45418t     // Catch:{ all -> 0x0117 }
            long r12 = r4.idleTime     // Catch:{ all -> 0x0117 }
            long r2 = r2 - r12
            long r12 = r7 + r9
            long r12 = r12 + r2
            r2 = 0
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0104
            r2 = 0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00e3
            goto L_0x0104
        L_0x00e3:
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r2 = r1.f45407i     // Catch:{ all -> 0x0117 }
            r2.addValue(r5)     // Catch:{ all -> 0x0117 }
            double r2 = (double) r7     // Catch:{ all -> 0x0117 }
            double r7 = (double) r12     // Catch:{ all -> 0x0117 }
            double r2 = r2 / r7
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r4 = r1.f45404f     // Catch:{ all -> 0x0117 }
            r4.addValue(r2)     // Catch:{ all -> 0x0117 }
            double r9 = (double) r9     // Catch:{ all -> 0x0117 }
            double r9 = r9 / r7
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r4 = r1.f45405g     // Catch:{ all -> 0x0117 }
            r4.addValue(r9)     // Catch:{ all -> 0x0117 }
            double r2 = r2 + r9
            double r2 = r2 * r5
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r4 = r1.f45406h     // Catch:{ all -> 0x0117 }
            r4.addValue(r2)     // Catch:{ all -> 0x0117 }
            r1.f45418t = r0     // Catch:{ all -> 0x0117 }
            monitor-exit(r21)
            r0 = 1
            return r0
        L_0x0104:
            monitor-exit(r21)
            r0 = 0
            return r0
        L_0x0107:
            java.lang.String r3 = "CpuMonitor"
            java.lang.String r4 = "Could not read max or current frequency for any CPU"
            r2 = 6
            r5 = 0
            java.lang.String r6 = "com.didi.zxing.barcodescanner.executor.CpuMonitor"
            r7 = 351(0x15f, float:4.92E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0117 }
            monitor-exit(r21)
            r0 = 0
            return r0
        L_0x0117:
            r0 = move-exception
            monitor-exit(r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.barcodescanner.executor.CpuMonitor.m32596l():boolean");
    }

    /* renamed from: m */
    private synchronized String m32597m() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("CPU User: ");
        sb.append(m32587a(this.f45404f.getCurrent()));
        sb.append("/");
        sb.append(m32587a(this.f45404f.getAverage()));
        sb.append(". System: ");
        sb.append(m32587a(this.f45405g.getCurrent()));
        sb.append("/");
        sb.append(m32587a(this.f45405g.getAverage()));
        sb.append(". Freq: ");
        sb.append(m32587a(this.f45407i.getCurrent()));
        sb.append("/");
        sb.append(m32587a(this.f45407i.getAverage()));
        sb.append(". Total usage: ");
        sb.append(m32587a(this.f45406h.getCurrent()));
        sb.append("/");
        sb.append(m32587a(this.f45406h.getAverage()));
        sb.append(". Cores: ");
        sb.append(this.f45412n);
        sb.append("( ");
        for (int i = 0; i < this.f45411m; i++) {
            sb.append(m32587a(this.f45417s[i]));
            sb.append(" ");
        }
        sb.append("). Battery: ");
        sb.append(m32595k());
        if (this.f45414p) {
            sb.append(". Overuse.");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private long m32588a(String str) {
        BufferedReader bufferedReader;
        long j = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            j = m32590b(bufferedReader.readLine());
            bufferedReader.close();
        } catch (FileNotFoundException | IOException unused) {
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
        return j;
    }

    /* renamed from: b */
    private static long m32590b(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            SystemUtils.log(6, f45399a, "parseLong error.", e, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 464);
            return 0;
        }
    }

    /* renamed from: n */
    private ProcStat m32598n() {
        BufferedReader bufferedReader;
        long j;
        long j2;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/stat"));
            String[] split = bufferedReader.readLine().split("\\s+");
            int length = split.length;
            long j3 = 0;
            if (length >= 5) {
                j3 = m32590b(split[1]) + m32590b(split[2]);
                j2 = m32590b(split[3]);
                j = m32590b(split[4]);
            } else {
                j2 = 0;
                j = 0;
            }
            if (length >= 8) {
                j3 += m32590b(split[5]);
                j2 = j2 + m32590b(split[6]) + m32590b(split[7]);
            }
            long j4 = j3;
            long j5 = j2;
            bufferedReader.close();
            return new ProcStat(j4, j5, j);
        } catch (Exception unused) {
            bufferedReader.close();
            return null;
        } catch (FileNotFoundException | IOException unused2) {
            return null;
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }
}
