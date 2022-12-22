package com.didichuxing.mas.sdk.quality.collect.xcrash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.collect.crash.CrashCallbacks;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.FdUtil;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.MemUtil;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector;
import com.didichuxing.mas.sdk.quality.report.record.ANRRecord;
import com.didichuxing.mas.sdk.quality.report.record.NativeCrashRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordFactory;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.DataTrackUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.getkeepsafe.relinker.ReLinker;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import xcrash.C3160Util;
import xcrash.ICrashCallback;
import xcrash.ILibLoader;
import xcrash.ILogger;
import xcrash.TombstoneManager;
import xcrash.TombstoneParser;
import xcrash.XCrash;

public class XCrashHelper {

    /* renamed from: a */
    private static final ArrayList<CrashCallbacks> f48247a = new ArrayList<>();

    /* renamed from: b */
    private static final AtomicBoolean f48248b = new AtomicBoolean(false);

    public static void init(final Context context, final boolean z, final boolean z2) {
        if (f48248b.compareAndSet(false, true)) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                m34391b(context, z, z2);
            } else {
                new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        XCrashHelper.m34391b(context, z, z2);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m34391b(final Context context, boolean z, boolean z2) {
        OLog.m34420i("XCrashHelper init crashEnabled:" + z + " anrEnabled:" + z2);
        if (z || z2) {
            try {
                XCrash.InitParameters initParameters = new XCrash.InitParameters();
                XCrash.InitParameters disableJavaCrashHandler = initParameters.setLogDir(context.getExternalFilesDir((String) null) + "/tombstones").setAppVersion(PackageCollector.getVN()).setAnrLogcatEventsLines(0).setAnrLogcatMainLines(0).setAnrLogcatSystemLines(0).setNativeLogcatEventsLines(0).setNativeLogcatMainLines(0).setNativeLogcatSystemLines(0).setPlaceholderSizeKb(0).setAnrDumpFds(true).setAnrDumpNetwork(false).setAnrLogCountMax(20).setNativeLogCountMax(20).setNativeDumpAllThreads(true).setNativeDumpAllThreadsCountMax(0).setNativeDumpElfHash(false).setNativeDumpMap(MASConfig.SWITCH_NATIVE_DUMP_MAP).setNativeDumpFds(MASConfig.OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO).setNativeDumpNetwork(false).disableJavaCrashHandler();
                disableJavaCrashHandler.setLogger(new ILogger() {
                    /* renamed from: v */
                    public void mo38733v(String str, String str2) {
                        OLog.m34420i(str + ":" + str2);
                    }

                    /* renamed from: v */
                    public void mo38734v(String str, String str2, Throwable th) {
                        OLog.m34421i(str + ":" + str2, th);
                    }

                    /* renamed from: d */
                    public void mo38727d(String str, String str2) {
                        OLog.m34420i(str + ":" + str2);
                    }

                    /* renamed from: d */
                    public void mo38728d(String str, String str2, Throwable th) {
                        OLog.m34421i(str + ":" + str2, th);
                    }

                    /* renamed from: i */
                    public void mo38731i(String str, String str2) {
                        OLog.m34420i(str + ":" + str2);
                    }

                    /* renamed from: i */
                    public void mo38732i(String str, String str2, Throwable th) {
                        OLog.m34421i(str + ":" + str2, th);
                    }

                    /* renamed from: w */
                    public void mo38735w(String str, String str2) {
                        OLog.m34424w(str + ":" + str2);
                    }

                    /* renamed from: w */
                    public void mo38736w(String str, String str2, Throwable th) {
                        OLog.m34425w(str + ":" + str2, th);
                    }

                    /* renamed from: e */
                    public void mo38729e(String str, String str2) {
                        OLog.m34418e(str + ":" + str2);
                    }

                    /* renamed from: e */
                    public void mo38730e(String str, String str2, Throwable th) {
                        OLog.m34419e(str + ":" + str2, th);
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
                        XCrashHelper.m34395c(str, str2, true);
                    }
                }).setNativeCallback(new ICrashCallback() {
                    public void onCrash(String str, String str2) throws Exception {
                        XCrashHelper.m34397d(str, str2, true);
                    }
                });
                disableJavaCrashHandler.setAnrRethrow(true);
                XCrash.init(context, disableJavaCrashHandler);
                MASConfig.PRE_INIT_ANR = true;
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            for (File file : TombstoneManager.getAllTombstones()) {
                                if (!TombstoneManager.isAnr(file)) {
                                    if (!TombstoneManager.isTrace(file)) {
                                        if (TombstoneManager.isNativeCrash(file)) {
                                            XCrashHelper.m34396d(file, "", false);
                                        }
                                    }
                                }
                                XCrashHelper.m34394c(file, "", false);
                            }
                        } catch (Exception e) {
                            OLog.m34419e("Upload remain files failed", e);
                        }
                    }
                }).start();
            } catch (Exception e) {
                OLog.m34419e("XCrash init error", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m34395c(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                OLog.m34424w(str + "对应的ANR文件不存在");
                return;
            }
            m34394c(file, str2, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m34394c(File file, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle ");
        sb.append(z ? "realtime" : "unfinished");
        sb.append(" ANR, path:");
        sb.append(file);
        sb.append(" emergency:");
        sb.append(str);
        OLog.m34424w(sb.toString());
        try {
            ANRRecord createANRRecord = RecordFactory.createANRRecord(file.getAbsolutePath());
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_anr", MASConfig.UPPER_LIMIT_ANR_EVENT_PER_DAY);
            createANRRecord.takeLogCatWithAnrReason();
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.ANR, createANRRecord.getRecordId(), isUpperLimitByDay);
            if (!isUpperLimitByDay) {
                RecordStorage.save(createANRRecord);
                CommonUtil.addUpperLimitByDay("upper_limit_anr");
            }
        } catch (Exception e) {
            OLog.m34419e("handleAnr error", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m34397d(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                OLog.m34424w(str + "对应的Native Crash文件不存在");
                return;
            }
            m34396d(file, str2, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m34396d(File file, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle ");
        sb.append(z ? "realtime" : "unfinished");
        sb.append(" Native crash, path:");
        sb.append(file);
        sb.append(" emergency:");
        sb.append(str);
        OLog.m34424w(sb.toString());
        try {
            Map<String, String> parse = TombstoneParser.parse(file);
            String str2 = parse.get("signal");
            String str3 = parse.get("code");
            String str4 = parse.get(TombstoneParser.keyFaultAddr);
            String str5 = parse.get(TombstoneParser.keyBacktrace);
            boolean contains = !TextUtils.isEmpty(str5) ? str5.contains("/system/lib/libunwind.so") : false;
            OLog.m34424w("Crash reason: signal " + str2 + ", code " + str3 + " fault addr: " + str4 + "should ignore:" + contains);
            if (contains) {
                file.delete();
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
            synchronized (f48247a) {
                if (f48247a.size() > 0) {
                    objArr = f48247a.toArray();
                }
            }
            if (objArr != null) {
                for (Object obj : objArr) {
                    ((CrashCallbacks) obj).onCrash(hashMap);
                }
            }
            NativeCrashRecord createUnwindRecord = RecordFactory.createUnwindRecord(file);
            if (MASConfig.OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO) {
                createUnwindRecord.setAppMemoryInfo(MemUtil.getSimpleRuntimeMemInfo() + parse.get(TombstoneParser.keyProcessSummaryFromProcSmaps) + "\n-\n" + parse.get(TombstoneParser.keyFromProcStatus) + "\n-\n" + parse.get(TombstoneParser.keyFromProcLimits) + "\n-\n" + parse.get(TombstoneParser.keyProcessDetailsFromProcSmaps) + "\n-\n" + parse.get(TombstoneParser.keyProcessDalvikDetailsFromProcSmaps));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C3160Util.getCensusDalvikVmMemoryInfo());
                sb2.append(parse.get(TombstoneParser.keyFromProcMemInfo));
                createUnwindRecord.setSystemMemoryInfo(sb2.toString());
                createUnwindRecord.setProcessStatusInfo(parse.get(TombstoneParser.keyFromProcStatus));
                createUnwindRecord.setFdStatusInfo(FdUtil.censusFdInfo(parse.get(TombstoneParser.keyOpenFiles)));
                createUnwindRecord.setThreadStatusInfo(ThreadCollector.getCensusAllThreadInfo());
            }
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_native_crash", MASConfig.UPPER_LIMIT_NATIVE_CRASH_EVENT_PER_DAY);
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.NATIVE_CRASH, createUnwindRecord.getRecordId(), isUpperLimitByDay);
            if (!isUpperLimitByDay) {
                RecordStorage.save(createUnwindRecord);
                CommonUtil.addUpperLimitByDay("upper_limit_native_crash");
            }
        } catch (Exception e) {
            OLog.m34419e("handleNativeCrash error", e);
        }
    }

    public static void testJavaCrash(boolean z) throws RuntimeException {
        XCrash.testJavaCrash(z);
    }

    public static void testNativeCrash(boolean z) {
        XCrash.testNativeCrash(z);
    }

    public static void registerCrashCallbacks(CrashCallbacks crashCallbacks) {
        synchronized (f48247a) {
            f48247a.add(crashCallbacks);
        }
    }

    public static void unregisterCrashCallbacks(CrashCallbacks crashCallbacks) {
        synchronized (f48247a) {
            f48247a.remove(crashCallbacks);
        }
    }
}
