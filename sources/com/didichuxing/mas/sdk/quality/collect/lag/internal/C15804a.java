package com.didichuxing.mas.sdk.quality.collect.lag.internal;

import android.app.ActivityManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.lag.BlockCanaryInternals;
import java.io.File;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.internal.a */
/* compiled from: PerformanceUtils */
class C15804a {

    /* renamed from: a */
    private static final String f48150a = "PerformanceUtils";

    /* renamed from: b */
    private static int f48151b;

    /* renamed from: c */
    private static long f48152c;

    private C15804a() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* renamed from: a */
    public static int m34334a() {
        if (f48151b == 0) {
            try {
                f48151b = new File("/sys/devices/system/cpu/").listFiles(new PerformanceUtils$1CpuFilter()).length;
            } catch (Exception e) {
                SystemUtils.log(6, f48150a, "getNumCores exception", e, "com.didichuxing.mas.sdk.quality.collect.lag.internal.PerformanceUtils", 63);
                f48151b = 1;
            }
        }
        return f48151b;
    }

    /* renamed from: b */
    public static long m34335b() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) BlockCanaryInternals.getContext().provideContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e A[SYNTHETIC, Splitter:B:25:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[SYNTHETIC, Splitter:B:31:0x0074] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m34336c() {
        /*
            long r0 = f48152c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0086
            java.lang.String r0 = "/proc/meminfo"
            r1 = -1
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x004e }
            r4.<init>(r0)     // Catch:{ IOException -> 0x004e }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r3)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            java.lang.String r3 = r0.readLine()     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            if (r3 == 0) goto L_0x0030
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            long r1 = r3.longValue()     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
        L_0x0030:
            r0.close()     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x006f
        L_0x0037:
            r8 = move-exception
            r5 = 6
            r10 = 102(0x66, float:1.43E-43)
            java.lang.String r6 = "PerformanceUtils"
            java.lang.String r7 = "close localFileReader exception = "
            java.lang.String r9 = "com.didichuxing.mas.sdk.quality.collect.lag.internal.PerformanceUtils"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
            goto L_0x006f
        L_0x0045:
            r0 = move-exception
            r3 = r4
            goto L_0x0072
        L_0x0048:
            r0 = move-exception
            r7 = r0
            r3 = r4
            goto L_0x0050
        L_0x004c:
            r0 = move-exception
            goto L_0x0072
        L_0x004e:
            r0 = move-exception
            r7 = r0
        L_0x0050:
            java.lang.String r5 = "PerformanceUtils"
            java.lang.String r6 = "getTotalMemory exception = "
            r4 = 6
            java.lang.String r8 = "com.didichuxing.mas.sdk.quality.collect.lag.internal.PerformanceUtils"
            r9 = 96
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x006f
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x006f
        L_0x0062:
            r13 = move-exception
            r10 = 6
            r15 = 102(0x66, float:1.43E-43)
            java.lang.String r11 = "PerformanceUtils"
            java.lang.String r12 = "close localFileReader exception = "
            java.lang.String r14 = "com.didichuxing.mas.sdk.quality.collect.lag.internal.PerformanceUtils"
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
        L_0x006f:
            f48152c = r1
            goto L_0x0086
        L_0x0072:
            if (r3 == 0) goto L_0x0085
            r3.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0085
        L_0x0078:
            r7 = move-exception
            r4 = 6
            r9 = 102(0x66, float:1.43E-43)
            java.lang.String r5 = "PerformanceUtils"
            java.lang.String r6 = "close localFileReader exception = "
            java.lang.String r8 = "com.didichuxing.mas.sdk.quality.collect.lag.internal.PerformanceUtils"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0085:
            throw r0
        L_0x0086:
            long r0 = f48152c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.lag.internal.C15804a.m34336c():long");
    }
}
