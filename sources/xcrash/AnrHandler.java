package xcrash;

import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.text.TextUtils;
import java.util.Date;
import java.util.regex.Pattern;

public class AnrHandler {

    /* renamed from: a */
    private final Date f6997a;

    /* renamed from: b */
    private final Pattern f6998b;

    /* renamed from: c */
    private final Pattern f6999c;

    /* renamed from: d */
    private final long f7000d;

    /* renamed from: e */
    private Context f7001e;

    /* renamed from: f */
    private int f7002f;

    /* renamed from: g */
    private String f7003g;

    /* renamed from: h */
    private String f7004h;

    /* renamed from: i */
    private String f7005i;

    /* renamed from: j */
    private String f7006j;

    /* renamed from: k */
    private boolean f7007k;

    /* renamed from: l */
    private int f7008l;

    /* renamed from: m */
    private int f7009m;

    /* renamed from: n */
    private int f7010n;

    /* renamed from: o */
    private boolean f7011o;

    /* renamed from: p */
    private boolean f7012p;

    /* renamed from: q */
    private ICrashCallback f7013q;

    /* renamed from: r */
    private long f7014r;

    /* renamed from: s */
    private FileObserver f7015s;

    private AnrHandler() {
        this.f6997a = new Date();
        this.f6998b = Pattern.compile("^-----\\spid\\s(\\d+)\\sat\\s(.*)\\s-----$");
        this.f6999c = Pattern.compile("^Cmd\\sline:\\s+(.*)$");
        this.f7000d = 15000;
        this.f7014r = 0;
        this.f7015s = null;
    }

    private static class AnrHandlerHolder {
        /* access modifiers changed from: private */
        public static AnrHandler INSTANCE = new AnrHandler();

        private AnrHandlerHolder() {
        }
    }

    public static AnrHandler getInstance() {
        return AnrHandlerHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38711a(Context context, int i, String str, String str2, String str3, String str4, boolean z, int i2, int i3, int i4, boolean z2, boolean z3, ICrashCallback iCrashCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            this.f7001e = context;
            this.f7002f = i;
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            this.f7003g = str;
            this.f7004h = str2;
            this.f7005i = str3;
            this.f7006j = str4;
            this.f7007k = z;
            this.f7008l = i2;
            this.f7009m = i3;
            this.f7010n = i4;
            this.f7011o = z2;
            this.f7012p = z3;
            this.f7013q = iCrashCallback;
            C31511 r3 = new FileObserver("/data/anr/", 8) {
                public void onEvent(int i, String str) {
                    if (str != null) {
                        try {
                            String str2 = "/data/anr/" + str;
                            if (str2.contains("trace")) {
                                AnrHandler.this.m4159a(str2);
                            }
                        } catch (Exception e) {
                            XCrash.getLogger().mo38730e("massdk xcrash", "AnrHandler fileObserver onEvent failed", e);
                        }
                    }
                }
            };
            this.f7015s = r3;
            try {
                r3.startWatching();
            } catch (Exception e) {
                this.f7015s = null;
                XCrash.getLogger().mo38730e("massdk xcrash", "AnrHandler fileObserver startWatching failed", e);
            }
        }
    }

    public void notifyJavaCrashed() {
        FileObserver fileObserver = this.f7015s;
        if (fileObserver != null) {
            try {
                fileObserver.stopWatching();
            } catch (Exception e) {
                XCrash.getLogger().mo38730e("massdk xcrash", "AnrHandler fileObserver stopWatching failed", e);
            } catch (Throwable th) {
                this.f7015s = null;
                throw th;
            }
            this.f7015s = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.io.RandomAccessFile] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011d A[SYNTHETIC, Splitter:B:59:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0144 A[SYNTHETIC, Splitter:B:76:0x0144] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4159a(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "massdk xcrash"
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            long r2 = r1.getTime()
            long r4 = r12.f7014r
            long r2 = r2 - r4
            r4 = 15000(0x3a98, double:7.411E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0015
            return
        L_0x0015:
            boolean r2 = r12.f7007k
            if (r2 == 0) goto L_0x0022
            android.content.Context r2 = r12.f7001e
            boolean r2 = xcrash.C3160Util.m4198a((android.content.Context) r2, (long) r4)
            if (r2 != 0) goto L_0x0022
            return
        L_0x0022:
            long r2 = r1.getTime()
            java.lang.String r13 = r12.m4157a((java.lang.String) r13, (long) r2)
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto L_0x0031
            return
        L_0x0031:
            long r2 = r1.getTime()
            r12.f7014r = r2
            xcrash.c r2 = xcrash.C3165c.m4219a()
            boolean r2 = r2.mo38805c()
            if (r2 != 0) goto L_0x0042
            return
        L_0x0042:
            r2 = 0
            java.lang.String r13 = r12.m4158a((java.util.Date) r1, (java.lang.String) r13)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r13 = move-exception
            xcrash.ILogger r3 = xcrash.XCrash.getLogger()
            java.lang.String r4 = "AnrHandler getEmergency failed"
            r3.mo38730e(r0, r4, r13)
            r13 = r2
        L_0x0053:
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = "%s/%s_%020d_%s__%s%s"
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x008f }
            r6 = 0
            java.lang.String r7 = r12.f7006j     // Catch:{ Exception -> 0x008f }
            r5[r6] = r7     // Catch:{ Exception -> 0x008f }
            r6 = 1
            java.lang.String r7 = "tombstone"
            r5[r6] = r7     // Catch:{ Exception -> 0x008f }
            r6 = 2
            long r7 = r1.getTime()     // Catch:{ Exception -> 0x008f }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x008f }
            r5[r6] = r1     // Catch:{ Exception -> 0x008f }
            r1 = 3
            java.lang.String r6 = r12.f7005i     // Catch:{ Exception -> 0x008f }
            r5[r1] = r6     // Catch:{ Exception -> 0x008f }
            r1 = 4
            java.lang.String r6 = r12.f7003g     // Catch:{ Exception -> 0x008f }
            r5[r1] = r6     // Catch:{ Exception -> 0x008f }
            r1 = 5
            java.lang.String r6 = ".anr.xcrash"
            r5[r1] = r6     // Catch:{ Exception -> 0x008f }
            java.lang.String r1 = java.lang.String.format(r3, r4, r5)     // Catch:{ Exception -> 0x008f }
            xcrash.c r3 = xcrash.C3165c.m4219a()     // Catch:{ Exception -> 0x008f }
            java.io.File r1 = r3.mo38800a((java.lang.String) r1)     // Catch:{ Exception -> 0x008f }
            goto L_0x009a
        L_0x008f:
            r1 = move-exception
            xcrash.ILogger r3 = xcrash.XCrash.getLogger()
            java.lang.String r4 = "AnrHandler createLogFile failed"
            r3.mo38730e(r0, r4, r1)
            r1 = r2
        L_0x009a:
            if (r1 != 0) goto L_0x00a6
            xcrash.ILogger r13 = xcrash.XCrash.getLogger()
            java.lang.String r1 = "AnrHandler logFile is null"
            r13.mo38729e(r0, r1)
            return
        L_0x00a6:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.lang.String r4 = "rws"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.lang.String r4 = "UTF-8"
            if (r13 == 0) goto L_0x00bb
            byte[] r5 = r13.getBytes(r4)     // Catch:{ Exception -> 0x00b9 }
            r3.write(r5)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00bb
        L_0x00b9:
            r2 = move-exception
            goto L_0x0112
        L_0x00bb:
            int r13 = r12.f7010n     // Catch:{ Exception -> 0x0107 }
            if (r13 > 0) goto L_0x00c7
            int r13 = r12.f7008l     // Catch:{ Exception -> 0x0107 }
            if (r13 > 0) goto L_0x00c7
            int r13 = r12.f7009m     // Catch:{ Exception -> 0x0107 }
            if (r13 <= 0) goto L_0x00d8
        L_0x00c7:
            int r13 = r12.f7010n     // Catch:{ Exception -> 0x0107 }
            int r5 = r12.f7008l     // Catch:{ Exception -> 0x0107 }
            int r6 = r12.f7009m     // Catch:{ Exception -> 0x0107 }
            java.lang.String r13 = xcrash.C3160Util.m4190a(r13, r5, r6)     // Catch:{ Exception -> 0x0107 }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x0107 }
            r3.write(r13)     // Catch:{ Exception -> 0x0107 }
        L_0x00d8:
            boolean r13 = r12.f7011o     // Catch:{ Exception -> 0x0107 }
            if (r13 == 0) goto L_0x00e7
            java.lang.String r13 = xcrash.C3160Util.getFds()     // Catch:{ Exception -> 0x0107 }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x0107 }
            r3.write(r13)     // Catch:{ Exception -> 0x0107 }
        L_0x00e7:
            boolean r13 = r12.f7012p     // Catch:{ Exception -> 0x0107 }
            if (r13 == 0) goto L_0x00f6
            java.lang.String r13 = xcrash.C3160Util.m4202c()     // Catch:{ Exception -> 0x0107 }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x0107 }
            r3.write(r13)     // Catch:{ Exception -> 0x0107 }
        L_0x00f6:
            java.lang.String r13 = xcrash.C3160Util.getMemoryInfo()     // Catch:{ Exception -> 0x0107 }
            byte[] r13 = r13.getBytes(r4)     // Catch:{ Exception -> 0x0107 }
            r3.write(r13)     // Catch:{ Exception -> 0x0107 }
            r3.close()     // Catch:{ Exception -> 0x0105 }
            goto L_0x0121
        L_0x0105:
            goto L_0x0121
        L_0x0107:
            r13 = move-exception
            r11 = r2
            r2 = r13
            r13 = r11
            goto L_0x0112
        L_0x010c:
            r13 = move-exception
            goto L_0x0142
        L_0x010e:
            r3 = move-exception
            r11 = r3
            r3 = r2
            r2 = r11
        L_0x0112:
            xcrash.ILogger r4 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x0140 }
            java.lang.String r5 = "AnrHandler write log file failed"
            r4.mo38730e(r0, r5, r2)     // Catch:{ all -> 0x0140 }
            if (r3 == 0) goto L_0x0120
            r3.close()     // Catch:{ Exception -> 0x0120 }
        L_0x0120:
            r2 = r13
        L_0x0121:
            if (r1 == 0) goto L_0x0136
            boolean r13 = r1.exists()
            if (r13 != 0) goto L_0x012a
            goto L_0x0136
        L_0x012a:
            xcrash.ICrashCallback r13 = r12.f7013q
            if (r13 == 0) goto L_0x0135
            java.lang.String r0 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0135 }
            r13.onCrash(r0, r2)     // Catch:{ Exception -> 0x0135 }
        L_0x0135:
            return
        L_0x0136:
            xcrash.ILogger r13 = xcrash.XCrash.getLogger()
            java.lang.String r1 = "AnrHandler logFile does not exist"
            r13.mo38729e(r0, r1)
            return
        L_0x0140:
            r13 = move-exception
            r2 = r3
        L_0x0142:
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ Exception -> 0x0147 }
        L_0x0147:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.AnrHandler.m4159a(java.lang.String):void");
    }

    /* renamed from: a */
    private String m4158a(Date date, String str) {
        return C3160Util.m4195a(this.f6997a, date, "anr", this.f7004h, this.f7005i) + "pid: " + this.f7002f + "  >>> " + this.f7003g + " <<<\n\n" + "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n" + str + "\n" + "+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++" + "\n\n";
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8 A[SYNTHETIC, Splitter:B:58:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A[SYNTHETIC, Splitter:B:65:0x00cf] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m4157a(java.lang.String r12, long r13) {
        /*
            r11 = this;
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss"
            r0.<init>(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00cc, all -> 0x00c5 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x00cc, all -> 0x00c5 }
            r4.<init>(r12)     // Catch:{ Exception -> 0x00cc, all -> 0x00c5 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00cc, all -> 0x00c5 }
            r12 = 1
            r4 = 0
        L_0x001b:
            java.lang.String r5 = r3.readLine()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r5 == 0) goto L_0x00b8
            r6 = 10
            if (r4 != 0) goto L_0x00a5
            java.lang.String r7 = "----- pid "
            boolean r7 = r5.startsWith(r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 == 0) goto L_0x00a5
            java.util.regex.Pattern r7 = r11.f6998b     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            java.util.regex.Matcher r5 = r7.matcher(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            boolean r7 = r5.find()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 == 0) goto L_0x001b
            int r7 = r5.groupCount()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r8 = 2
            if (r7 == r8) goto L_0x0041
            goto L_0x001b
        L_0x0041:
            java.lang.String r7 = r5.group(r12)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            java.lang.String r5 = r5.group(r8)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 == 0) goto L_0x001b
            if (r5 != 0) goto L_0x004e
            goto L_0x001b
        L_0x004e:
            int r8 = r11.f7002f     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r8 == r7) goto L_0x0057
            goto L_0x001b
        L_0x0057:
            java.util.Date r5 = r0.parse(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r5 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            long r7 = r5.getTime()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            long r7 = r7 - r13
            long r7 = java.lang.Math.abs(r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r9 = 15000(0x3a98, double:7.411E-320)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x006e
            goto L_0x001b
        L_0x006e:
            java.lang.String r5 = r3.readLine()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r5 != 0) goto L_0x0075
            goto L_0x00b8
        L_0x0075:
            java.util.regex.Pattern r7 = r11.f6999c     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            java.util.regex.Matcher r7 = r7.matcher(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            boolean r8 = r7.find()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r8 == 0) goto L_0x001b
            int r8 = r7.groupCount()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r8 == r12) goto L_0x0088
            goto L_0x001b
        L_0x0088:
            java.lang.String r7 = r7.group(r12)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 == 0) goto L_0x001b
            java.lang.String r8 = r11.f7003g     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 != 0) goto L_0x0097
            goto L_0x001b
        L_0x0097:
            r1.append(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r1.append(r6)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            java.lang.String r4 = "Mode: Watching /data/anr/*\n"
            r1.append(r4)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r4 = 1
            goto L_0x001b
        L_0x00a5:
            if (r4 == 0) goto L_0x001b
            java.lang.String r7 = "----- end "
            boolean r7 = r5.startsWith(r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 == 0) goto L_0x00b0
            goto L_0x00b8
        L_0x00b0:
            r1.append(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r1.append(r6)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            goto L_0x001b
        L_0x00b8:
            java.lang.String r12 = r1.toString()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r3.close()     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            return r12
        L_0x00c0:
            r12 = move-exception
            r2 = r3
            goto L_0x00c6
        L_0x00c3:
            goto L_0x00cd
        L_0x00c5:
            r12 = move-exception
        L_0x00c6:
            if (r2 == 0) goto L_0x00cb
            r2.close()     // Catch:{ Exception -> 0x00cb }
        L_0x00cb:
            throw r12
        L_0x00cc:
            r3 = r2
        L_0x00cd:
            if (r3 == 0) goto L_0x00d2
            r3.close()     // Catch:{ Exception -> 0x00d2 }
        L_0x00d2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.AnrHandler.m4157a(java.lang.String, long):java.lang.String");
    }
}
