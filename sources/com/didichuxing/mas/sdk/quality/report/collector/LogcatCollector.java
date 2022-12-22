package com.didichuxing.mas.sdk.quality.report.collector;

import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didi.soda.web.config.WebConstant;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.utils.Consumer;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogcatCollector {
    public static String geEventLogcat() {
        return dumpLogcat(MASConfig.LOGCAT_TAIL_COUNT, (Consumer<String>) null, "events");
    }

    public static String getLogcat() {
        return dumpLogcat(MASConfig.LOGCAT_TAIL_COUNT, (Consumer<String>) null, NachoConstants.NACHO_ENTRYPOINT_NAME, WebConstant.SYSTEM_ENTRANCE_PLATFORM, "events", "crash");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[SYNTHETIC, Splitter:B:28:0x008d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLogcat(int r6, java.lang.String[] r7) {
        /*
            int r0 = android.os.Process.myPid()
            boolean r1 = com.didichuxing.mas.sdk.quality.report.MASConfig.LOGCAT_ONLY_MY_APP
            r2 = 0
            if (r1 == 0) goto L_0x0021
            if (r0 <= 0) goto L_0x0021
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r1.append(r0)
            java.lang.String r0 = "):"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r3 = "logcat"
            r1.add(r3)
            java.util.List r7 = java.util.Arrays.asList(r7)
            r1.addAll(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0086 }
            int r4 = r1.size()     // Catch:{ all -> 0x0086 }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0086 }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ all -> 0x0086 }
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x0086 }
            java.lang.Process r1 = r3.exec(r1)     // Catch:{ all -> 0x0086 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0086 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0086 }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ all -> 0x0086 }
            r4.<init>(r5)     // Catch:{ all -> 0x0086 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0086 }
            com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$1 r2 = new com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$1     // Catch:{ all -> 0x0085 }
            r2.<init>(r1)     // Catch:{ all -> 0x0085 }
            r2.start()     // Catch:{ all -> 0x0085 }
            r1 = 0
        L_0x0065:
            if (r1 >= r6) goto L_0x0081
            java.lang.String r2 = r3.readLine()     // Catch:{ all -> 0x0085 }
            if (r2 != 0) goto L_0x006e
            goto L_0x0081
        L_0x006e:
            if (r0 == 0) goto L_0x0076
            boolean r4 = r2.contains(r0)     // Catch:{ all -> 0x0085 }
            if (r4 == 0) goto L_0x007e
        L_0x0076:
            r7.append(r2)     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = "\n"
            r7.append(r2)     // Catch:{ all -> 0x0085 }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x0065
        L_0x0081:
            r3.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0095
        L_0x0085:
            r2 = r3
        L_0x0086:
            java.lang.String r6 = "LogcatCollector.getLogcat failed!"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r6)     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x0095
            r2.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0095:
            java.lang.String r6 = r7.toString()
            return r6
        L_0x009a:
            r6 = move-exception
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00a5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector.getLogcat(int, java.lang.String[]):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0110, code lost:
        if (r9 != null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0112, code lost:
        r9.destroy();
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0146 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String dumpLogcat(int r19, com.didichuxing.mas.sdk.quality.report.utils.Consumer<java.lang.String> r20, java.lang.String... r21) {
        /*
            r1 = r20
            r2 = r21
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = 1
        L_0x000d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r8 = "logcat"
            r0.add(r8)
            boolean r8 = com.didichuxing.mas.sdk.quality.report.MASConfig.LIMIT_CURRENT_PID_LOGCAT_UPLOAD
            if (r8 == 0) goto L_0x0033
            int r8 = android.os.Process.myPid()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "--pid="
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r0.add(r8)
        L_0x0033:
            java.lang.String r8 = "-d"
            r0.add(r8)
            java.lang.String r8 = "-v"
            r0.add(r8)
            java.lang.String r8 = "threadtime"
            r0.add(r8)
            java.lang.String r8 = "-t"
            r0.add(r8)
            java.lang.String r8 = java.lang.String.valueOf(r19)
            r0.add(r8)
            if (r6 != 0) goto L_0x0070
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r8 < r9) goto L_0x0067
            int r8 = r2.length
            r10 = 0
        L_0x0058:
            if (r10 >= r8) goto L_0x0067
            r11 = r2[r10]
            java.lang.String r12 = "-b"
            r0.add(r12)
            r0.add(r11)
            int r10 = r10 + 1
            goto L_0x0058
        L_0x0067:
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r9) goto L_0x0070
            java.lang.String r8 = "-D"
            r0.add(r8)
        L_0x0070:
            java.lang.String r8 = " "
            java.lang.String r11 = android.text.TextUtils.join(r8, r0)
            r9 = 3
            r12 = 0
            r14 = 153(0x99, float:2.14E-43)
            java.lang.String r10 = "logcat"
            java.lang.String r13 = "com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
            r8 = 0
            java.lang.Runtime r9 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.Object[] r0 = r0.toArray(r10)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.Process r9 = r9.exec(r0)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            java.io.InputStream r10 = r9.getInputStream()     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            java.io.InputStreamReader r10 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            java.io.InputStream r11 = r9.getErrorStream()     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            r11.<init>(r0)     // Catch:{ Exception -> 0x012b, all -> 0x0126 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            r0.<init>()     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
        L_0x00ae:
            java.lang.String r12 = r11.readLine()     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            java.lang.String r13 = "\n"
            if (r12 == 0) goto L_0x00c2
            r0.append(r12)     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            r0.append(r13)     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            if (r1 == 0) goto L_0x00ae
            r1.accept(r12)     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            goto L_0x00ae
        L_0x00c2:
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            if (r12 != 0) goto L_0x00d2
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            r3.append(r0)     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            if (r9 == 0) goto L_0x0115
            goto L_0x0112
        L_0x00d2:
            if (r7 == 0) goto L_0x0110
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0123, all -> 0x0120 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r0.<init>()     // Catch:{ Exception -> 0x010e, all -> 0x010c }
        L_0x00de:
            java.lang.String r8 = r12.readLine()     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            if (r8 == 0) goto L_0x00eb
            r0.append(r8)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r0.append(r13)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            goto L_0x00de
        L_0x00eb:
            r12.close()     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            if (r8 != 0) goto L_0x0106
            java.lang.String r14 = "Logcat"
            java.lang.String r15 = r0.toString()     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r13 = 3
            r16 = 0
            java.lang.String r17 = "com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector"
            r18 = 183(0xb7, float:2.56E-43)
            com.didi.sdk.apm.SystemUtils.log(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r6 = 1
            r7 = 0
        L_0x0106:
            if (r9 == 0) goto L_0x0146
            r9.destroy()
            goto L_0x0146
        L_0x010c:
            r0 = move-exception
            goto L_0x0129
        L_0x010e:
            r0 = move-exception
            goto L_0x012e
        L_0x0110:
            if (r9 == 0) goto L_0x0115
        L_0x0112:
            r9.destroy()
        L_0x0115:
            closeQuietly(r11)
            closeQuietly(r8)
            java.lang.String r0 = r3.toString()
            return r0
        L_0x0120:
            r0 = move-exception
            r12 = r8
            goto L_0x0129
        L_0x0123:
            r0 = move-exception
            r12 = r8
            goto L_0x012e
        L_0x0126:
            r0 = move-exception
            r11 = r8
            r12 = r11
        L_0x0129:
            r8 = r9
            goto L_0x014f
        L_0x012b:
            r0 = move-exception
            r11 = r8
            r12 = r11
        L_0x012e:
            r8 = r9
            goto L_0x0137
        L_0x0130:
            r0 = move-exception
            r11 = r8
            r12 = r11
            goto L_0x014f
        L_0x0134:
            r0 = move-exception
            r11 = r8
            r12 = r11
        L_0x0137:
            r0.printStackTrace()     // Catch:{ all -> 0x014e }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x014e }
            r3.append(r0)     // Catch:{ all -> 0x014e }
            if (r8 == 0) goto L_0x0146
            r8.destroy()
        L_0x0146:
            closeQuietly(r11)
            closeQuietly(r12)
            goto L_0x000d
        L_0x014e:
            r0 = move-exception
        L_0x014f:
            if (r8 == 0) goto L_0x0154
            r8.destroy()
        L_0x0154:
            closeQuietly(r11)
            closeQuietly(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector.dumpLogcat(int, com.didichuxing.mas.sdk.quality.report.utils.Consumer, java.lang.String[]):java.lang.String");
    }

    public static LogcatBuffer getLogcat(int i, final String str) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new LogcatBuffer(dumpLogcat(i, new Consumer<String>() {
            public void accept(String str) {
                String str2;
                if (!atomicBoolean.get() && (str2 = str) != null) {
                    atomicBoolean.set(str.contains(str2));
                }
            }
        }, NachoConstants.NACHO_ENTRYPOINT_NAME, WebConstant.SYSTEM_ENTRANCE_PLATFORM, "events", "crash"), atomicBoolean.get());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r4.close();
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a8, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
        r8.printStackTrace();
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009f, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5 A[SYNTHETIC, Splitter:B:37:0x00b5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector.LogcatBuffer getLogcat_old(int r8, java.lang.String r9) {
        /*
            int r0 = android.os.Process.myPid()
            boolean r1 = com.didichuxing.mas.sdk.quality.report.MASConfig.LOGCAT_ONLY_MY_APP
            r2 = 0
            if (r1 == 0) goto L_0x0021
            if (r0 <= 0) goto L_0x0021
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r1.append(r0)
            java.lang.String r0 = "):"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r3 = "logcat"
            r1.add(r3)
            r3 = 4
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = "-t"
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = java.lang.String.valueOf(r8)
            r6 = 1
            r3[r6] = r4
            r4 = 2
            java.lang.String r6 = "-v"
            r3[r4] = r6
            r4 = 3
            java.lang.String r6 = "threadtime"
            r3[r4] = r6
            java.util.List r3 = java.util.Arrays.asList(r3)
            r1.addAll(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00ae }
            int r6 = r1.size()     // Catch:{ all -> 0x00ae }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x00ae }
            java.lang.Object[] r1 = r1.toArray(r6)     // Catch:{ all -> 0x00ae }
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x00ae }
            java.lang.Process r1 = r4.exec(r1)     // Catch:{ all -> 0x00ae }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x00ae }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ae }
            java.io.InputStream r7 = r1.getInputStream()     // Catch:{ all -> 0x00ae }
            r6.<init>(r7)     // Catch:{ all -> 0x00ae }
            r7 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r6, r7)     // Catch:{ all -> 0x00ae }
            com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$3 r2 = new com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$3     // Catch:{ all -> 0x00ad }
            r2.<init>(r1)     // Catch:{ all -> 0x00ad }
            r2.start()     // Catch:{ all -> 0x00ad }
            r1 = 0
        L_0x007e:
            if (r5 >= r8) goto L_0x00a4
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x00a2 }
            if (r2 != 0) goto L_0x0087
            goto L_0x00a4
        L_0x0087:
            if (r0 == 0) goto L_0x008f
            boolean r6 = r2.contains(r0)     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x009f
        L_0x008f:
            r3.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "\n"
            r3.append(r6)     // Catch:{ all -> 0x00a2 }
            if (r1 != 0) goto L_0x009f
            if (r9 == 0) goto L_0x009f
            boolean r1 = r2.contains(r9)     // Catch:{ all -> 0x00a2 }
        L_0x009f:
            int r5 = r5 + 1
            goto L_0x007e
        L_0x00a2:
            r5 = r1
            goto L_0x00ad
        L_0x00a4:
            r4.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00be
        L_0x00a8:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00be
        L_0x00ad:
            r2 = r4
        L_0x00ae:
            java.lang.String r8 = "LogcatCollector.getLogcat failed!"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r8)     // Catch:{ all -> 0x00c8 }
            if (r2 == 0) goto L_0x00bd
            r2.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00bd
        L_0x00b9:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00bd:
            r1 = r5
        L_0x00be:
            com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$LogcatBuffer r8 = new com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$LogcatBuffer
            java.lang.String r9 = r3.toString()
            r8.<init>(r9, r1)
            return r8
        L_0x00c8:
            r8 = move-exception
            if (r2 == 0) goto L_0x00d3
            r2.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00d3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector.getLogcat_old(int, java.lang.String):com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$LogcatBuffer");
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[SYNTHETIC, Splitter:B:19:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLogcatWithAnrReason(long r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "logcat"
            r0.add(r1)
            java.lang.String r1 = "-v"
            java.lang.String r2 = "threadtime"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.addAll(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x006c }
            int r4 = r0.size()     // Catch:{ all -> 0x006c }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x006c }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ all -> 0x006c }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x006c }
            java.lang.Process r0 = r3.exec(r0)     // Catch:{ all -> 0x006c }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x006c }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x006c }
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ all -> 0x006c }
            r4.<init>(r5)     // Catch:{ all -> 0x006c }
            r5 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r4, r5)     // Catch:{ all -> 0x006c }
            com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$4 r2 = new com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector$4     // Catch:{ all -> 0x006b }
            r2.<init>(r0)     // Catch:{ all -> 0x006b }
            r2.start()     // Catch:{ all -> 0x006b }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006b }
            long r4 = r4 + r6
        L_0x0050:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006b }
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0067
            java.lang.String r6 = r3.readLine()     // Catch:{ all -> 0x006b }
            if (r6 == 0) goto L_0x0067
            r1.append(r6)     // Catch:{ all -> 0x006b }
            java.lang.String r6 = "\n"
            r1.append(r6)     // Catch:{ all -> 0x006b }
            goto L_0x0050
        L_0x0067:
            r3.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x006b:
            r2 = r3
        L_0x006c:
            java.lang.String r6 = "LogcatCollector.getLogcat failed!"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r6)     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007b:
            int r6 = r1.length()
            r7 = 3145728(0x300000, float:4.408104E-39)
            if (r6 <= r7) goto L_0x008c
            r6 = 0
            int r0 = r1.length()
            int r0 = r0 - r7
            r1.delete(r6, r0)
        L_0x008c:
            java.lang.String r6 = r1.toString()
            return r6
        L_0x0091:
            r6 = move-exception
            if (r2 == 0) goto L_0x009c
            r2.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r7 = move-exception
            r7.printStackTrace()
        L_0x009c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector.getLogcatWithAnrReason(long):java.lang.String");
    }

    public static class LogcatBuffer {
        private String buffer;
        private boolean containErrMessage;

        public LogcatBuffer(String str, boolean z) {
            this.buffer = str;
            this.containErrMessage = z;
        }

        public String getBuffer() {
            return this.buffer;
        }

        public void setBuffer(String str) {
            this.buffer = str;
        }

        public boolean isContainErrMessage() {
            return this.containErrMessage;
        }

        public void setContainErrMessage(boolean z) {
            this.containErrMessage = z;
        }
    }
}
