package com.kwai.koom.javaoom.common;

import android.os.StatFs;
import android.text.TextUtils;
import com.kwai.koom.javaoom.common.KConstants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class KUtils {

    /* renamed from: a */
    static final /* synthetic */ boolean f55604a = (!KUtils.class.desiredAssertionStatus());

    /* renamed from: b */
    private static long f55605b;

    /* renamed from: c */
    private static String f55606c;

    public static class ProcessStatus {
        public long javaHeapByteSize;
        public long pssKbSize;
        public long rssKbSize;
        public int threadsCount;
        public long totalByteSize;
        public long vssKbSize;
    }

    public static void startup() {
        f55605b = System.currentTimeMillis();
    }

    public static int usageSeconds() {
        return (int) ((System.currentTimeMillis() - f55605b) / 1000);
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.CHINESE).format(new Date());
    }

    public static float getSpaceInGB(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            StatFs statFs = new StatFs(str);
            return ((((float) statFs.getBlockSizeLong()) * 1.0f) * ((float) ((long) statFs.getAvailableBlocks()))) / ((float) KConstants.Bytes.f55584GB);
        } catch (Exception e) {
            KLog.m40101e("Space", e.getMessage());
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static int computeGenerations(Class<?> cls) {
        int i = 1;
        Class<? super Object> cls2 = cls;
        while (cls2 != null && cls2.getSuperclass() != Object.class) {
            i++;
            cls2 = cls2.getSuperclass();
        }
        if (f55604a || cls2 != null) {
            return i;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProcessName() {
        /*
            java.lang.String r0 = f55606c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = f55606c
            return r0
        L_0x000b:
            int r0 = android.os.Process.myPid()     // Catch:{ Exception -> 0x003c }
            android.app.Application r1 = com.kwai.koom.javaoom.common.KGlobalConfig.getApplication()     // Catch:{ Exception -> 0x003c }
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x003c }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ Exception -> 0x003c }
            if (r1 == 0) goto L_0x0040
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ Exception -> 0x003c }
            if (r1 == 0) goto L_0x0040
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x003c }
        L_0x0027:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x003c }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x003c }
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch:{ Exception -> 0x003c }
            int r3 = r2.pid     // Catch:{ Exception -> 0x003c }
            if (r3 != r0) goto L_0x0027
            java.lang.String r0 = r2.processName     // Catch:{ Exception -> 0x003c }
            f55606c = r0     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0040:
            java.lang.String r0 = f55606c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0083
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007f }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x007f }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x007f }
            java.lang.String r3 = "/proc/self/cmdline"
            r2.<init>(r3)     // Catch:{ IOException -> 0x007f }
            r1.<init>(r2)     // Catch:{ IOException -> 0x007f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x007f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r1.<init>()     // Catch:{ all -> 0x0073 }
        L_0x005e:
            int r2 = r0.read()     // Catch:{ all -> 0x0073 }
            if (r2 <= 0) goto L_0x0069
            char r2 = (char) r2     // Catch:{ all -> 0x0073 }
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            goto L_0x005e
        L_0x0069:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0073 }
            f55606c = r1     // Catch:{ all -> 0x0073 }
            r0.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0083
        L_0x0073:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x007f }
        L_0x007e:
            throw r2     // Catch:{ IOException -> 0x007f }
        L_0x007f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0083:
            java.lang.String r0 = f55606c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.javaoom.common.KUtils.getProcessName():java.lang.String");
    }

    public static ProcessStatus getProcessMemoryUsage() {
        RandomAccessFile randomAccessFile;
        IOException e;
        ProcessStatus processStatus = new ProcessStatus();
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/self/status", "r");
            while (true) {
                try {
                    String readLine = randomAccessFile.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.startsWith("VmSize")) {
                            if (readLine.contains("kB")) {
                                String[] split = readLine.split("\\s+");
                                if (split.length > 1) {
                                    processStatus.vssKbSize = Long.parseLong(split[1]);
                                }
                            }
                        }
                        if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String[] split2 = readLine.split("\\s+");
                            if (split2.length > 1) {
                                processStatus.rssKbSize = Long.parseLong(split2[1]);
                            }
                        } else if (readLine.startsWith("Threads:")) {
                            String[] split3 = readLine.split("\\s+");
                            if (split3.length > 1) {
                                processStatus.threadsCount = Integer.parseInt(split3[1]);
                            }
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        closeQuietly(randomAccessFile);
                        return processStatus;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile2 = randomAccessFile;
                        closeQuietly(randomAccessFile2);
                        throw th;
                    }
                }
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            randomAccessFile = null;
            e = iOException;
            e.printStackTrace();
            closeQuietly(randomAccessFile);
            return processStatus;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(randomAccessFile2);
            throw th;
        }
        closeQuietly(randomAccessFile);
        return processStatus;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
