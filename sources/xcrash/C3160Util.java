package xcrash;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.web.config.WebConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

/* renamed from: xcrash.Util */
public class C3160Util {

    /* renamed from: a */
    static final String f7050a = "massdk xcrash";

    /* renamed from: b */
    static final String f7051b = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";

    /* renamed from: c */
    static final String f7052c = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";

    /* renamed from: d */
    static final String f7053d = "+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++";

    /* renamed from: e */
    static final String f7054e = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    /* renamed from: f */
    static final String f7055f = "java";

    /* renamed from: g */
    static final String f7056g = "native";

    /* renamed from: h */
    static final String f7057h = "anr";

    /* renamed from: i */
    static final String f7058i = "tombstone";

    /* renamed from: j */
    static final String f7059j = ".java.xcrash";

    /* renamed from: k */
    static final String f7060k = ".native.xcrash";

    /* renamed from: l */
    static final String f7061l = ".anr.xcrash";

    /* renamed from: m */
    static final String f7062m = ".trace.xcrash";

    /* renamed from: n */
    private static final String f7063n = "%21s %8s\n";

    /* renamed from: o */
    private static final String f7064o = "%21s %8s %21s %8s\n";

    /* renamed from: p */
    private static final String[] f7065p = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};

    private C3160Util() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        if (r0 != null) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073 A[SYNTHETIC, Splitter:B:34:0x0073] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m4192a(android.content.Context r4, int r5) {
        /*
            java.lang.String r0 = "activity"
            java.lang.Object r4 = r4.getSystemService(r0)     // Catch:{ Exception -> 0x002f }
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch:{ Exception -> 0x002f }
            if (r4 == 0) goto L_0x002f
            java.util.List r4 = r4.getRunningAppProcesses()     // Catch:{ Exception -> 0x002f }
            if (r4 == 0) goto L_0x002f
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x002f }
        L_0x0014:
            boolean r0 = r4.hasNext()     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r4.next()     // Catch:{ Exception -> 0x002f }
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch:{ Exception -> 0x002f }
            int r1 = r0.pid     // Catch:{ Exception -> 0x002f }
            if (r1 != r5) goto L_0x0014
            java.lang.String r1 = r0.processName     // Catch:{ Exception -> 0x002f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x002f }
            if (r1 != 0) goto L_0x0014
            java.lang.String r4 = r0.processName     // Catch:{ Exception -> 0x002f }
            return r4
        L_0x002f:
            r4 = 0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r2.<init>()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r2.append(r5)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r5 = "/cmdline"
            r2.append(r5)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0077, all -> 0x006e }
            java.lang.String r5 = r0.readLine()     // Catch:{ Exception -> 0x0078, all -> 0x006c }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0078, all -> 0x006c }
            if (r1 != 0) goto L_0x0068
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x0078, all -> 0x006c }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0078, all -> 0x006c }
            if (r1 != 0) goto L_0x0068
            r0.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            return r5
        L_0x0068:
            r0.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007b
        L_0x006c:
            r4 = move-exception
            goto L_0x0071
        L_0x006e:
            r5 = move-exception
            r0 = r4
            r4 = r5
        L_0x0071:
            if (r0 == 0) goto L_0x0076
            r0.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            throw r4
        L_0x0077:
            r0 = r4
        L_0x0078:
            if (r0 == 0) goto L_0x007b
            goto L_0x0068
        L_0x007b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.C3160Util.m4192a(android.content.Context, int):java.lang.String");
    }

    /* renamed from: a */
    static boolean m4197a() {
        try {
            for (String file : f7065p) {
                if (new File(file).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: b */
    static String m4200b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return TextUtils.join(",", Build.SUPPORTED_ABIS);
        }
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "," + str2;
    }

    /* renamed from: a */
    static String m4193a(File file) {
        if (!file.exists()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return String.format("%032x", new Object[]{new BigInteger(1, instance.digest())});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    static String m4191a(Context context) {
        String str;
        try {
            str = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    public static String getProcessMemoryInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Process Summary (From: android.os.Debug.MemoryInfo)\n");
        sb.append(String.format(Locale.US, f7063n, new Object[]{"", "Pss(KB)"}));
        sb.append(String.format(Locale.US, f7063n, new Object[]{"", "------"}));
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 23) {
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Java Heap:", memoryInfo.getMemoryStat("summary.java-heap")}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Native Heap:", memoryInfo.getMemoryStat("summary.native-heap")}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Code:", memoryInfo.getMemoryStat("summary.code")}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Stack:", memoryInfo.getMemoryStat("summary.stack")}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Graphics:", memoryInfo.getMemoryStat("summary.graphics")}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Private Other:", memoryInfo.getMemoryStat("summary.private-other")}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"System:", memoryInfo.getMemoryStat("summary.system")}));
                sb.append(String.format(Locale.US, f7064o, new Object[]{"TOTAL:", memoryInfo.getMemoryStat("summary.total-pss"), "TOTAL SWAP:", memoryInfo.getMemoryStat("summary.total-swap")}));
            } else {
                Locale locale = Locale.US;
                sb.append(String.format(locale, f7063n, new Object[]{"Java Heap:", "~ " + memoryInfo.dalvikPrivateDirty}));
                sb.append(String.format(Locale.US, f7063n, new Object[]{"Native Heap:", String.valueOf(memoryInfo.nativePrivateDirty)}));
                Locale locale2 = Locale.US;
                sb.append(String.format(locale2, f7063n, new Object[]{"Private Other:", "~ " + memoryInfo.otherPrivateDirty}));
                if (Build.VERSION.SDK_INT >= 19) {
                    sb.append(String.format(Locale.US, f7063n, new Object[]{"System:", String.valueOf((memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateDirty()) - memoryInfo.getTotalPrivateClean())}));
                } else {
                    Locale locale3 = Locale.US;
                    sb.append(String.format(locale3, f7063n, new Object[]{"System:", "~ " + (memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateDirty())}));
                }
                sb.append(String.format(Locale.US, f7063n, new Object[]{"TOTAL:", String.valueOf(memoryInfo.getTotalPss())}));
            }
        } catch (Exception e) {
            XCrash.getLogger().mo38732i(f7050a, "Util getProcessMemoryInfo failed", e);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m4201b(String str) {
        return m4194a(str, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079 A[SYNTHETIC, Splitter:B:27:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083 A[SYNTHETIC, Splitter:B:33:0x0083] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4194a(java.lang.String r6, int r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0057 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0057 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0057 }
            r1 = 0
        L_0x0011:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            if (r3 == 0) goto L_0x0035
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            int r4 = r3.length()     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            if (r4 <= 0) goto L_0x0011
            int r1 = r1 + 1
            if (r7 == 0) goto L_0x0027
            if (r1 > r7) goto L_0x0011
        L_0x0027:
            java.lang.String r4 = "  "
            r0.append(r4)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r0.append(r3)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            goto L_0x0011
        L_0x0035:
            if (r7 <= 0) goto L_0x004b
            if (r1 <= r7) goto L_0x004b
            java.lang.String r7 = "  ......\n"
            r0.append(r7)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            java.lang.String r7 = "  (number of records: "
            r0.append(r7)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r0.append(r1)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            java.lang.String r7 = ")\n"
            r0.append(r7)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
        L_0x004b:
            r2.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x007c
        L_0x004f:
            r6 = move-exception
            r1 = r2
            goto L_0x0081
        L_0x0052:
            r7 = move-exception
            r1 = r2
            goto L_0x0058
        L_0x0055:
            r6 = move-exception
            goto L_0x0081
        L_0x0057:
            r7 = move-exception
        L_0x0058:
            xcrash.ILogger r2 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = "massdk xcrash"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r4.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = "Util getInfo("
            r4.append(r5)     // Catch:{ all -> 0x0055 }
            r4.append(r6)     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = ") failed"
            r4.append(r6)     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0055 }
            r2.mo38732i(r3, r6, r7)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ Exception -> 0x007c }
        L_0x007c:
            java.lang.String r6 = r0.toString()
            return r6
        L_0x0081:
            if (r1 == 0) goto L_0x0086
            r1.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.C3160Util.m4194a(java.lang.String, int):java.lang.String");
    }

    /* renamed from: a */
    static boolean m4199a(String str) {
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.isDirectory();
            }
            file.mkdirs();
            if (!file.exists() || !file.isDirectory()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    static boolean m4198a(Context context, long j) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        int myPid = Process.myPid();
        long j2 = j / 500;
        for (int i = 0; ((long) i) < j2; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo next : processesInErrorState) {
                    if (next.pid == myPid && next.condition == 2) {
                        return true;
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    static String m4195a(Date date, Date date2, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        StringBuilder sb = new StringBuilder();
        sb.append("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\nTombstone maker: 'xCrash 3.0.0'\nCrash type: '");
        sb.append(str);
        sb.append("'\nStart time: '");
        sb.append(simpleDateFormat.format(date));
        sb.append("'\nCrash time: '");
        sb.append(simpleDateFormat.format(date2));
        sb.append("'\nApp ID: '");
        sb.append(str2);
        sb.append("'\nApp version: '");
        sb.append(str3);
        sb.append("'\nRooted: '");
        sb.append(m4197a() ? "Yes" : "No");
        sb.append("'\nAPI level: '");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("'\nOS version: '");
        sb.append(Build.VERSION.RELEASE);
        sb.append("'\nABI list: '");
        sb.append(m4200b());
        sb.append("'\nManufacturer: '");
        sb.append(Build.MANUFACTURER);
        sb.append("'\nBrand: '");
        sb.append(Build.BRAND);
        sb.append("'\nModel: '");
        sb.append(getMobileModel());
        sb.append("'\nBuild fingerprint: '");
        sb.append(Build.FINGERPRINT);
        sb.append("'\n");
        return sb.toString();
    }

    public static String getMemoryInfo() {
        return "memory info:\n" + getSystemSummary() + getProcessStatus() + getProcessLimits() + getProcessMemoryInfo() + "\n";
    }

    public static String getSystemSummary() {
        return " System Summary (From: /proc/meminfo)\n" + m4201b("/proc/meminfo") + "-\n";
    }

    public static String getProcessStatus() {
        return " Process Status (From: /proc/PID/status)\n" + m4201b("/proc/self/status") + "-\n";
    }

    public static String getProcessLimits() {
        return " Process Limits (From: /proc/PID/limits)\n" + m4201b("/proc/self/limits") + "-\n";
    }

    /* renamed from: c */
    static String m4202c() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "network info:\nNot supported on Android Q (API level 29) and later.\n\n";
        }
        return "network info:\n TCP over IPv4 (From: /proc/PID/net/tcp)\n" + m4194a("/proc/self/net/tcp", 1024) + "-\n TCP over IPv6 (From: /proc/PID/net/tcp6)\n" + m4194a("/proc/self/net/tcp6", 1024) + "-\n UDP over IPv4 (From: /proc/PID/net/udp)\n" + m4194a("/proc/self/net/udp", 1024) + "-\n UDP over IPv6 (From: /proc/PID/net/udp6)\n" + m4194a("/proc/self/net/udp6", 1024) + "-\n ICMP in IPv4 (From: /proc/PID/net/icmp)\n" + m4194a("/proc/self/net/icmp", 256) + "-\n ICMP in IPv6 (From: /proc/PID/net/icmp6)\n" + m4194a("/proc/self/net/icmp6", 256) + "-\n UNIX domain (From: /proc/PID/net/unix)\n" + m4194a("/proc/self/net/unix", 256) + "\n";
    }

    public static String getFds() {
        StringBuilder sb = new StringBuilder("open files:\n");
        try {
            File[] listFiles = new File("/proc/self/fd").listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return TextUtils.isDigitsOnly(str);
                }
            });
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File file = listFiles[i];
                    String str = null;
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            str = Os.readlink(file.getAbsolutePath());
                        } else {
                            str = file.getCanonicalPath();
                        }
                    } catch (Exception unused) {
                    }
                    sb.append("    fd ");
                    sb.append(file.getName());
                    sb.append(": ");
                    sb.append(TextUtils.isEmpty(str) ? "???" : str.trim());
                    sb.append(10);
                    i2++;
                    if (i2 > 1024) {
                        break;
                    }
                    i++;
                }
                if (listFiles.length > 1024) {
                    sb.append("    ......\n");
                }
                sb.append("    (number of FDs: ");
                sb.append(listFiles.length);
                sb.append(")\n");
            }
        } catch (Exception unused2) {
        }
        sb.append(10);
        return sb.toString();
    }

    /* renamed from: a */
    static String m4190a(int i, int i2, int i3) {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("logcat:\n");
        if (i > 0) {
            m4196a(myPid, sb, NachoConstants.NACHO_ENTRYPOINT_NAME, i, 'D');
        }
        if (i2 > 0) {
            m4196a(myPid, sb, WebConstant.SYSTEM_ENTRANCE_PLATFORM, i2, 'W');
        }
        if (i3 > 0) {
            m4196a(myPid, sb, "events", i2, 'I');
        }
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ea A[SYNTHETIC, Splitter:B:33:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4196a(int r9, java.lang.StringBuilder r10, java.lang.String r11, int r12, char r13) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 24
            if (r0 < r2) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.lang.String r9 = java.lang.Integer.toString(r9)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " "
            r2.append(r3)
            r2.append(r9)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r5 = "/system/bin/logcat"
            r4.add(r5)
            java.lang.String r5 = "-b"
            r4.add(r5)
            r4.add(r11)
            java.lang.String r5 = "-d"
            r4.add(r5)
            java.lang.String r5 = "-v"
            r4.add(r5)
            java.lang.String r5 = "threadtime"
            r4.add(r5)
            java.lang.String r5 = "-t"
            r4.add(r5)
            if (r0 == 0) goto L_0x004b
            goto L_0x0054
        L_0x004b:
            double r5 = (double) r12
            r7 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r5 = r5 * r7
            int r12 = (int) r5
        L_0x0054:
            java.lang.String r12 = java.lang.Integer.toString(r12)
            r4.add(r12)
            if (r0 == 0) goto L_0x0065
            java.lang.String r12 = "--pid"
            r4.add(r12)
            r4.add(r9)
        L_0x0065:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = "*:"
            r9.append(r12)
            r9.append(r13)
            java.lang.String r9 = r9.toString()
            r4.add(r9)
            java.lang.Object[] r9 = r4.toArray()
            java.lang.String r12 = "--------- tail end of log "
            r10.append(r12)
            r10.append(r11)
            java.lang.String r11 = " ("
            r10.append(r11)
            java.lang.String r9 = android.text.TextUtils.join(r3, r9)
            r10.append(r9)
            java.lang.String r9 = ")\n"
            r10.append(r9)
            r9 = 0
            java.lang.ProcessBuilder r11 = new java.lang.ProcessBuilder     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.lang.String[] r12 = new java.lang.String[r1]     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.lang.ProcessBuilder r11 = r11.command(r4)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.lang.Process r11 = r11.start()     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r13.<init>(r11)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x00d5, all -> 0x00d1 }
        L_0x00b4:
            java.lang.String r9 = r12.readLine()     // Catch:{ Exception -> 0x00cf }
            if (r9 == 0) goto L_0x00cb
            if (r0 != 0) goto L_0x00c2
            boolean r11 = r9.contains(r2)     // Catch:{ Exception -> 0x00cf }
            if (r11 == 0) goto L_0x00b4
        L_0x00c2:
            r10.append(r9)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r9 = "\n"
            r10.append(r9)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00b4
        L_0x00cb:
            r12.close()     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00e6
        L_0x00cf:
            r9 = move-exception
            goto L_0x00d8
        L_0x00d1:
            r10 = move-exception
            r12 = r9
            r9 = r10
            goto L_0x00e8
        L_0x00d5:
            r10 = move-exception
            r12 = r9
            r9 = r10
        L_0x00d8:
            xcrash.ILogger r10 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x00e7 }
            java.lang.String r11 = "massdk xcrash"
            java.lang.String r13 = "Util run logcat command failed"
            r10.mo38736w(r11, r13, r9)     // Catch:{ all -> 0x00e7 }
            if (r12 == 0) goto L_0x00e6
            goto L_0x00cb
        L_0x00e6:
            return
        L_0x00e7:
            r9 = move-exception
        L_0x00e8:
            if (r12 == 0) goto L_0x00ed
            r12.close()     // Catch:{ IOException -> 0x00ed }
        L_0x00ed:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.C3160Util.m4196a(int, java.lang.StringBuilder, java.lang.String, int, char):void");
    }

    public static String getCensusDalvikVmMemoryInfo() {
        try {
            return " System Properties (From: /system/build.prop)\n  dalvik.vm.heapstartsize:  " + String.format("%8s", new Object[]{getSystemProperty("dalvik.vm.heapstartsize", "")}) + "\n  dalvik.vm.heapgrowthlimit:" + String.format("%8s", new Object[]{getSystemProperty("dalvik.vm.heapgrowthlimit", "")}) + "\n  dalvik.vm.heapsize:       " + String.format("%8s", new Object[]{getSystemProperty("dalvik.vm.heapsize", "")}) + "\n-\n";
        } catch (Exception e) {
            XCrash.getLogger().mo38732i(f7050a, "Util getCensusDalvikVmMemoryInfo failed", e);
            return "";
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return str2;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return str2;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return str2;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return str2;
        }
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMobileModel() {
        /*
            boolean r0 = isMIUI()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.String r2 = "get"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r7 = 1
            r4[r7] = r5     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.reflect.Method r2 = r0.getDeclaredMethod(r2, r4)     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.String r5 = "ro.product.marketname"
            r4[r6] = r5     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            r4[r7] = r1     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.Object r4 = r2.invoke(r0, r4)     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ InvocationTargetException -> 0x005f, NoSuchMethodException -> 0x0059, IllegalAccessException -> 0x0053, ClassNotFoundException -> 0x004d }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ InvocationTargetException -> 0x004b, NoSuchMethodException -> 0x0049, IllegalAccessException -> 0x0047, ClassNotFoundException -> 0x0045 }
            if (r5 == 0) goto L_0x0067
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x004b, NoSuchMethodException -> 0x0049, IllegalAccessException -> 0x0047, ClassNotFoundException -> 0x0045 }
            java.lang.String r5 = "ro.product.model"
            r3[r6] = r5     // Catch:{ InvocationTargetException -> 0x004b, NoSuchMethodException -> 0x0049, IllegalAccessException -> 0x0047, ClassNotFoundException -> 0x0045 }
            r3[r7] = r1     // Catch:{ InvocationTargetException -> 0x004b, NoSuchMethodException -> 0x0049, IllegalAccessException -> 0x0047, ClassNotFoundException -> 0x0045 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ InvocationTargetException -> 0x004b, NoSuchMethodException -> 0x0049, IllegalAccessException -> 0x0047, ClassNotFoundException -> 0x0045 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ InvocationTargetException -> 0x004b, NoSuchMethodException -> 0x0049, IllegalAccessException -> 0x0047, ClassNotFoundException -> 0x0045 }
            r4 = r0
            goto L_0x0067
        L_0x0045:
            r0 = move-exception
            goto L_0x004f
        L_0x0047:
            r0 = move-exception
            goto L_0x0055
        L_0x0049:
            r0 = move-exception
            goto L_0x005b
        L_0x004b:
            r0 = move-exception
            goto L_0x0061
        L_0x004d:
            r0 = move-exception
            r4 = r1
        L_0x004f:
            r0.printStackTrace()
            goto L_0x0067
        L_0x0053:
            r0 = move-exception
            r4 = r1
        L_0x0055:
            r0.printStackTrace()
            goto L_0x0067
        L_0x0059:
            r0 = move-exception
            r4 = r1
        L_0x005b:
            r0.printStackTrace()
            goto L_0x0067
        L_0x005f:
            r0 = move-exception
            r4 = r1
        L_0x0061:
            r0.printStackTrace()
            goto L_0x0067
        L_0x0065:
            java.lang.String r4 = android.os.Build.MODEL
        L_0x0067:
            if (r4 != 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r1 = r4
        L_0x006b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.C3160Util.getMobileModel():java.lang.String");
    }
}
