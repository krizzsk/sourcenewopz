package com.didichuxing.omega.sdk.common.collector;

import android.os.Build;
import android.text.TextUtils;

public class CPUCollector {
    public static String getCpuArchitecture() {
        String[] strArr;
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 21 && (strArr = Build.SUPPORTED_ABIS) != null && strArr.length > 0) {
                str = Build.SUPPORTED_ABIS[0];
            }
            return TextUtils.isEmpty(str) ? Build.CPU_ABI : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|27|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r1 == null) goto L_0x0055;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC, Splitter:B:23:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMyAppCPUStat() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = android.os.Process.myPid()
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r4.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ all -> 0x0045 }
            r4.append(r1)     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "/stat"
            r4.append(r1)     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0045 }
            r3.<init>(r1)     // Catch:{ all -> 0x0045 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0042 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0042 }
        L_0x002c:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x003b
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x002c
        L_0x003b:
            r3.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0055
        L_0x0042:
            r1 = r2
        L_0x0043:
            r2 = r3
            goto L_0x0046
        L_0x0045:
            r1 = r2
        L_0x0046:
            java.lang.String r3 = "getMyAppCPUStat fail."
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r3)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0052
        L_0x0051:
        L_0x0052:
            if (r1 == 0) goto L_0x0055
            goto L_0x003e
        L_0x0055:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x005a:
            r0 = move-exception
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
        L_0x0062:
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.collector.CPUCollector.getMyAppCPUStat():java.lang.String");
    }
}
