package xcrash;

import android.content.Context;

public final class XCrash {
    private static String appId = null;
    private static String appVersion = null;
    private static boolean initialized = false;
    private static String logDir;
    private static ILogger logger = new C3164b();
    public static String nativeLibDir = null;

    private XCrash() {
    }

    public static int init(Context context) {
        return init(context, (InitParameters) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int init(android.content.Context r32, xcrash.XCrash.InitParameters r33) {
        /*
            java.lang.Class<xcrash.XCrash> r1 = xcrash.XCrash.class
            monitor-enter(r1)
            boolean r0 = initialized     // Catch:{ all -> 0x01dc }
            r2 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r1)
            return r2
        L_0x000a:
            r0 = 1
            initialized = r0     // Catch:{ all -> 0x01dc }
            if (r32 != 0) goto L_0x0012
            r0 = -1
            monitor-exit(r1)
            return r0
        L_0x0012:
            android.content.Context r3 = r32.getApplicationContext()     // Catch:{ all -> 0x01dc }
            if (r3 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r3 = r32
        L_0x001b:
            if (r33 != 0) goto L_0x0024
            xcrash.XCrash$InitParameters r4 = new xcrash.XCrash$InitParameters     // Catch:{ all -> 0x01dc }
            r4.<init>()     // Catch:{ all -> 0x01dc }
            r15 = r4
            goto L_0x0026
        L_0x0024:
            r15 = r33
        L_0x0026:
            xcrash.ILogger r4 = r15.logger     // Catch:{ all -> 0x01dc }
            if (r4 == 0) goto L_0x002e
            xcrash.ILogger r4 = r15.logger     // Catch:{ all -> 0x01dc }
            logger = r4     // Catch:{ all -> 0x01dc }
        L_0x002e:
            java.lang.String r4 = r3.getPackageName()     // Catch:{ all -> 0x01dc }
            appId = r4     // Catch:{ all -> 0x01dc }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01dc }
            if (r5 == 0) goto L_0x003e
            java.lang.String r5 = "unknown"
            appId = r5     // Catch:{ all -> 0x01dc }
        L_0x003e:
            java.lang.String r5 = r15.appVersion     // Catch:{ all -> 0x01dc }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01dc }
            if (r5 == 0) goto L_0x004c
            java.lang.String r5 = xcrash.C3160Util.m4191a((android.content.Context) r3)     // Catch:{ all -> 0x01dc }
            r15.appVersion = r5     // Catch:{ all -> 0x01dc }
        L_0x004c:
            java.lang.String r5 = r15.appVersion     // Catch:{ all -> 0x01dc }
            appVersion = r5     // Catch:{ all -> 0x01dc }
            android.content.pm.ApplicationInfo r5 = r3.getApplicationInfo()     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = r5.nativeLibraryDir     // Catch:{ all -> 0x01dc }
            nativeLibDir = r5     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = r15.logDir     // Catch:{ all -> 0x01dc }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01dc }
            if (r5 == 0) goto L_0x0077
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            r5.<init>()     // Catch:{ all -> 0x01dc }
            java.io.File r6 = r3.getFilesDir()     // Catch:{ all -> 0x01dc }
            r5.append(r6)     // Catch:{ all -> 0x01dc }
            java.lang.String r6 = "/tombstones"
            r5.append(r6)     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01dc }
            r15.logDir = r5     // Catch:{ all -> 0x01dc }
        L_0x0077:
            java.lang.String r5 = r15.logDir     // Catch:{ all -> 0x01dc }
            logDir = r5     // Catch:{ all -> 0x01dc }
            int r6 = android.os.Process.myPid()     // Catch:{ all -> 0x01dc }
            r5 = 0
            boolean r7 = r15.enableJavaCrashHandler     // Catch:{ all -> 0x01dc }
            if (r7 != 0) goto L_0x008b
            boolean r7 = r15.enableAnrHandler     // Catch:{ all -> 0x01dc }
            if (r7 == 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r7 = r5
            goto L_0x00a2
        L_0x008b:
            java.lang.String r5 = xcrash.C3160Util.m4192a((android.content.Context) r3, (int) r6)     // Catch:{ all -> 0x01dc }
            boolean r7 = r15.enableAnrHandler     // Catch:{ all -> 0x01dc }
            if (r7 == 0) goto L_0x0089
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01dc }
            if (r7 != 0) goto L_0x009f
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x01dc }
            if (r4 != 0) goto L_0x0089
        L_0x009f:
            r15.enableAnrHandler = r2     // Catch:{ all -> 0x01dc }
            goto L_0x0089
        L_0x00a2:
            xcrash.c r16 = xcrash.C3165c.m4219a()     // Catch:{ all -> 0x01dc }
            java.lang.String r4 = r15.logDir     // Catch:{ all -> 0x01dc }
            int r5 = r15.javaLogCountMax     // Catch:{ all -> 0x01dc }
            int r8 = r15.nativeLogCountMax     // Catch:{ all -> 0x01dc }
            int r9 = r15.anrLogCountMax     // Catch:{ all -> 0x01dc }
            int r10 = r15.placeholderCountMax     // Catch:{ all -> 0x01dc }
            int r11 = r15.placeholderSizeKb     // Catch:{ all -> 0x01dc }
            int r12 = r15.logFileMaintainDelayMs     // Catch:{ all -> 0x01dc }
            r17 = r4
            r18 = r5
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r11
            r23 = r12
            r16.mo38801a(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x01dc }
            boolean r4 = r15.enableJavaCrashHandler     // Catch:{ all -> 0x01dc }
            if (r4 != 0) goto L_0x00d1
            boolean r4 = r15.enableNativeCrashHandler     // Catch:{ all -> 0x01dc }
            if (r4 != 0) goto L_0x00d1
            boolean r4 = r15.enableAnrHandler     // Catch:{ all -> 0x01dc }
            if (r4 == 0) goto L_0x00df
        L_0x00d1:
            boolean r4 = r3 instanceof android.app.Application     // Catch:{ all -> 0x01dc }
            if (r4 == 0) goto L_0x00df
            xcrash.a r4 = xcrash.C3163a.m4204a()     // Catch:{ all -> 0x01dc }
            r5 = r3
            android.app.Application r5 = (android.app.Application) r5     // Catch:{ all -> 0x01dc }
            r4.mo38797a((android.app.Application) r5)     // Catch:{ all -> 0x01dc }
        L_0x00df:
            boolean r4 = r15.enableJavaCrashHandler     // Catch:{ all -> 0x01dc }
            if (r4 == 0) goto L_0x0123
            xcrash.JavaCrashHandler r16 = xcrash.JavaCrashHandler.getInstance()     // Catch:{ all -> 0x01dc }
            java.lang.String r19 = appId     // Catch:{ all -> 0x01dc }
            java.lang.String r4 = r15.appVersion     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = r15.logDir     // Catch:{ all -> 0x01dc }
            boolean r8 = r15.javaRethrow     // Catch:{ all -> 0x01dc }
            int r9 = r15.javaLogcatSystemLines     // Catch:{ all -> 0x01dc }
            int r10 = r15.javaLogcatEventsLines     // Catch:{ all -> 0x01dc }
            int r11 = r15.javaLogcatMainLines     // Catch:{ all -> 0x01dc }
            boolean r12 = r15.javaDumpFds     // Catch:{ all -> 0x01dc }
            boolean r13 = r15.javaDumpNetworkInfo     // Catch:{ all -> 0x01dc }
            boolean r14 = r15.javaDumpAllThreads     // Catch:{ all -> 0x01dc }
            int r0 = r15.javaDumpAllThreadsCountMax     // Catch:{ all -> 0x01dc }
            java.lang.String[] r2 = r15.javaDumpAllThreadsWhiteList     // Catch:{ all -> 0x01dc }
            r32 = r3
            xcrash.ICrashCallback r3 = r15.javaCallback     // Catch:{ all -> 0x01dc }
            r17 = r6
            r18 = r7
            r20 = r4
            r21 = r5
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r0
            r30 = r2
            r31 = r3
            r16.mo38737a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)     // Catch:{ all -> 0x01dc }
            goto L_0x0125
        L_0x0123:
            r32 = r3
        L_0x0125:
            boolean r0 = r15.enableAnrHandler     // Catch:{ all -> 0x01dc }
            r2 = 21
            if (r0 == 0) goto L_0x0153
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01dc }
            if (r0 >= r2) goto L_0x0153
            xcrash.AnrHandler r4 = xcrash.AnrHandler.getInstance()     // Catch:{ all -> 0x01dc }
            java.lang.String r8 = appId     // Catch:{ all -> 0x01dc }
            java.lang.String r9 = r15.appVersion     // Catch:{ all -> 0x01dc }
            java.lang.String r10 = r15.logDir     // Catch:{ all -> 0x01dc }
            boolean r11 = r15.anrCheckProcessState     // Catch:{ all -> 0x01dc }
            int r12 = r15.anrLogcatSystemLines     // Catch:{ all -> 0x01dc }
            int r13 = r15.anrLogcatEventsLines     // Catch:{ all -> 0x01dc }
            int r14 = r15.anrLogcatMainLines     // Catch:{ all -> 0x01dc }
            boolean r0 = r15.anrDumpFds     // Catch:{ all -> 0x01dc }
            boolean r3 = r15.anrDumpNetworkInfo     // Catch:{ all -> 0x01dc }
            xcrash.ICrashCallback r5 = r15.anrCallback     // Catch:{ all -> 0x01dc }
            r17 = r5
            r5 = r32
            r2 = r15
            r15 = r0
            r16 = r3
            r4.mo38711a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x01dc }
            goto L_0x0154
        L_0x0153:
            r2 = r15
        L_0x0154:
            boolean r0 = r2.enableNativeCrashHandler     // Catch:{ all -> 0x01dc }
            if (r0 != 0) goto L_0x0166
            boolean r0 = r2.enableAnrHandler     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x0163
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01dc }
            r3 = 21
            if (r0 < r3) goto L_0x0163
            goto L_0x0166
        L_0x0163:
            r2 = 0
            goto L_0x01d3
        L_0x0166:
            xcrash.NativeHandler r4 = xcrash.NativeHandler.getInstance()     // Catch:{ all -> 0x01dc }
            xcrash.ILibLoader r6 = r2.libLoader     // Catch:{ all -> 0x01dc }
            java.lang.String r7 = appId     // Catch:{ all -> 0x01dc }
            java.lang.String r8 = r2.appVersion     // Catch:{ all -> 0x01dc }
            java.lang.String r9 = r2.logDir     // Catch:{ all -> 0x01dc }
            boolean r10 = r2.enableNativeCrashHandler     // Catch:{ all -> 0x01dc }
            boolean r11 = r2.nativeRethrow     // Catch:{ all -> 0x01dc }
            int r12 = r2.nativeLogcatSystemLines     // Catch:{ all -> 0x01dc }
            int r13 = r2.nativeLogcatEventsLines     // Catch:{ all -> 0x01dc }
            int r14 = r2.nativeLogcatMainLines     // Catch:{ all -> 0x01dc }
            boolean r15 = r2.nativeDumpElfHash     // Catch:{ all -> 0x01dc }
            boolean r0 = r2.nativeDumpMap     // Catch:{ all -> 0x01dc }
            boolean r3 = r2.nativeDumpFds     // Catch:{ all -> 0x01dc }
            boolean r5 = r2.nativeDumpNetworkInfo     // Catch:{ all -> 0x01dc }
            r17 = r3
            boolean r3 = r2.nativeDumpAllThreads     // Catch:{ all -> 0x01dc }
            r19 = r3
            int r3 = r2.nativeDumpAllThreadsCountMax     // Catch:{ all -> 0x01dc }
            r20 = r3
            java.lang.String[] r3 = r2.nativeDumpAllThreadsWhiteList     // Catch:{ all -> 0x01dc }
            r21 = r3
            xcrash.ICrashCallback r3 = r2.nativeCallback     // Catch:{ all -> 0x01dc }
            r16 = r5
            boolean r5 = r2.enableAnrHandler     // Catch:{ all -> 0x01dc }
            if (r5 == 0) goto L_0x01a5
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01dc }
            r22 = r3
            r3 = 21
            if (r5 < r3) goto L_0x01a7
            r23 = 1
            goto L_0x01a9
        L_0x01a5:
            r22 = r3
        L_0x01a7:
            r23 = 0
        L_0x01a9:
            boolean r3 = r2.anrRethrow     // Catch:{ all -> 0x01dc }
            boolean r5 = r2.anrCheckProcessState     // Catch:{ all -> 0x01dc }
            r24 = r3
            int r3 = r2.anrLogcatSystemLines     // Catch:{ all -> 0x01dc }
            r26 = r3
            int r3 = r2.anrLogcatEventsLines     // Catch:{ all -> 0x01dc }
            r27 = r3
            int r3 = r2.anrLogcatMainLines     // Catch:{ all -> 0x01dc }
            r28 = r3
            boolean r3 = r2.anrDumpFds     // Catch:{ all -> 0x01dc }
            r29 = r3
            boolean r3 = r2.anrDumpNetworkInfo     // Catch:{ all -> 0x01dc }
            xcrash.ICrashCallback r2 = r2.anrCallback     // Catch:{ all -> 0x01dc }
            r25 = r5
            r18 = r16
            r5 = r32
            r16 = r0
            r30 = r3
            r31 = r2
            int r2 = r4.mo38739a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)     // Catch:{ all -> 0x01dc }
        L_0x01d3:
            xcrash.c r0 = xcrash.C3165c.m4219a()     // Catch:{ all -> 0x01dc }
            r0.mo38804b()     // Catch:{ all -> 0x01dc }
            monitor-exit(r1)
            return r2
        L_0x01dc:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.XCrash.init(android.content.Context, xcrash.XCrash$InitParameters):int");
    }

    public static class InitParameters {
        ICrashCallback anrCallback = null;
        boolean anrCheckProcessState = true;
        boolean anrDumpFds = true;
        boolean anrDumpNetworkInfo = true;
        int anrLogCountMax = 10;
        int anrLogcatEventsLines = 50;
        int anrLogcatMainLines = 200;
        int anrLogcatSystemLines = 50;
        boolean anrRethrow = true;
        String appVersion = null;
        boolean enableAnrHandler = true;
        boolean enableJavaCrashHandler = true;
        boolean enableNativeCrashHandler = true;
        ICrashCallback javaCallback = null;
        boolean javaDumpAllThreads = true;
        int javaDumpAllThreadsCountMax = 0;
        String[] javaDumpAllThreadsWhiteList = null;
        boolean javaDumpFds = true;
        boolean javaDumpNetworkInfo = true;
        int javaLogCountMax = 10;
        int javaLogcatEventsLines = 50;
        int javaLogcatMainLines = 200;
        int javaLogcatSystemLines = 50;
        boolean javaRethrow = true;
        ILibLoader libLoader = null;
        String logDir = null;
        int logFileMaintainDelayMs = 5000;
        ILogger logger = null;
        ICrashCallback nativeCallback = null;
        boolean nativeDumpAllThreads = true;
        int nativeDumpAllThreadsCountMax = 0;
        String[] nativeDumpAllThreadsWhiteList = null;
        boolean nativeDumpElfHash = true;
        boolean nativeDumpFds = true;
        boolean nativeDumpMap = true;
        boolean nativeDumpNetworkInfo = true;
        int nativeLogCountMax = 10;
        int nativeLogcatEventsLines = 50;
        int nativeLogcatMainLines = 200;
        int nativeLogcatSystemLines = 50;
        boolean nativeRethrow = true;
        int placeholderCountMax = 0;
        int placeholderSizeKb = 128;

        public InitParameters setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public InitParameters setLogDir(String str) {
            this.logDir = str;
            return this;
        }

        public InitParameters setLogFileMaintainDelayMs(int i) {
            if (i < 0) {
                i = 0;
            }
            this.logFileMaintainDelayMs = i;
            return this;
        }

        public InitParameters setLogger(ILogger iLogger) {
            this.logger = iLogger;
            return this;
        }

        public InitParameters setLibLoader(ILibLoader iLibLoader) {
            this.libLoader = iLibLoader;
            return this;
        }

        public InitParameters setPlaceholderCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.placeholderCountMax = i;
            return this;
        }

        public InitParameters setPlaceholderSizeKb(int i) {
            if (i < 0) {
                i = 0;
            }
            this.placeholderSizeKb = i;
            return this;
        }

        public InitParameters enableJavaCrashHandler() {
            this.enableJavaCrashHandler = true;
            return this;
        }

        public InitParameters disableJavaCrashHandler() {
            this.enableJavaCrashHandler = false;
            return this;
        }

        public InitParameters setJavaRethrow(boolean z) {
            this.javaRethrow = z;
            return this;
        }

        public InitParameters setJavaLogCountMax(int i) {
            if (i < 1) {
                i = 1;
            }
            this.javaLogCountMax = i;
            return this;
        }

        public InitParameters setJavaLogcatSystemLines(int i) {
            this.javaLogcatSystemLines = i;
            return this;
        }

        public InitParameters setJavaLogcatEventsLines(int i) {
            this.javaLogcatEventsLines = i;
            return this;
        }

        public InitParameters setJavaLogcatMainLines(int i) {
            this.javaLogcatMainLines = i;
            return this;
        }

        public InitParameters setJavaDumpFds(boolean z) {
            this.javaDumpFds = z;
            return this;
        }

        public InitParameters setJavaDumpNetworkInfo(boolean z) {
            this.javaDumpNetworkInfo = z;
            return this;
        }

        public InitParameters setJavaDumpAllThreads(boolean z) {
            this.javaDumpAllThreads = z;
            return this;
        }

        public InitParameters setJavaDumpAllThreadsCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.javaDumpAllThreadsCountMax = i;
            return this;
        }

        public InitParameters setJavaDumpAllThreadsWhiteList(String[] strArr) {
            this.javaDumpAllThreadsWhiteList = strArr;
            return this;
        }

        public InitParameters setJavaCallback(ICrashCallback iCrashCallback) {
            this.javaCallback = iCrashCallback;
            return this;
        }

        public InitParameters enableNativeCrashHandler() {
            this.enableNativeCrashHandler = true;
            return this;
        }

        public InitParameters disableNativeCrashHandler() {
            this.enableNativeCrashHandler = false;
            return this;
        }

        public InitParameters setNativeRethrow(boolean z) {
            this.nativeRethrow = z;
            return this;
        }

        public InitParameters setNativeLogCountMax(int i) {
            if (i < 1) {
                i = 1;
            }
            this.nativeLogCountMax = i;
            return this;
        }

        public InitParameters setNativeLogcatSystemLines(int i) {
            this.nativeLogcatSystemLines = i;
            return this;
        }

        public InitParameters setNativeLogcatEventsLines(int i) {
            this.nativeLogcatEventsLines = i;
            return this;
        }

        public InitParameters setNativeLogcatMainLines(int i) {
            this.nativeLogcatMainLines = i;
            return this;
        }

        public InitParameters setNativeDumpElfHash(boolean z) {
            this.nativeDumpElfHash = z;
            return this;
        }

        public InitParameters setNativeDumpMap(boolean z) {
            this.nativeDumpMap = z;
            return this;
        }

        public InitParameters setNativeDumpFds(boolean z) {
            this.nativeDumpFds = z;
            return this;
        }

        public InitParameters setNativeDumpNetwork(boolean z) {
            this.nativeDumpNetworkInfo = z;
            return this;
        }

        public InitParameters setNativeDumpAllThreads(boolean z) {
            this.nativeDumpAllThreads = z;
            return this;
        }

        public InitParameters setNativeDumpAllThreadsCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.nativeDumpAllThreadsCountMax = i;
            return this;
        }

        public InitParameters setNativeDumpAllThreadsWhiteList(String[] strArr) {
            this.nativeDumpAllThreadsWhiteList = strArr;
            return this;
        }

        public InitParameters setNativeCallback(ICrashCallback iCrashCallback) {
            this.nativeCallback = iCrashCallback;
            return this;
        }

        public InitParameters enableAnrCrashHandler() {
            this.enableAnrHandler = true;
            return this;
        }

        public InitParameters disableAnrCrashHandler() {
            this.enableAnrHandler = false;
            return this;
        }

        public InitParameters setAnrRethrow(boolean z) {
            this.anrRethrow = z;
            return this;
        }

        public InitParameters setAnrCheckProcessState(boolean z) {
            this.anrCheckProcessState = z;
            return this;
        }

        public InitParameters setAnrLogCountMax(int i) {
            if (i < 1) {
                i = 1;
            }
            this.anrLogCountMax = i;
            return this;
        }

        public InitParameters setAnrLogcatSystemLines(int i) {
            this.anrLogcatSystemLines = i;
            return this;
        }

        public InitParameters setAnrLogcatEventsLines(int i) {
            this.anrLogcatEventsLines = i;
            return this;
        }

        public InitParameters setAnrLogcatMainLines(int i) {
            this.anrLogcatMainLines = i;
            return this;
        }

        public InitParameters setAnrDumpFds(boolean z) {
            this.anrDumpFds = z;
            return this;
        }

        public InitParameters setAnrDumpNetwork(boolean z) {
            this.anrDumpNetworkInfo = z;
            return this;
        }

        public InitParameters setAnrCallback(ICrashCallback iCrashCallback) {
            this.anrCallback = iCrashCallback;
            return this;
        }
    }

    static String getAppId() {
        return appId;
    }

    static String getAppVersion() {
        return appVersion;
    }

    public static String getLogDir() {
        return logDir;
    }

    static ILogger getLogger() {
        return logger;
    }

    public static void testJavaCrash(boolean z) throws RuntimeException {
        if (z) {
            C31621 r1 = new Thread() {
                public void run() {
                    throw new RuntimeException("test java exception");
                }
            };
            r1.setName("xcrash_test_java_thread");
            r1.start();
            return;
        }
        throw new RuntimeException("test java exception");
    }

    public static void testNativeCrash(boolean z) {
        NativeHandler.getInstance().mo38740a(z);
    }
}
