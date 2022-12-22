package xcrash;

import android.os.Process;
import android.text.TextUtils;
import com.didi.soda.customer.app.constant.StringConst;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class JavaCrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final Date f7017a;

    /* renamed from: b */
    private int f7018b;

    /* renamed from: c */
    private String f7019c;

    /* renamed from: d */
    private String f7020d;

    /* renamed from: e */
    private String f7021e;

    /* renamed from: f */
    private boolean f7022f;

    /* renamed from: g */
    private String f7023g;

    /* renamed from: h */
    private int f7024h;

    /* renamed from: i */
    private int f7025i;

    /* renamed from: j */
    private int f7026j;

    /* renamed from: k */
    private boolean f7027k;

    /* renamed from: l */
    private boolean f7028l;

    /* renamed from: m */
    private boolean f7029m;

    /* renamed from: n */
    private int f7030n;

    /* renamed from: o */
    private String[] f7031o;

    /* renamed from: p */
    private ICrashCallback f7032p;

    /* renamed from: q */
    private Thread.UncaughtExceptionHandler f7033q;

    private JavaCrashHandler() {
        this.f7017a = new Date();
        this.f7033q = null;
    }

    private static class JavaCrashHandlerHolder {
        /* access modifiers changed from: private */
        public static JavaCrashHandler INSTANCE = new JavaCrashHandler();

        private JavaCrashHandlerHolder() {
        }
    }

    public static JavaCrashHandler getInstance() {
        return JavaCrashHandlerHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38737a(int i, String str, String str2, String str3, String str4, boolean z, int i2, int i3, int i4, boolean z2, boolean z3, boolean z4, int i5, String[] strArr, ICrashCallback iCrashCallback) {
        this.f7018b = i;
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        this.f7019c = str;
        this.f7020d = str2;
        this.f7021e = str3;
        this.f7022f = z;
        this.f7023g = str4;
        this.f7024h = i2;
        this.f7025i = i3;
        this.f7026j = i4;
        this.f7027k = z2;
        this.f7028l = z3;
        this.f7029m = z4;
        this.f7030n = i5;
        this.f7031o = strArr;
        this.f7032p = iCrashCallback;
        this.f7033q = Thread.getDefaultUncaughtExceptionHandler();
        try {
            Thread.setDefaultUncaughtExceptionHandler(this);
        } catch (Exception e) {
            XCrash.getLogger().mo38730e("massdk xcrash", "JavaCrashHandler setDefaultUncaughtExceptionHandler failed", e);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7033q;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        try {
            m4176a(thread, th);
        } catch (Exception e) {
            XCrash.getLogger().mo38730e("massdk xcrash", "JavaCrashHandler handleException failed", e);
        }
        if (this.f7022f) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f7033q;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
                return;
            }
            return;
        }
        C3163a.m4204a().mo38798b();
        Process.killProcess(this.f7018b);
        System.exit(10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.io.RandomAccessFile] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011f A[SYNTHETIC, Splitter:B:50:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129 A[SYNTHETIC, Splitter:B:56:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4176a(java.lang.Thread r12, java.lang.Throwable r13) {
        /*
            r11 = this;
            java.lang.String r0 = "massdk xcrash"
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            xcrash.NativeHandler r2 = xcrash.NativeHandler.getInstance()
            r2.notifyJavaCrashed()
            xcrash.AnrHandler r2 = xcrash.AnrHandler.getInstance()
            r2.notifyJavaCrashed()
            r2 = 0
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x0054 }
            java.lang.String r4 = "%s/%s_%020d_%s__%s%s"
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0054 }
            r6 = 0
            java.lang.String r7 = r11.f7023g     // Catch:{ Exception -> 0x0054 }
            r5[r6] = r7     // Catch:{ Exception -> 0x0054 }
            r6 = 1
            java.lang.String r7 = "tombstone"
            r5[r6] = r7     // Catch:{ Exception -> 0x0054 }
            r6 = 2
            java.util.Date r7 = r11.f7017a     // Catch:{ Exception -> 0x0054 }
            long r7 = r7.getTime()     // Catch:{ Exception -> 0x0054 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0054 }
            r5[r6] = r7     // Catch:{ Exception -> 0x0054 }
            r6 = 3
            java.lang.String r7 = r11.f7021e     // Catch:{ Exception -> 0x0054 }
            r5[r6] = r7     // Catch:{ Exception -> 0x0054 }
            r6 = 4
            java.lang.String r7 = r11.f7019c     // Catch:{ Exception -> 0x0054 }
            r5[r6] = r7     // Catch:{ Exception -> 0x0054 }
            r6 = 5
            java.lang.String r7 = ".java.xcrash"
            r5[r6] = r7     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = java.lang.String.format(r3, r4, r5)     // Catch:{ Exception -> 0x0054 }
            xcrash.c r4 = xcrash.C3165c.m4219a()     // Catch:{ Exception -> 0x0054 }
            java.io.File r3 = r4.mo38800a((java.lang.String) r3)     // Catch:{ Exception -> 0x0054 }
            goto L_0x005f
        L_0x0054:
            r3 = move-exception
            xcrash.ILogger r4 = xcrash.XCrash.getLogger()
            java.lang.String r5 = "JavaCrashHandler createLogFile failed"
            r4.mo38730e(r0, r5, r3)
            r3 = r2
        L_0x005f:
            java.lang.String r13 = r11.m4174a(r1, r12, r13)     // Catch:{ Exception -> 0x0064 }
            goto L_0x006f
        L_0x0064:
            r13 = move-exception
            xcrash.ILogger r1 = xcrash.XCrash.getLogger()
            java.lang.String r4 = "JavaCrashHandler getEmergency failed"
            r1.mo38730e(r0, r4, r13)
            r13 = r2
        L_0x006f:
            if (r3 == 0) goto L_0x012d
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = "rws"
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = "UTF-8"
            if (r13 == 0) goto L_0x0087
            byte[] r5 = r13.getBytes(r4)     // Catch:{ Exception -> 0x0084 }
            r1.write(r5)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0087
        L_0x0084:
            r12 = move-exception
            goto L_0x0114
        L_0x0087:
            int r13 = r11.f7026j     // Catch:{ Exception -> 0x010d }
            if (r13 > 0) goto L_0x0093
            int r13 = r11.f7024h     // Catch:{ Exception -> 0x010d }
            if (r13 > 0) goto L_0x0093
            int r13 = r11.f7025i     // Catch:{ Exception -> 0x010d }
            if (r13 <= 0) goto L_0x00a4
        L_0x0093:
            int r13 = r11.f7026j     // Catch:{ Exception -> 0x010d }
            int r5 = r11.f7024h     // Catch:{ Exception -> 0x010d }
            int r6 = r11.f7025i     // Catch:{ Exception -> 0x010d }
            java.lang.String r13 = xcrash.C3160Util.m4190a(r13, r5, r6)     // Catch:{ Exception -> 0x010d }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x010d }
            r1.write(r13)     // Catch:{ Exception -> 0x010d }
        L_0x00a4:
            boolean r13 = r11.f7027k     // Catch:{ Exception -> 0x010d }
            if (r13 == 0) goto L_0x00b3
            java.lang.String r13 = xcrash.C3160Util.getFds()     // Catch:{ Exception -> 0x010d }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x010d }
            r1.write(r13)     // Catch:{ Exception -> 0x010d }
        L_0x00b3:
            boolean r13 = r11.f7028l     // Catch:{ Exception -> 0x010d }
            if (r13 == 0) goto L_0x00c2
            java.lang.String r13 = xcrash.C3160Util.m4202c()     // Catch:{ Exception -> 0x010d }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x010d }
            r1.write(r13)     // Catch:{ Exception -> 0x010d }
        L_0x00c2:
            java.lang.String r13 = xcrash.C3160Util.getMemoryInfo()     // Catch:{ Exception -> 0x010d }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x010d }
            r1.write(r13)     // Catch:{ Exception -> 0x010d }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            r13.<init>()     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = "foreground:\n"
            r13.append(r5)     // Catch:{ Exception -> 0x010d }
            xcrash.a r5 = xcrash.C3163a.m4204a()     // Catch:{ Exception -> 0x010d }
            boolean r5 = r5.mo38799c()     // Catch:{ Exception -> 0x010d }
            if (r5 == 0) goto L_0x00e4
            java.lang.String r5 = "yes"
            goto L_0x00e6
        L_0x00e4:
            java.lang.String r5 = "no"
        L_0x00e6:
            r13.append(r5)     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = "\n\n"
            r13.append(r5)     // Catch:{ Exception -> 0x010d }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x010d }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x010d }
            r1.write(r13)     // Catch:{ Exception -> 0x010d }
            boolean r13 = r11.f7029m     // Catch:{ Exception -> 0x010d }
            if (r13 == 0) goto L_0x0108
            java.lang.String r12 = r11.m4173a((java.lang.Thread) r12)     // Catch:{ Exception -> 0x010d }
            byte[] r12 = r12.getBytes(r4)     // Catch:{ Exception -> 0x010d }
            r1.write(r12)     // Catch:{ Exception -> 0x010d }
        L_0x0108:
            r1.close()     // Catch:{ Exception -> 0x010b }
        L_0x010b:
            r13 = r2
            goto L_0x012d
        L_0x010d:
            r12 = move-exception
            r13 = r2
            goto L_0x0114
        L_0x0110:
            r12 = move-exception
            goto L_0x0127
        L_0x0112:
            r12 = move-exception
            r1 = r2
        L_0x0114:
            xcrash.ILogger r4 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = "JavaCrashHandler write log file failed"
            r4.mo38730e(r0, r5, r12)     // Catch:{ all -> 0x0125 }
            if (r1 == 0) goto L_0x012d
            r1.close()     // Catch:{ Exception -> 0x0123 }
            goto L_0x012d
        L_0x0123:
            goto L_0x012d
        L_0x0125:
            r12 = move-exception
            r2 = r1
        L_0x0127:
            if (r2 == 0) goto L_0x012c
            r2.close()     // Catch:{ Exception -> 0x012c }
        L_0x012c:
            throw r12
        L_0x012d:
            xcrash.ICrashCallback r12 = r11.f7032p
            if (r12 == 0) goto L_0x013b
            if (r3 != 0) goto L_0x0134
            goto L_0x0138
        L_0x0134:
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x013b }
        L_0x0138:
            r12.onCrash(r2, r13)     // Catch:{ Exception -> 0x013b }
        L_0x013b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.JavaCrashHandler.m4176a(java.lang.Thread, java.lang.Throwable):void");
    }

    /* renamed from: a */
    private String m4175a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            File file = new File(next);
            if (!file.exists() || !file.isFile()) {
                sb.append("    ");
                sb.append(next);
                sb.append(" (Not found)\n");
            } else {
                String a = C3160Util.m4193a(file);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
                Date date = new Date(file.lastModified());
                sb.append("    ");
                sb.append(next);
                sb.append("(BuildId: unknown. FileSize: ");
                sb.append(file.length());
                sb.append(". LastModified: ");
                sb.append(simpleDateFormat.format(date));
                sb.append(". MD5: ");
                sb.append(a);
                sb.append(")\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m4172a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!str.contains("UnsatisfiedLinkError")) {
            return "";
        }
        String str2 = null;
        for (String str3 : str.split(Const.jsQuote)) {
            if (!str3.isEmpty() && str3.endsWith(".so")) {
                arrayList.add(str3);
                String substring = str3.substring(str3.lastIndexOf(47) + 1);
                arrayList.add(XCrash.nativeLibDir + "/" + substring);
                StringBuilder sb = new StringBuilder();
                sb.append("/vendor/lib/");
                sb.append(substring);
                arrayList.add(sb.toString());
                arrayList.add("/vendor/lib64/" + substring);
                arrayList.add("/system/lib/" + substring);
                arrayList.add("/system/lib64/" + substring);
                str2 = m4175a((List<String>) arrayList);
            }
        }
        return "build id:\n" + str2 + "\n";
    }

    /* renamed from: a */
    private String m4174a(Date date, Thread thread, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        return C3160Util.m4195a(this.f7017a, date, StringConst.JAVA, this.f7020d, this.f7021e) + "pid: " + this.f7018b + ", tid: " + Process.myTid() + ", name: " + thread.getName() + "  >>> " + this.f7019c + " <<<\n\njava stacktrace:\n" + stringWriter2 + "\n" + m4172a(stringWriter2);
    }

    /* renamed from: a */
    private String m4173a(Thread thread) {
        ArrayList arrayList;
        if (this.f7031o != null) {
            arrayList = new ArrayList();
            for (String compile : this.f7031o) {
                try {
                    arrayList.add(Pattern.compile(compile));
                } catch (Exception e) {
                    XCrash.getLogger().mo38736w("massdk xcrash", "JavaCrashHandler pattern compile failed", e);
                }
            }
        } else {
            arrayList = null;
        }
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (Map.Entry next : allStackTraces.entrySet()) {
            Thread thread2 = (Thread) next.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
            if (!thread2.getName().equals(thread.getName()) && (arrayList == null || m4177a((ArrayList<Pattern>) arrayList, thread2.getName()))) {
                i2++;
                int i4 = this.f7030n;
                if (i4 <= 0 || i < i4) {
                    sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    sb.append("pid: ");
                    sb.append(this.f7018b);
                    sb.append(", tid: ");
                    sb.append(thread2.getId());
                    sb.append(", name: ");
                    sb.append(thread2.getName());
                    sb.append("  >>> ");
                    sb.append(this.f7019c);
                    sb.append(" <<<\n");
                    sb.append("\n");
                    sb.append("java stacktrace:\n");
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        sb.append("    at ");
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    sb.append("\n");
                    i++;
                } else {
                    i3++;
                }
            }
        }
        if (allStackTraces.size() > 1) {
            if (i == 0) {
                sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            }
            sb.append("total JVM threads (exclude the crashed thread): ");
            sb.append(allStackTraces.size() - 1);
            sb.append("\n");
            if (arrayList != null) {
                sb.append("JVM threads matched whitelist: ");
                sb.append(i2);
                sb.append("\n");
            }
            if (this.f7030n > 0) {
                sb.append("JVM threads ignored by max count limit: ");
                sb.append(i3);
                sb.append("\n");
            }
            sb.append("dumped JVM threads:");
            sb.append(i);
            sb.append("\n");
            sb.append("+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private boolean m4177a(ArrayList<Pattern> arrayList, String str) {
        Iterator<Pattern> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }
}
