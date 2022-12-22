package com.didichuxing.alpha.crash;

import android.content.Context;
import android.os.Process;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.ThreadCollector;
import com.didichuxing.omega.sdk.common.record.CrashRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.DataTrackUtil;
import java.lang.Thread;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler instance;
    private final Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    private CrashHandler(Context context) {
        this.mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new CrashHandler(context);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (OmegaConfig.TIMEOUT_EXCEPTION_CRASH_CATCH && (th instanceof TimeoutException) && thread.getName().equals("FinalizerWatchdogDaemon")) {
                Tracker.trackError("TimeoutException", th.getClass().getName(), th.getLocalizedMessage(), CommonUtil.getTraceInfo(th), (Map<String, Object>) null);
            } else if (OmegaConfig.SWITCH_CRASH) {
                handleException(thread, th);
            }
        } catch (Throwable unused) {
            endApplication(thread, th);
        }
    }

    private void handleException(Thread thread, Throwable th) {
        Tracker.trackEvent("OMGCrash");
        CrashRecord createCrashRecord = RecordFactory.createCrashRecord();
        boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_crash", OmegaConfig.UPPER_LIMIT_CRASH_EVENT_PER_DAY);
        DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.CRASH, createCrashRecord.getRecordId(), isUpperLimitByDay);
        if (!isUpperLimitByDay) {
            createCrashRecord.setErrorType(th.getClass().getName());
            createCrashRecord.setErrorMsg(th.getMessage() == null ? "" : th.getMessage());
            createCrashRecord.takeLogcatWithCrashCheck(th.getClass().getName());
            if (th instanceof OutOfMemoryError) {
                Map<String, Object> currentFDList = ThreadCollector.getCurrentFDList();
                createCrashRecord.setCurrentFdCount(currentFDList.size());
                createCrashRecord.setSysFdCount(ThreadCollector.getSysFdCountLimit());
                createCrashRecord.setFdList(currentFDList);
            }
            createCrashRecord.setCurrentThreadCount(ThreadCollector.getCurrentThreadCount());
            createCrashRecord.setSysThreadCount(ThreadCollector.getSysThreadCountLimit());
            createCrashRecord.setErrorTrace(CommonUtil.getTraceInfo(th));
            createCrashRecord.setAllThreadStack(ThreadCollector.getAllThreadStacks());
            RecordStorage.save(createCrashRecord);
            CommonUtil.addUpperLimitByDay("upper_limit_crash");
            if (OmegaConfig.SWITCH_OOM_DUMP) {
                OutOfMemoryDumper.handleException(thread, th, createCrashRecord);
            }
            if (DumpHelper.isNeedDump(th)) {
                DumpHelper.dumpHprofFile(this.mContext, createCrashRecord.getRecordId());
            }
            endApplication(thread, th);
        }
    }

    public void endApplication(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultExceptionHandler;
        if (uncaughtExceptionHandler == null) {
            Process.killProcess(Process.myPid());
            System.exit(10);
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
