package com.didichuxing.omega.sdk.xcrash;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.alpha.crash.CrashCallbacks;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.record.ANRRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.DataTrackUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.getkeepsafe.relinker.ReLinker;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import xcrash.ICrashCallback;
import xcrash.ILibLoader;
import xcrash.ILogger;
import xcrash.TombstoneManager;
import xcrash.TombstoneParser;
import xcrash.XCrash;

public class XCrashHelper {
    private static final String[] ANR_RETHROW_BLACK_LIST = {"OPPO R9s:6.0.1", "OPPO R9sk:6.0.1", "OPPO A57:6.0.1", "OPPO R9st:6.0.1", "OPPO A57t:6.0.1", "OPPO R9s Plus:6.0.1", "G0215D:6.0.1", "OPPO R9skt:6.0.1", "SM919:6.0.1", "G0245D:6.0.1", "PRO 6 Plus:6.0.1", "HUAWEI P8max:6.0", "HUAWEI NXT-AL10:6.0", "VIE-AL10:6.0", "EVA-AL10:6.0", "HUAWEI MT7-TL10:6.0", "FRD-AL10:6.0", "GEM-703L:6.0", "EVA-AL00:6.0", "HUAWEI MT7-CL00:6.0", "HUAWEI M2-803L:6.0", "HUAWEI MLA-AL10:6.0"};
    private static final ArrayList<CrashCallbacks> sCrashCallbacks = new ArrayList<>();
    private static boolean sInitial = false;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(final android.content.Context r3, final boolean r4, final boolean r5) {
        /*
            java.lang.Class<com.didichuxing.omega.sdk.xcrash.XCrashHelper> r0 = com.didichuxing.omega.sdk.xcrash.XCrashHelper.class
            monitor-enter(r0)
            boolean r1 = sInitial     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            sInitial = r1     // Catch:{ all -> 0x0031 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0031 }
            java.lang.Thread r2 = r2.getThread()     // Catch:{ all -> 0x0031 }
            if (r1 != r2) goto L_0x001e
            onInit(r3, r4, r5)     // Catch:{ all -> 0x0031 }
            goto L_0x002f
        L_0x001e:
            android.os.Handler r1 = new android.os.Handler     // Catch:{ all -> 0x0031 }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0031 }
            r1.<init>(r2)     // Catch:{ all -> 0x0031 }
            com.didichuxing.omega.sdk.xcrash.XCrashHelper$1 r2 = new com.didichuxing.omega.sdk.xcrash.XCrashHelper$1     // Catch:{ all -> 0x0031 }
            r2.<init>(r3, r4, r5)     // Catch:{ all -> 0x0031 }
            r1.postAtFrontOfQueue(r2)     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r0)
            return
        L_0x0031:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.xcrash.XCrashHelper.init(android.content.Context, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    public static synchronized void onInit(final Context context, boolean z, boolean z2) {
        boolean z3;
        synchronized (XCrashHelper.class) {
            OLog.m34765i("XCrashHelper init crashEnabled:" + z + " anrEnabled:" + z2);
            try {
                monitorMainThread();
                if (z || z2) {
                    XCrash.InitParameters disableJavaCrashHandler = new XCrash.InitParameters().setAppVersion(PackageCollector.getVN()).setAnrLogcatEventsLines(0).setAnrLogcatMainLines(0).setAnrLogcatSystemLines(0).setNativeLogcatEventsLines(0).setNativeLogcatMainLines(0).setNativeLogcatSystemLines(0).setPlaceholderSizeKb(0).setAnrDumpFds(false).setAnrDumpNetwork(false).setAnrLogCountMax(20).setNativeLogCountMax(20).setNativeDumpAllThreads(true).setNativeDumpAllThreadsCountMax(0).setNativeDumpElfHash(false).setNativeDumpMap(false).setNativeDumpFds(false).setNativeDumpNetwork(false).disableJavaCrashHandler();
                    disableJavaCrashHandler.setLogger(new ILogger() {
                        /* renamed from: v */
                        public void mo38733v(String str, String str2) {
                            OLog.m34765i(str + ":" + str2);
                        }

                        /* renamed from: v */
                        public void mo38734v(String str, String str2, Throwable th) {
                            OLog.m34766i(str + ":" + str2, th);
                        }

                        /* renamed from: d */
                        public void mo38727d(String str, String str2) {
                            OLog.m34765i(str + ":" + str2);
                        }

                        /* renamed from: d */
                        public void mo38728d(String str, String str2, Throwable th) {
                            OLog.m34766i(str + ":" + str2, th);
                        }

                        /* renamed from: i */
                        public void mo38731i(String str, String str2) {
                            OLog.m34765i(str + ":" + str2);
                        }

                        /* renamed from: i */
                        public void mo38732i(String str, String str2, Throwable th) {
                            OLog.m34766i(str + ":" + str2, th);
                        }

                        /* renamed from: w */
                        public void mo38735w(String str, String str2) {
                            OLog.m34769w(str + ":" + str2);
                        }

                        /* renamed from: w */
                        public void mo38736w(String str, String str2, Throwable th) {
                            OLog.m34770w(str + ":" + str2, th);
                        }

                        /* renamed from: e */
                        public void mo38729e(String str, String str2) {
                            OLog.m34763e(str + ":" + str2);
                        }

                        /* renamed from: e */
                        public void mo38730e(String str, String str2, Throwable th) {
                            OLog.m34764e(str + ":" + str2, th);
                        }
                    });
                    disableJavaCrashHandler.setLibLoader(new ILibLoader() {
                        public void loadLibrary(String str) {
                            ReLinker.loadLibrary(context, str);
                        }
                    });
                    if (z) {
                        disableJavaCrashHandler.enableNativeCrashHandler();
                    } else {
                        disableJavaCrashHandler.disableNativeCrashHandler();
                    }
                    if (z2) {
                        disableJavaCrashHandler.enableAnrCrashHandler();
                    } else {
                        disableJavaCrashHandler.disableAnrCrashHandler();
                    }
                    disableJavaCrashHandler.setAnrCallback(new ICrashCallback() {
                        public void onCrash(String str, String str2) throws Exception {
                            XCrashHelper.handleAnr(str, str2, true);
                        }
                    }).setNativeCallback(new ICrashCallback() {
                        public void onCrash(String str, String str2) throws Exception {
                            XCrashHelper.handleNativeCrash(str, str2, true);
                        }
                    });
                    String str = Build.MODEL + ":" + Build.VERSION.RELEASE;
                    String[] strArr = ANR_RETHROW_BLACK_LIST;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z3 = false;
                            break;
                        } else if (str.equals(strArr[i])) {
                            z3 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z3) {
                        disableJavaCrashHandler.setAnrRethrow(false);
                    }
                    XCrash.init(context, disableJavaCrashHandler);
                    OmegaConfig.PRE_INIT_ANR = true;
                    ThreadTaskObject.execute(new Runnable() {
                        public void run() {
                            try {
                                for (File file : TombstoneManager.getAllTombstones()) {
                                    if (TombstoneManager.isAnr(file)) {
                                        XCrashHelper.handleAnr(file, "", false);
                                    }
                                    if (TombstoneManager.isNativeCrash(file)) {
                                        XCrashHelper.handleNativeCrash(file, "", false);
                                    }
                                }
                            } catch (Exception e) {
                                OLog.m34764e("Upload remain files failed", e);
                            }
                        }
                    });
                } else {
                    return;
                }
            } catch (Exception e) {
                OLog.m34764e("XCrash init error", e);
            }
        }
        return;
    }

    private static void monitorMainThread() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());
        handler.postDelayed(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                long j = atomicLong.get();
                long j2 = (currentTimeMillis - j) - 5000;
                if (j2 >= 50) {
                    SystemUtils.log(5, "omegasdk", "Too much work on main thread, delay " + j2 + " ms(" + j + "-" + currentTimeMillis + ") for loop.", (Throwable) null, "com.didichuxing.omega.sdk.xcrash.XCrashHelper$7", 262);
                }
                atomicLong.set(System.currentTimeMillis());
                handler.postDelayed(this, 5000);
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    public static void handleAnr(String str, String str2, boolean z) {
        handleAnr(new File(str), str2, z);
    }

    /* access modifiers changed from: private */
    public static void handleAnr(File file, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle ");
        sb.append(z ? "realtime" : "unfinished");
        sb.append(" ANR, path:");
        sb.append(file);
        sb.append(" emergency:");
        sb.append(str);
        OLog.m34769w(sb.toString());
        try {
            File file2 = new File(file.getParentFile(), "traces.txt");
            file.renameTo(file2);
            ANRRecord createANRRecord = RecordFactory.createANRRecord(file2.getAbsolutePath());
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_anr", OmegaConfig.UPPER_LIMIT_ANR_EVENT_PER_DAY);
            createANRRecord.takeLogCatWithAnrReason();
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.ANR, createANRRecord.getRecordId(), isUpperLimitByDay);
            if (!isUpperLimitByDay) {
                RecordStorage.save(createANRRecord);
                CommonUtil.addUpperLimitByDay("upper_limit_anr");
                SystemClock.sleep(5000);
                deleteFile(file);
                deleteFile(file2);
            }
        } catch (Exception e) {
            OLog.m34764e("handleAnr error", e);
        }
    }

    /* access modifiers changed from: private */
    public static void handleNativeCrash(String str, String str2, boolean z) {
        handleNativeCrash(new File(str), str2, z);
    }

    /* access modifiers changed from: private */
    public static void handleNativeCrash(File file, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle ");
        sb.append(z ? "realtime" : "unfinished");
        sb.append(" Native crash, path:");
        sb.append(file);
        sb.append(" emergency:");
        sb.append(str);
        OLog.m34769w(sb.toString());
        try {
            Map<String, String> parse = TombstoneParser.parse(file);
            String str2 = parse.get("signal");
            String str3 = parse.get("code");
            String str4 = parse.get(TombstoneParser.keyFaultAddr);
            String str5 = parse.get(TombstoneParser.keyBacktrace);
            boolean contains = !TextUtils.isEmpty(str5) ? str5.contains("/system/lib/libunwind.so") : false;
            OLog.m34769w("Crash reason: signal " + str2 + ", code " + str3 + " fault addr: " + str4 + "should ignore:" + contains);
            if (contains) {
                deleteFile(file);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "native");
            hashMap.put("signal", str2);
            hashMap.put("code", str3);
            hashMap.put(TombstoneParser.keyBacktrace, str5);
            hashMap.put("faultAddr", str4);
            hashMap.put("path", file.getAbsolutePath());
            Object[] objArr = null;
            synchronized (sCrashCallbacks) {
                if (sCrashCallbacks.size() > 0) {
                    objArr = sCrashCallbacks.toArray();
                }
            }
            if (objArr != null) {
                for (Object obj : objArr) {
                    ((CrashCallbacks) obj).onCrash(hashMap);
                }
            }
            RecordStorage.save(RecordFactory.createUnwindRecord(file));
            SystemClock.sleep(5000);
            deleteFile(file);
        } catch (IOException e) {
            try {
                OLog.m34764e("parse native crash file error", e);
            } catch (Exception e2) {
                OLog.m34764e("handleNativeCrash error", e2);
            }
        }
    }

    private static void deleteFile(File file) {
        try {
            file.delete();
        } catch (Exception unused) {
        }
    }

    public static void test(boolean z) {
        XCrash.testNativeCrash(z);
    }

    public static void registerCrashCallbacks(CrashCallbacks crashCallbacks) {
        synchronized (sCrashCallbacks) {
            sCrashCallbacks.add(crashCallbacks);
        }
    }

    public static void unregisterCrashCallbacks(CrashCallbacks crashCallbacks) {
        synchronized (sCrashCallbacks) {
            sCrashCallbacks.remove(crashCallbacks);
        }
    }
}
