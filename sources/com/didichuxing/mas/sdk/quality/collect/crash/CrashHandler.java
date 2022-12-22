package com.didichuxing.mas.sdk.quality.collect.crash;

import android.os.Process;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.FdUtil;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.MemUtil;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector;
import com.didichuxing.mas.sdk.quality.report.record.CrashRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordFactory;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.DataTrackUtil;
import com.didichuxing.mas.sdk.quality.report.utils.FileType;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.lang.Thread;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import xcrash.AnrHandler;
import xcrash.C3160Util;
import xcrash.NativeHandler;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final String f47786a = ".oom.json";

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f47787b;

    /* renamed from: c */
    private JavaCrashCallback f47788c;

    private CrashHandler() {
        this.f47787b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static CrashHandler getInstance() {
        return CrashHandlerHolder.INSTANCE;
    }

    public void setCrashCallback(JavaCrashCallback javaCrashCallback) {
        this.f47788c = javaCrashCallback;
    }

    public void init() {
        OLog.m34420i("CrashHandler.init()....okay!");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (!MASConfig.TIMEOUT_EXCEPTION_CRASH_CATCH || !(th instanceof TimeoutException) || !thread.getName().equals("FinalizerWatchdogDaemon")) {
                handleException(thread, th);
            } else {
                Tracker.trackError("TimeoutException", th.getClass().getName(), th.getLocalizedMessage(), CommonUtil.getTraceInfo(th), (Map<String, Object>) null);
            }
        } catch (Throwable th2) {
            OLog.m34419e("Crashed again in handle exception!!!", th2);
            endApplication(thread, th);
        }
    }

    public void handleException(Thread thread, Throwable th) {
        if (th == null) {
            SystemUtils.log(6, "CrashHandler", "handleException Throwable is null", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.crash.CrashHandler", 94);
            endApplication(thread, th);
            return;
        }
        OmegaSDKAdapter.trackMasEvent("OMGCrash");
        CrashRecord createCrashRecord = RecordFactory.createCrashRecord();
        boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_crash", MASConfig.UPPER_LIMIT_CRASH_EVENT_PER_DAY);
        DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.CRASH, createCrashRecord.getRecordId(), isUpperLimitByDay);
        if (!isUpperLimitByDay) {
            NativeHandler.getInstance().notifyJavaCrashed();
            AnrHandler.getInstance().notifyJavaCrashed();
            createCrashRecord.setErrorType(th.getClass().getName());
            createCrashRecord.setErrorMsg(th.getMessage() == null ? "" : th.getMessage());
            createCrashRecord.takeLogcatWithCrashCheck(th.getClass().getName());
            createCrashRecord.setCurrentThreadCount(ThreadCollector.getCurrentThreadCount());
            createCrashRecord.setSysThreadCount(ThreadCollector.getSysThreadCountLimit());
            createCrashRecord.setErrorTrace(CommonUtil.getTraceInfo(th));
            createCrashRecord.setAllThreadStack(ThreadCollector.getAllThreadStacks());
            Map<String, Object> map = null;
            if (MASConfig.OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO) {
                createCrashRecord.setSystemMemoryInfo(C3160Util.getCensusDalvikVmMemoryInfo() + C3160Util.getSystemSummary());
                createCrashRecord.setAppMemoryInfo(MemUtil.getSimpleRuntimeMemInfo() + C3160Util.getProcessMemoryInfo() + "\n-\n" + C3160Util.getProcessStatus() + C3160Util.getProcessLimits());
                createCrashRecord.setThreadStatusInfo(ThreadCollector.getCensusAllThreadInfo());
                map = ThreadCollector.getCurrentFDList();
                createCrashRecord.setFdStatusInfo(FdUtil.censusFdInfo(map));
                createCrashRecord.setProcessStatusInfo(C3160Util.getProcessStatus());
            }
            if (!(th instanceof OutOfMemoryError)) {
                createCrashRecord.setFileType(FileType.JAVA_CRASH);
                saveDataAndExit(thread, th, createCrashRecord);
                return;
            }
            if (map == null) {
                map = ThreadCollector.getCurrentFDList();
            }
            createCrashRecord.setOOM(true);
            createCrashRecord.setFileType(FileType.OOM_CRASH);
            createCrashRecord.setCurrentFdCount(map.size());
            createCrashRecord.setSysFdCount(ThreadCollector.getSysFdCountLimit());
            createCrashRecord.setFdList(map);
            operateKOOMReport(thread, th, createCrashRecord);
        }
    }

    public void saveDataAndExit(Thread thread, Throwable th, CrashRecord crashRecord) {
        RecordStorage.save(crashRecord);
        CommonUtil.addUpperLimitByDay("upper_limit_crash");
        JavaCrashCallback javaCrashCallback = this.f47788c;
        if (javaCrashCallback != null) {
            try {
                javaCrashCallback.onCrash(thread, th);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        endApplication(thread, th);
    }

    public void operateKOOMReport(Thread thread, Throwable th, CrashRecord crashRecord) {
        getReportManually(crashRecord);
        saveDataAndExit(thread, th, crashRecord);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = new java.io.File(com.kwai.koom.javaoom.KOOM.getInstance().getReportDir());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getReportManually(com.didichuxing.mas.sdk.quality.report.record.CrashRecord r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x007f
            boolean r0 = com.didichuxing.mas.sdk.quality.report.MASConfig.SWITCH_UPLOAD_OOM_DUMP
            if (r0 != 0) goto L_0x0008
            goto L_0x007f
        L_0x0008:
            java.io.File r0 = new java.io.File
            com.kwai.koom.javaoom.KOOM r1 = com.kwai.koom.javaoom.KOOM.getInstance()
            java.lang.String r1 = r1.getReportDir()
            r0.<init>(r1)
            java.io.File[] r1 = r0.listFiles()
            if (r1 == 0) goto L_0x007f
            int r1 = r1.length
            if (r1 > 0) goto L_0x001f
            goto L_0x007f
        L_0x001f:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHHmmssSSS"
            r1.<init>(r2)
            java.io.File[] r0 = r0.listFiles()
            int r2 = r0.length
            r3 = 0
        L_0x002d:
            if (r3 >= r2) goto L_0x006f
            r4 = r0[r3]
            if (r4 == 0) goto L_0x006c
            boolean r5 = r4.exists()
            if (r5 == 0) goto L_0x006c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Date r6 = new java.util.Date
            r6.<init>()
            java.lang.String r6 = r1.format(r6)
            r5.append(r6)
            java.lang.String r6 = ".oom.json"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.io.File r6 = new java.io.File
            java.io.File r7 = com.didichuxing.mas.sdk.quality.report.record.RecordStorage.getRecordDir()
            r6.<init>(r7, r5)
            boolean r5 = r4.renameTo(r6)
            if (r5 == 0) goto L_0x0069
            r9.setDumpFile(r6)
            com.didichuxing.mas.sdk.quality.report.utils.FileUtil.deleteFile(r4)
            goto L_0x006c
        L_0x0069:
            r9.setDumpFile(r4)
        L_0x006c:
            int r3 = r3 + 1
            goto L_0x002d
        L_0x006f:
            java.io.File r9 = new java.io.File
            com.kwai.koom.javaoom.KOOM r0 = com.kwai.koom.javaoom.KOOM.getInstance()
            java.lang.String r0 = r0.getHprofDir()
            r9.<init>(r0)
            com.didichuxing.mas.sdk.quality.report.utils.FileUtil.deleteFile(r9)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.crash.CrashHandler.getReportManually(com.didichuxing.mas.sdk.quality.report.record.CrashRecord):void");
    }

    public void endApplication(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f47787b;
        if (uncaughtExceptionHandler == null || thread == null) {
            Process.killProcess(Process.myPid());
            System.exit(10);
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    private static class CrashHandlerHolder {
        /* access modifiers changed from: private */
        public static CrashHandler INSTANCE = new CrashHandler();

        private CrashHandlerHolder() {
        }
    }
}
